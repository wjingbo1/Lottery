package wang.coisini.lottery.domain.rule.model.vo;

import lombok.Data;

/**
 * @description: 规则树线信息
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class TreeNodeLineVO {

    /** 节点From */
    private Long nodeIdFrom;
    /** 节点To */
    private Long nodeIdTo;
    /** 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围] */
    private Integer ruleLimitType;
    /** 限定值 */
    private String ruleLimitValue;

}
