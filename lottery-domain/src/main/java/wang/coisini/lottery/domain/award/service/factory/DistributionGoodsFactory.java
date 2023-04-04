package wang.coisini.lottery.domain.award.service.factory;

import org.springframework.stereotype.Service;
import wang.coisini.lottery.domain.award.service.goods.IDistributionGoods;

/**
 * @description: 配送商品简单工厂，提供获取配送服务
 * @author: w_jingbo
 * @date: 2023/4/2
 * @Copyright: 博客：http://coisini.wang
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{
    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}
