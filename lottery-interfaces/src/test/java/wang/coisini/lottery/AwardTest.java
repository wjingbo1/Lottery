package wang.coisini.lottery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.domain.award.model.req.GoodsReq;
import wang.coisini.lottery.domain.award.model.res.DistributionRes;
import wang.coisini.lottery.domain.award.service.factory.DistributionGoodsFactory;
import wang.coisini.lottery.domain.award.service.goods.IDistributionGoods;
import wang.coisini.lottery.domain.strategy.model.req.DrawReq;
import wang.coisini.lottery.domain.strategy.model.res.DrawResult;
import wang.coisini.lottery.domain.strategy.model.vo.DrawAwardInfo;
import wang.coisini.lottery.domain.strategy.model.vo.DrawAwardVO;
import wang.coisini.lottery.domain.strategy.service.draw.IDrawExec;

import javax.annotation.Resource;

/**
 * @description: 测试奖品发放
 * @author: w_jingbo
 * @date: 2023/4/2
 * @Copyright: 博客：http://coisini.wang
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AwardTest {

    @Resource
    private DistributionGoodsFactory distributionGoodsFactory;

    @Resource
    private IDrawExec drawExec;

    private Logger logger = LoggerFactory.getLogger(AwardTest.class);

    @Test
    public void test1(){
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("王敬博",10001L));

        Integer drawState = drawResult.getDrawState();

        if(Constants.DrawState.FAIL.getCode().equals(drawState)){
            logger.info("未中奖 DrawAwardInfo is null");
            return;
        }

        DrawAwardVO drawAwardInfo = drawResult.getDrawAwardVO();
        GoodsReq goodsReq = new GoodsReq(drawResult.getUId(),213612734628L,drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(),drawAwardInfo.getAwardContent());

        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);
        logger.info("测试结果:{} ",distributionRes.toString());


    }




}
