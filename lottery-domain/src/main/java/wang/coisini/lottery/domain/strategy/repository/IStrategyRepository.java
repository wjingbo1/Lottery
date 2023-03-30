package wang.coisini.lottery.domain.strategy.repository;

import wang.coisini.lottery.domain.strategy.model.aggregates.StrategyRich;
import wang.coisini.lottery.infrastructure.po.Award;

public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(Long awardId);
}
