package wang.coisini.lottery.domain.award.service.goods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wang.coisini.lottery.domain.award.repository.IAwardRepository;

import javax.annotation.Resource;

/**
 * @description: 配送货物基础共用类
 * @author：w_jingbo
 * @date: 2023/4/2
 * @Copyright： 博客：http://coisini.wang
 */
public class DistributionBase {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, Long orderId, Long awardId, Integer awardState, String awardStateInfo) {
        // TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态
        logger.info("TODO 后期添加更新分库分表中，用户个人的抽奖记录表中奖品发奖状态 uId：{}", uId);
    }
}
