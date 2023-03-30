package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.Strategy;

@Mapper
public interface IStrategyDao {
    //查询抽奖策略
    Strategy queryStrategy(Long strategyId);
}
