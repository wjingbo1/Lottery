package wang.coisini.lottery.infrastructure.repository;

import org.springframework.stereotype.Repository;
import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.domain.rule.model.aggregates.TreeRuleRich;
import wang.coisini.lottery.domain.rule.model.vo.TreeNodeLineVO;
import wang.coisini.lottery.domain.rule.model.vo.TreeNodeVO;
import wang.coisini.lottery.domain.rule.model.vo.TreeRootVO;
import wang.coisini.lottery.domain.rule.repository.IRuleRepository;
import wang.coisini.lottery.infrastructure.dao.RuleTreeDao;
import wang.coisini.lottery.infrastructure.dao.RuleTreeNodeDao;
import wang.coisini.lottery.infrastructure.dao.RuleTreeNodeLineDao;
import wang.coisini.lottery.infrastructure.po.RuleTree;
import wang.coisini.lottery.infrastructure.po.RuleTreeNode;
import wang.coisini.lottery.infrastructure.po.RuleTreeNodeLine;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 规则信息仓储服务
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Repository
public class RuleRepository implements IRuleRepository {

    @Resource
    private RuleTreeDao ruleTreeDao;
    @Resource
    private RuleTreeNodeDao ruleTreeNodeDao;
    @Resource
    private RuleTreeNodeLineDao ruleTreeNodeLineDao;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {

        // 规则树
        RuleTree ruleTree = ruleTreeDao.queryRuleTreeByTreeId(treeId);
        TreeRootVO treeRoot = new TreeRootVO();
        treeRoot.setTreeId(ruleTree.getId());
        treeRoot.setTreeRootNodeId(ruleTree.getTreeRootNodeId());
        treeRoot.setTreeName(ruleTree.getTreeName());

        // 树节点->树连接线
        Map<Long, TreeNodeVO> treeNodeMap = new HashMap<>();
        List<RuleTreeNode> ruleTreeNodeList = ruleTreeNodeDao.queryRuleTreeNodeList(treeId);
        for (RuleTreeNode treeNode : ruleTreeNodeList) {
            List<TreeNodeLineVO> treeNodeLineInfoList = new ArrayList<>();
            if (Constants.NodeType.STEM.equals(treeNode.getNodeType())) {

                RuleTreeNodeLine ruleTreeNodeLineReq = new RuleTreeNodeLine();
                ruleTreeNodeLineReq.setTreeId(treeId);
                ruleTreeNodeLineReq.setNodeIdFrom(treeNode.getId());
                List<RuleTreeNodeLine> ruleTreeNodeLineList = ruleTreeNodeLineDao.queryRuleTreeNodeLineList(ruleTreeNodeLineReq);

                for (RuleTreeNodeLine nodeLine : ruleTreeNodeLineList) {
                    TreeNodeLineVO treeNodeLineInfo = new TreeNodeLineVO();
                    treeNodeLineInfo.setNodeIdFrom(nodeLine.getNodeIdFrom());
                    treeNodeLineInfo.setNodeIdTo(nodeLine.getNodeIdTo());
                    treeNodeLineInfo.setRuleLimitType(nodeLine.getRuleLimitType());
                    treeNodeLineInfo.setRuleLimitValue(nodeLine.getRuleLimitValue());
                    treeNodeLineInfoList.add(treeNodeLineInfo);
                }
            }
            TreeNodeVO treeNodeInfo = new TreeNodeVO();
            treeNodeInfo.setTreeId(treeNode.getTreeId());
            treeNodeInfo.setTreeNodeId(treeNode.getId());
            treeNodeInfo.setNodeType(treeNode.getNodeType());
            treeNodeInfo.setNodeValue(treeNode.getNodeValue());
            treeNodeInfo.setRuleKey(treeNode.getRuleKey());
            treeNodeInfo.setRuleDesc(treeNode.getRuleDesc());
            treeNodeInfo.setTreeNodeLineInfoList(treeNodeLineInfoList);

            treeNodeMap.put(treeNode.getId(), treeNodeInfo);
        }

        TreeRuleRich treeRuleRich = new TreeRuleRich();
        treeRuleRich.setTreeRoot(treeRoot);
        treeRuleRich.setTreeNodeMap(treeNodeMap);

        return treeRuleRich;
    }
}
