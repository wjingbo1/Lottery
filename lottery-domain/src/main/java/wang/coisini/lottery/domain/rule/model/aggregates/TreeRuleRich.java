package wang.coisini.lottery.domain.rule.model.aggregates;

import lombok.Data;
import wang.coisini.lottery.domain.rule.model.vo.TreeNodeVO;
import wang.coisini.lottery.domain.rule.model.vo.TreeRootVO;

import java.util.Map;

/**
 * @description: 规则树聚合
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class TreeRuleRich {

    /** 树根信息 */
    private TreeRootVO treeRoot;
    /** 树节点ID -> 子节点 */
    private Map<Long, TreeNodeVO> treeNodeMap;
}
