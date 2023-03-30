package wang.coisini.lottery.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * 奖品
 */
@Data
public class Award {

    //自增id
    private Long id;

    //奖品id
    private Long awardId;

    //奖品类型[文字描述,兑换码,优惠券,实物]
    private Integer awardType;

    //奖品数量
    private Integer awardCount;

    //奖品名称
    private String awardName;

    //奖品内容[文字描述,Key,码]
    private String awardContent;

    // 创建时间
    private Date createTime;

    // 修改时间
    private Date updateTime;

}
