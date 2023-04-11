package wang.coisini.lottery.rpc.req;

import lombok.Data;

import java.util.Map;

/**
 * @description: 量化人群抽奖请求参数
 * @author: w_jingbo
 * @date: 2023/4/10
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class QuantificationDrawReq {


    /** 用户ID */
    private String uId;
    /** 规则树ID */
    private Long treeId;
    /** 决策值 */
    private Map<String, Object> valMap;
}
