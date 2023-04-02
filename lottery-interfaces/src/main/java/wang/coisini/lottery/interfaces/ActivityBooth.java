package wang.coisini.lottery.interfaces;

import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.common.Result;
import wang.coisini.lottery.infrastructure.dao.IActivityDao;
import wang.coisini.lottery.infrastructure.po.Activity;
import wang.coisini.lottery.rpc.IActivityBooth;
import wang.coisini.lottery.rpc.dto.ActivityDto;
import wang.coisini.lottery.rpc.req.ActivityReq;
import wang.coisini.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**

 * 活动展台
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }

}
