package wang.coisini.lottery.domain.strategy.model.vo;

/**
 * @description:
 * @author：w_jingbo
 * @date: 2023/4/1
 * @Copyright： 博客：http://coisini.wang
 */
public class DrawAwardInfo {

    /**
     * 奖品ID
     */
    private Long awardId;

    /**
     * 奖品名称
     */
    private String awardName;

    public DrawAwardInfo() {
    }

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public DrawAwardInfo(Long awardId, String awardName) {
        this.awardId = awardId;
        this.awardName = awardName;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}
