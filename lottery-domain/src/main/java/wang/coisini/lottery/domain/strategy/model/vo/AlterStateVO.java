package wang.coisini.lottery.domain.strategy.model.vo;

import lombok.Data;

/**
 * @description: 变更活动状态对象
 * @author: w_jingbo
 * @date: 2023/4/8
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class AlterStateVO {

    /** 活动ID */
    private Long activityId;

    /** 更新前状态 */
    private Integer beforeState;

    /** 更新后状态 */
    private Integer afterState;

    public AlterStateVO() {
    }

    public AlterStateVO(Long activityId, Integer beforeState, Integer afterState) {
        this.activityId = activityId;
        this.beforeState = beforeState;
        this.afterState = afterState;
    }

}
