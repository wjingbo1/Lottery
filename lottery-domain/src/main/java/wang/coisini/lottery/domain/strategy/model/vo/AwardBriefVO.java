package wang.coisini.lottery.domain.strategy.model.vo;

import lombok.Data;

/**
 * @description: 奖品简要信息
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class AwardBriefVO {


    /** 奖品ID */
    private Long awardId;

    /** 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品） */
    private Integer awardType;

    /** 奖品名称 */
    private String awardName;

    /** 奖品内容「描述、奖品码、sku」 */
    private String awardContent;
}
