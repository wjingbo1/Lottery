package wang.coisini.lottery.rpc;

import wang.coisini.lottery.rpc.req.DrawReq;
import wang.coisini.lottery.rpc.req.QuantificationDrawReq;
import wang.coisini.lottery.rpc.res.DrawRes;

/**
 * @description: 抽奖活动展台接口
 * @author: w_jingbo
 * @date: 2023/4/10
 * @Copyright: 博客：http://coisini.wang
 */
public interface ILotteryActivityBooth {

    /**
     * 指定活动抽奖
     * @param drawReq 请求参数
     * @return        抽奖结果
     */
    DrawRes doDraw(DrawReq drawReq);

    /**
     * 量化人群抽奖
     * @param quantificationDrawReq 请求参数
     * @return                      抽奖结果
     */
    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);


}
