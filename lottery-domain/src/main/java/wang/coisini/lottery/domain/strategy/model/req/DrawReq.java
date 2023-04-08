package wang.coisini.lottery.domain.strategy.model.req;

import lombok.Data;


@Data
public class DrawReq {

    // 用户ID
    private String uId;

    // 策略ID
    private Long strategyId;

    /**
     * 防重ID
     */
    private String uuid;

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    public DrawReq(String uId, Long strategyId, String uuid) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.uuid = uuid;
    }
}
