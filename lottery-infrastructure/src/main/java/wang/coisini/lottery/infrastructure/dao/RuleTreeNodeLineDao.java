package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.RuleTreeNodeLine;

import java.util.List;

/**
 * @description: 规则树节点连线DAO
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Mapper
public interface RuleTreeNodeLineDao {

    /**
     * 查询规则树节点连线集合
     * @param req   入参
     * @return      规则树节点连线集合
     */
    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    /**
     * 查询规则树连线数量
     *
     * @param treeId    规则树ID
     * @return          规则树连线数量
     */
    int queryTreeNodeLineCount(Long treeId);
}
