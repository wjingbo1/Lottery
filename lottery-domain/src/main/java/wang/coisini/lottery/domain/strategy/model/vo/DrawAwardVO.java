package wang.coisini.lottery.domain.strategy.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @description: 中奖奖品信息
 * @author: w_jingbo
 * @date: 2023/4/10
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class DrawAwardVO {

    /**
     * 用户ID
     */
    private String uId;

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

    /**
     * 策略方式（1:单项概率、2:总体概率）
     */
    private Integer strategyMode;

    /**
     * 发放奖品方式（1:即时、2:定时[含活动结束]、3:人工）
     */
    private Integer grantType;
    /**
     * 发奖时间
     */
    private Date grantDate;

    public DrawAwardVO() {
    }

    public DrawAwardVO(String uId, Long awardId, Integer awardType, String awardName, String awardContent) {
        this.uId = uId;
        this.awardId = awardId;
        this.awardType = awardType;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

}
