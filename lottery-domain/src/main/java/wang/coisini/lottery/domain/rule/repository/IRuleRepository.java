package wang.coisini.lottery.domain.rule.repository;

import wang.coisini.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @description: 规则信息仓储服务接口
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
public interface IRuleRepository {

    /**
     * 查询规则决策树配置
     *
     * @param treeId    决策树ID
     * @return          决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);

}
