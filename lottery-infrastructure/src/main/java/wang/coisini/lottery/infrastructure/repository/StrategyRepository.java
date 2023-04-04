package wang.coisini.lottery.infrastructure.repository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import wang.coisini.lottery.domain.strategy.model.aggregates.StrategyRich;
import wang.coisini.lottery.domain.strategy.model.vo.AwardBriefVO;
import wang.coisini.lottery.domain.strategy.model.vo.StrategyBriefVO;
import wang.coisini.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;
import wang.coisini.lottery.domain.strategy.repository.IStrategyRepository;
import wang.coisini.lottery.infrastructure.dao.IAwardDao;
import wang.coisini.lottery.infrastructure.dao.IStrategyDao;
import wang.coisini.lottery.infrastructure.dao.IStrategyDetailDao;
import wang.coisini.lottery.infrastructure.po.Award;
import wang.coisini.lottery.infrastructure.po.Strategy;
import wang.coisini.lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);

        StrategyBriefVO strategyBriefVO = new StrategyBriefVO();
        BeanUtils.copyProperties(strategy, strategyBriefVO);

        List<StrategyDetailBriefVO> strategyDetailBriefVOList = new ArrayList<>();
        for (StrategyDetail strategyDetail : strategyDetailList) {
            StrategyDetailBriefVO strategyDetailBriefVO = new StrategyDetailBriefVO();
            BeanUtils.copyProperties(strategyDetail, strategyDetailBriefVO);
            strategyDetailBriefVOList.add(strategyDetailBriefVO);
        }

        return new StrategyRich(strategyId, strategyBriefVO, strategyDetailBriefVOList);
    }

    @Override
    public AwardBriefVO queryAwardInfo(Long awardId) {

        Award award = awardDao.queryAwardInfo(awardId);

        // 可以使用 BeanUtils.copyProperties(award, awardBriefVO)、或者基于ASM实现的Bean-Mapping，但在效率上最好的依旧是硬编码
        AwardBriefVO awardBriefVO = new AwardBriefVO();
        awardBriefVO.setAwardId(award.getAwardId());
        awardBriefVO.setAwardType(award.getAwardType());
        awardBriefVO.setAwardName(award.getAwardName());
        awardBriefVO.setAwardContent(award.getAwardContent());

        return awardBriefVO;
    }

    @Override
    public List<Long> queryNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, Long awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(req);
        return count == 1;
    }
}
