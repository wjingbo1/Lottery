package wang.coisini.lottery.domain.activity.service.partake;

import wang.coisini.lottery.domain.activity.model.req.PartakeReq;
import wang.coisini.lottery.domain.activity.model.res.PartakeResult;

/**
 * @description: 抽奖活动参与接口
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param req 入参
     * @return    领取结果
     */
    PartakeResult doPartake(PartakeReq req);
}
