package wang.coisini.lottery.domain.rule.service.engine;

import wang.coisini.lottery.domain.rule.model.req.DecisionMatterReq;
import wang.coisini.lottery.domain.rule.model.res.EngineResult;

/**
 * @description: 规则过滤器引擎
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
public interface EngineFilter {

    /**
     * 规则过滤器接口
     *
     * @param matter      规则决策物料
     * @return            规则决策结果
     */
    EngineResult process(final DecisionMatterReq matter);

}
