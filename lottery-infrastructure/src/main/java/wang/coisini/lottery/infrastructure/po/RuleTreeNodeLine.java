package wang.coisini.lottery.infrastructure.po;

import lombok.Data;

/**
 * @description: 规则树节点连线
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class RuleTreeNodeLine {

    /** 主键ID */
    private Long id;
    /** 规则树ID */
    private Long treeId;
    /** 节点From */
    private Long nodeIdFrom;
    /** 节点To */
    private Long nodeIdTo;
    /** 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围] */
    private Integer ruleLimitType;
    /** 限定值 */
    private String ruleLimitValue;

}
