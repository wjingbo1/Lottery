package wang.coisini.lottery.domain.strategy.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AwardRateInfo {
    // 奖品ID
    private Long awardId;

    // 中奖概率
    private BigDecimal awardRate;

    public AwardRateInfo(Long awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

}
