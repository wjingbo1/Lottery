package wang.coisini.lottery.domain.award.service.goods.impl;

import org.springframework.stereotype.Component;
import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.domain.award.model.req.GoodsReq;
import wang.coisini.lottery.domain.award.model.res.DistributionRes;
import wang.coisini.lottery.domain.award.service.goods.DistributionBase;
import wang.coisini.lottery.domain.award.service.goods.IDistributionGoods;

/**
 * @description: 实物发货类商品
 * @author：w_jingbo
 * @date: 2023/4/2
 * @Copyright： 博客：http://coisini.wang
 */
@Component
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // 模拟调用实物发奖
        logger.info("模拟调用实物发奖 uId：{} awardContent：{}", req.getUId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getUId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getUId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.PhysicalGoods.getCode();
    }
}
