package wang.coisini.lottery.domain.strategy.service.draw;

import wang.coisini.lottery.domain.activity.model.vo.StrategyDetailVO;
import wang.coisini.lottery.domain.strategy.model.vo.AwardRateInfo;
import wang.coisini.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DrawBase extends DrawConfig {

    public void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailVO> strategyDetailList) {
        // 1:总体概率 2:单体概率
        if (1 != strategyMode) return;
        IDrawAlgorithm drawAlgorithm = drawAlgorithmGroup.get(strategyMode);

        boolean existRateTuple = drawAlgorithm.isExistRateTuple(strategyId);
        if (existRateTuple) return;

        List<AwardRateInfo> awardRateInfoList = new ArrayList<>(strategyDetailList.size());
        for (StrategyDetailVO strategyDetail : strategyDetailList) {
            awardRateInfoList.add(new AwardRateInfo(strategyDetail.getAwardId(),strategyDetail.getAwardRate()));
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);

    }

}