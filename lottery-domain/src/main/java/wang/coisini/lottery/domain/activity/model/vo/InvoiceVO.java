package wang.coisini.lottery.domain.activity.model.vo;

import lombok.Data;
import wang.coisini.lottery.domain.award.model.vo.ShippingAddress;

/**
 * @description: 中奖物品发货单，用于发送MQ消息，异步触达发货奖品给用户
 * @author: w_jingbo
 * @date: 2023/4/11
 * @Copyright: 博客：http://coisini.wang
 */
@Data
public class InvoiceVO {

    /** 用户ID */
    private String uId;

    /** 抽奖单号 ID */
    private Long orderId;

    /** 奖品ID */
    private Long awardId;

    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    private Integer awardType;

    /** 奖品名称 */
    private String awardName;

    /** 奖品内容「描述、奖品码、sku」 */
    private String awardContent;

    /** 四级送货地址（只有实物类商品需要地址） */
    private ShippingAddress shippingAddress;

    /** 扩展信息，用于一些个性商品发放所需要的透传字段内容 */
    private String extInfo;

}
