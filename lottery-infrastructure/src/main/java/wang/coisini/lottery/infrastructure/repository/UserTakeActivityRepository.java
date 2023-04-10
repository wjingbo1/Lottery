package wang.coisini.lottery.infrastructure.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import wang.coisini.lottery.domain.activity.model.vo.UserTakeActivityVO;
import wang.coisini.lottery.domain.activity.repository.IUserTakeActivityRepository;
import wang.coisini.lottery.domain.strategy.model.vo.DrawOrderVO;
import wang.coisini.lottery.infrastructure.dao.IUserStrategyExportDao;
import wang.coisini.lottery.infrastructure.dao.IUserTakeActivityCountDao;
import wang.coisini.lottery.infrastructure.dao.IUserTakeActivityDao;
import wang.coisini.lottery.infrastructure.po.UserStrategyExport;
import wang.coisini.lottery.infrastructure.po.UserTakeActivity;
import wang.coisini.lottery.infrastructure.po.UserTakeActivityCount;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @description: 用户参与活动仓储
 * @author: w_jingbo
 * @date: 2023/4/6
 * @Copyright: 博客：http://coisini.wang
 */

@Repository
public class UserTakeActivityRepository implements IUserTakeActivityRepository {

    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Resource
    private IUserStrategyExportDao userStrategyExportDao;


    @Override
    public int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate) {
        if (null == userTakeLeftCount) {
            UserTakeActivityCount userTakeActivityCount = new UserTakeActivityCount();
            userTakeActivityCount.setUId(uId);
            userTakeActivityCount.setActivityId(activityId);
            userTakeActivityCount.setTotalCount(takeCount);
            userTakeActivityCount.setLeftCount(takeCount - 1);
            userTakeActivityCountDao.insert(userTakeActivityCount);
            return 1;
        } else {
            UserTakeActivityCount userTakeActivityCount = new UserTakeActivityCount();
            userTakeActivityCount.setUId(uId);
            userTakeActivityCount.setActivityId(activityId);
            return userTakeActivityCountDao.updateLeftCount(userTakeActivityCount);
        }
    }

    @Override
    public void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUId(uId);
        userTakeActivity.setTakeId(takeId);
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setActivityName(activityName);
        userTakeActivity.setTakeDate(takeDate);
        userTakeActivity.setState(0);
        if (null == userTakeLeftCount) {
            userTakeActivity.setTakeCount(1);
        } else {
            userTakeActivity.setTakeCount(takeCount - userTakeLeftCount);
        }
        String uuid = uId + "_" + activityId + "_" + userTakeActivity.getTakeCount();
        userTakeActivity.setUuid(uuid);

        userTakeActivityDao.insert(userTakeActivity);
    }

    @Override
    public UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId) {

        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUId(uId);
        userTakeActivity.setActivityId(activityId);
        UserTakeActivity noConsumedTakeActivityOrder = userTakeActivityDao.queryNoConsumedTakeActivityOrder(userTakeActivity);

        // 未查询到符合的领取单，直接返回 NULL
        if (null == noConsumedTakeActivityOrder) {
            return null;
        }

        UserTakeActivityVO userTakeActivityVO = new UserTakeActivityVO();
        userTakeActivityVO.setActivityId(noConsumedTakeActivityOrder.getActivityId());
        userTakeActivityVO.setTakeId(noConsumedTakeActivityOrder.getTakeId());
        userTakeActivityVO.setStrategyId(noConsumedTakeActivityOrder.getStrategyId());
        userTakeActivityVO.setState(noConsumedTakeActivityOrder.getState());

        return userTakeActivityVO;
    }

    @Override
    public int lockTackActivity(String uId, Long activityId, Long takeId) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUId(uId);
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setTakeId(takeId);
        return userTakeActivityDao.lockTackActivity(userTakeActivity);
    }

    @Override
    public void saveUserStrategyExport(DrawOrderVO drawOrder) {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setUId(drawOrder.getUId());
        userStrategyExport.setActivityId(drawOrder.getActivityId());
        userStrategyExport.setOrderId(drawOrder.getOrderId());
        userStrategyExport.setStrategyId(drawOrder.getStrategyId());
        userStrategyExport.setStrategyMode(drawOrder.getStrategyMode());
        userStrategyExport.setGrantType(drawOrder.getGrantType());
        userStrategyExport.setGrantDate(drawOrder.getGrantDate());
        userStrategyExport.setGrantState(drawOrder.getGrantState());
        userStrategyExport.setAwardId(drawOrder.getAwardId());
        userStrategyExport.setAwardType(drawOrder.getAwardType());
        userStrategyExport.setAwardName(drawOrder.getAwardName());
        userStrategyExport.setAwardContent(drawOrder.getAwardContent());
        userStrategyExport.setUuid(String.valueOf(drawOrder.getOrderId()));

        userStrategyExportDao.insert(userStrategyExport);
    }



}
