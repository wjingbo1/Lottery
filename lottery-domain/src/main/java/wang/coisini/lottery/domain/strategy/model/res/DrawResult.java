package wang.coisini.lottery.domain.strategy.model.res;

import lombok.Data;

@Data
public class DrawResult {

    // 用户ID
    private Long uId;

    // 策略ID
    private Long strategyId;

    // 奖品ID
    private Long rewardId;

    // 奖品名称
    private String awardName;
}
