package wang.coisini.lottery.domain.activity.model.req;

import lombok.Data;

import java.util.Date;

/**
 * @description: 参与活动请求
 * @author: w_jingbo
 * @date: 2023/4/6
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class PartakeReq {

    /** 用户ID */
    private String uId;
    /** 活动ID */
    private Long activityId;
    /** 活动领取时间 */
    private Date partakeDate;

    public PartakeReq() {
    }

    public PartakeReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
        this.partakeDate = new Date();
    }

    public PartakeReq(String uId, Long activityId, Date partakeDate) {
        this.uId = uId;
        this.activityId = activityId;
        this.partakeDate = partakeDate;
    }
}
