package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.Strategy;

@Mapper
public interface IStrategyDao {

    /**
     * 查询策略配置
     *
     * @param strategyId 策略ID
     * @return           策略配置信息
     */
    Strategy queryStrategy(Long strategyId);


    /**
     * 插入策略配置
     *
     * @param req 策略配置
     */
    void insert(Strategy req);

}
