package wang.coisini.lottery.domain.rule.model.res;

import lombok.Data;

/**
 * @description: 决策结果
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class EngineResult {

    /** 执行结果 */
    private boolean isSuccess;
    /** 用户ID */
    private String userId;
    /** 规则树ID */
    private Long treeId;
    /** 果实节点ID */
    private Long nodeId;
    /** 果实节点值 */
    private String nodeValue;

    public EngineResult() {
    }

    public EngineResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public EngineResult(String userId, Long treeId, Long nodeId, String nodeValue) {
        this.isSuccess = true;
        this.userId = userId;
        this.treeId = treeId;
        this.nodeId = nodeId;
        this.nodeValue = nodeValue;
    }
}
