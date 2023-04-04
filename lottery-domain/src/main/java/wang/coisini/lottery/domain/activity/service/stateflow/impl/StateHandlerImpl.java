package wang.coisini.lottery.domain.activity.service.stateflow.impl;

import org.springframework.stereotype.Service;
import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.common.Result;
import wang.coisini.lottery.domain.activity.service.stateflow.IStateHandler;
import wang.coisini.lottery.domain.activity.service.stateflow.StateConfig;

/**
 * @description: 状态处理服务
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {


    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).arraignment(activityId, currentStatus);
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkPass(activityId, currentStatus);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkRefuse(activityId, currentStatus);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).checkRevoke(activityId, currentStatus);
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).close(activityId, currentStatus);
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).open(activityId, currentStatus);
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentStatus) {
        return stateGroup.get(currentStatus).doing(activityId, currentStatus);
    }
}
