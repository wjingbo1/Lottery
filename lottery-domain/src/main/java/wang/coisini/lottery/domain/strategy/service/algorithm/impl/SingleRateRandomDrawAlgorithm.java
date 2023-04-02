package wang.coisini.lottery.domain.strategy.service.algorithm.impl;

import wang.coisini.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * 【推荐】单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public Long randomDraw(Long strategyId, List<Long> excludeAwardIds) {

        // 获取策略对应的元祖
        Long[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // 随机索引
        int randomVal = new SecureRandom().nextInt(100) + 1;
        int idx = super.hashIdx(randomVal);

        // 返回结果
        Long awardId = rateTuple[idx];
        if (excludeAwardIds.contains(awardId)) {
            return null;
        }

        return awardId;
    }

}
