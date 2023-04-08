package wang.coisini.lottery.application.process;

import wang.coisini.lottery.application.process.req.DrawProcessReq;
import wang.coisini.lottery.application.process.res.DrawProcessResult;

/**
 * @description: 活动抽奖流程编排接口
 * @author: w_jingbo
 * @date: 2023/4/8
 * @Copyright: 博客：http://coisini.wang
 */
public interface IActivityProcess {

    /**
     * 执行抽奖流程
     * @param req 抽奖请求
     * @return    抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
