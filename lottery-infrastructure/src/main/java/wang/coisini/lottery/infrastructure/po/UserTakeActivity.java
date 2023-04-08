package wang.coisini.lottery.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * @description: 用户领取活动表
 * @author: w_jingbo
 * @date: 2023/4/5
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class UserTakeActivity {

    /**
     * 自增ID
     */
    private Long id;
    /**
     * 用户ID
     */
    private String uId;
    /**
     * 活动领取ID
     */
    private Long takeId;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动名称
     */
    private String activityName;
    /**
     * 活动领取时间
     */
    private Date takeDate;
    /**
     * 领取次数
     */
    private Integer takeCount;

    /**
     * 策略ID
     */
    private Long strategyId;

    /**
     * 活动单使用状态 0未使用、1已使用
     * Constants.TaskState
     */
    private Integer state;

    /**
     * 防重ID
     */
    private String uuid;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
