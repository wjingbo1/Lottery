package wang.coisini.lottery.domain.strategy.repository.impl;

import org.springframework.stereotype.Component;
import wang.coisini.lottery.domain.strategy.model.aggregates.StrategyRich;
import wang.coisini.lottery.domain.strategy.repository.IStrategyRepository;
import wang.coisini.lottery.infrastructure.dao.IAwardDao;
import wang.coisini.lottery.infrastructure.dao.IStrategyDao;
import wang.coisini.lottery.infrastructure.dao.IStrategyDetailDao;
import wang.coisini.lottery.infrastructure.po.Award;
import wang.coisini.lottery.infrastructure.po.Strategy;
import wang.coisini.lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.List;

/**
 * 对抽奖策略的数据库操作
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
        //查询策略
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        //查询策略细节
        List<StrategyDetail> strategyDetails = strategyDetailDao.queryStrategyDetailList(strategyId);
        //封装聚合对象
        StrategyRich strategyRich = new StrategyRich();
        strategyRich.setStrategy(strategy);
        strategyRich.setStrategyDetailList(strategyDetails);
        strategyRich.setStrategyId(strategyId);
        return strategyRich;
    }

    @Override
    public Award queryAwardInfo(Long awardId) {
        Award award = awardDao.queryAwardInfo(awardId);
        return award;
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
