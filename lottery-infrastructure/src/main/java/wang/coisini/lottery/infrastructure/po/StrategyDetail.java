package wang.coisini.lottery.infrastructure.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 策略明细
 */
@Data
public class StrategyDetail {

    //自增id
    private Long id;

    //策略id
    private Long strategyId;

    // 奖品id
    private Long awardId;

    //奖品数量
    private Integer awardCount;

    //中奖概率
    private BigDecimal awardRate;

    // 创建时间
    private String createTime;

    // 修改时间
    private String updateTime;



}
