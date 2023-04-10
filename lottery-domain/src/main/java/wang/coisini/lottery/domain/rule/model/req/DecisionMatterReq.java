package wang.coisini.lottery.domain.rule.model.req;

import lombok.Data;

import java.util.Map;

/**
 * @description: 决策物料
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class DecisionMatterReq {

    /** 规则树ID */
    private Long treeId;
    /** 用户ID */
    private String userId;
    /** 决策值 */
    private Map<String, Object> valMap;
}
