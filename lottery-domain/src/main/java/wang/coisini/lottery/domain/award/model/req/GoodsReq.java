package wang.coisini.lottery.domain.award.model.req;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wang.coisini.lottery.domain.award.model.vo.ShippingAddress;

/**
 * @description: 奖品发货信息
 * @author：w_jingbo
 * @date: 2023/4/2
 * @Copyright： 博客：http://coisini.wang
 */
@Data

public class GoodsReq {

    /** 用户ID */
    private String uId;

    /** 抽奖单号 ID */
    private String orderId;

    /** 奖品ID */
    private Long awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    /**
     * 奖品内容「描述、奖品码、sku」
     */
    private String awardContent;

    /** 送货地址（只有实物类商品需要地址） */
    private ShippingAddress shippingAddress;

    /** 扩展信息，用于一些个性商品发放所需要的透传字段内容 */
    private String extInfo;

    public GoodsReq(String uId, String orderId, Long awardId, String awardName, String awardContent) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }
}
