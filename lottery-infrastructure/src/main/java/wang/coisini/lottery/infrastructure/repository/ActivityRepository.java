package wang.coisini.lottery.infrastructure.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.domain.activity.model.vo.*;
import wang.coisini.lottery.domain.activity.repository.IActivityRepository;
import wang.coisini.lottery.infrastructure.dao.IActivityDao;
import wang.coisini.lottery.infrastructure.dao.IAwardDao;
import wang.coisini.lottery.infrastructure.dao.IStrategyDao;
import wang.coisini.lottery.infrastructure.dao.IStrategyDetailDao;
import wang.coisini.lottery.infrastructure.po.Activity;
import wang.coisini.lottery.infrastructure.po.Award;
import wang.coisini.lottery.infrastructure.po.Strategy;
import wang.coisini.lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
@Component
public class ActivityRepository implements IActivityRepository {


    @Resource
    private IActivityDao activityDao;
    @Resource
    private IAwardDao awardDao;
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityState) beforeState).getCode(),((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }
}
