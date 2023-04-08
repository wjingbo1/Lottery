package wang.coisini.lottery.domain.activity.model.vo;

import lombok.Data;

/**
 * @description: 用户领取活动记录
 * @author: w_jingbo
 * @date: 2023/4/8
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class UserTakeActivityVO {

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 活动领取ID
     */
    private Long takeId;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动单使用状态 0未使用、1已使用
     * Constants.TaskState
     */
    private Integer state;

}
