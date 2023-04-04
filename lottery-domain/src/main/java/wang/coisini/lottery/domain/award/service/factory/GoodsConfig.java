package wang.coisini.lottery.domain.award.service.factory;

import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.domain.award.service.goods.IDistributionGoods;
import wang.coisini.lottery.domain.award.service.goods.impl.CouponGoods;
import wang.coisini.lottery.domain.award.service.goods.impl.DescGoods;
import wang.coisini.lottery.domain.award.service.goods.impl.PhysicalGoods;
import wang.coisini.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 各类发奖奖品配置类
 * @author: w_jingbo
 * @date: 2023/4/2
 * @Copyright: 博客：http://coisini.wang
 */
public class GoodsConfig {

    /** 奖品发放策略组 */
    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @PostConstruct
    public void init() {
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.RedeemCodeGoods.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.CouponGoods.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PhysicalGoods.getCode(), physicalGoods);
    }
}
