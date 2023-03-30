package wang.coisini.lottery.domain.strategy.model.aggregates;


import lombok.Data;
import wang.coisini.lottery.infrastructure.po.Strategy;
import wang.coisini.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

@Data
public class StrategyRich {

    // 策略ID
    private Long strategyId;

    // 策略配置
    private Strategy strategy;
    // 策略明细
    private List<StrategyDetail> strategyDetailList;


}
