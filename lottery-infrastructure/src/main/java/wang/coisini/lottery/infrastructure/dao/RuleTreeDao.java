package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.RuleTree;

/**
 * @description: 规则树配置DAO
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Mapper
public interface RuleTreeDao {

    /**
     * 规则树查询
     * @param id ID
     * @return   规则树
     */
    RuleTree queryRuleTreeByTreeId(Long id);

    /**
     * 规则树简要信息查询
     * @param treeId 规则树ID
     * @return       规则树
     */
    RuleTree queryTreeSummaryInfo(Long treeId);

}
