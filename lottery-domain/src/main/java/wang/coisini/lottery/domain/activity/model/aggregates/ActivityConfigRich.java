package wang.coisini.lottery.domain.activity.model.aggregates;

import lombok.Data;
import wang.coisini.lottery.domain.activity.model.vo.ActivityVO;
import wang.coisini.lottery.domain.activity.model.vo.AwardVO;
import wang.coisini.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @description: 活动配置聚合信息
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class ActivityConfigRich {

    /** 活动配置 */
    private ActivityVO activity;

    /** 策略配置(含策略明细) */
    private StrategyVO strategy;

    /** 奖品配置 */
    private List<AwardVO> awardList;

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardList = awardList;
    }
}
