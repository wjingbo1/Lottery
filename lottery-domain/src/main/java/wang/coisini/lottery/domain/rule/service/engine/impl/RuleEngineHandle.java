package wang.coisini.lottery.domain.rule.service.engine.impl;

import org.springframework.stereotype.Service;
import wang.coisini.lottery.domain.rule.model.aggregates.TreeRuleRich;
import wang.coisini.lottery.domain.rule.model.req.DecisionMatterReq;
import wang.coisini.lottery.domain.rule.model.res.EngineResult;
import wang.coisini.lottery.domain.rule.model.vo.TreeNodeVO;
import wang.coisini.lottery.domain.rule.repository.IRuleRepository;
import wang.coisini.lottery.domain.rule.service.engine.EngineBase;

import javax.annotation.Resource;

/**
 * @description: 规则引擎处理器
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase{

    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        // 决策规则树
        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) {
            throw new RuntimeException("Tree Rule is null!");
        }

        // 决策节点
        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);

        // 决策结果
        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }

}
