package wang.coisini.lottery.domain.activity.model.req;

import lombok.Data;
import wang.coisini.lottery.domain.activity.model.aggregates.ActivityConfigRich;

/**
 * @description: 活动配置请求对象
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class ActivityConfigReq {

    /** 活动ID */
    private Long activityId;

    /** 活动配置信息 */
    private ActivityConfigRich activityConfigRich;

    public ActivityConfigReq() {
    }

    public ActivityConfigReq(Long activityId, ActivityConfigRich activityConfigRich) {
        this.activityId = activityId;
        this.activityConfigRich = activityConfigRich;
    }
}
