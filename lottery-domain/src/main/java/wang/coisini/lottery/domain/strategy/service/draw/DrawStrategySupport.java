package wang.coisini.lottery.domain.strategy.service.draw;

import wang.coisini.lottery.domain.strategy.model.aggregates.StrategyRich;
import wang.coisini.lottery.domain.strategy.model.vo.AwardBriefVO;
import wang.coisini.lottery.domain.strategy.repository.IStrategyRepository;


import javax.annotation.Resource;

/**
 * @description: 抽奖策略数据支撑，一些通用的数据服务
 * @author:w_jingbo
 * @date: 2023/4/1
 * @Copyright： 博客：http://coisini.wang
 */
public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品ID
     * @return 中奖详情
     */
    protected AwardBriefVO queryAwardInfoByAwardId(Long awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }

}
