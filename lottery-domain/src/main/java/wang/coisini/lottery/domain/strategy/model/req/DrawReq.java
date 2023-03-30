package wang.coisini.lottery.domain.strategy.model.req;

import lombok.Data;


@Data
public class DrawReq {

    // 用户ID
    private Long uId;

    // 策略ID
    private Long strategyId;

    public DrawReq(Long uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }
}
