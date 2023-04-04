package wang.coisini.lottery.domain.strategy.model.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author：w_jingbo
 * @date: 2023/4/1
 * @Copyright： 博客：http://coisini.wang
 */
@Data
@Builder
public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private Long awardId;

    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Integer awardType;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容「描述、奖品码、sku」
     */
    private String awardContent;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(Long awardId, Integer awardType, String awardName,String awardContent) {
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }




}