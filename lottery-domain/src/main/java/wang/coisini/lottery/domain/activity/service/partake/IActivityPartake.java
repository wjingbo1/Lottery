package wang.coisini.lottery.domain.activity.service.partake;

import wang.coisini.lottery.common.Result;
import wang.coisini.lottery.domain.activity.model.req.PartakeReq;
import wang.coisini.lottery.domain.activity.model.res.PartakeResult;
import wang.coisini.lottery.domain.activity.model.vo.InvoiceVO;
import wang.coisini.lottery.domain.strategy.model.vo.DrawOrderVO;

import java.util.List;

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

    /**
     * 保存奖品单
     * @param drawOrder 奖品单
     * @return          保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);

    /**
     * 更新发货单MQ状态
     *  @param uId      用户ID
     * @param orderId   订单ID
     * @param mqState   MQ 发送状态
     */
    void updateInvoiceMqState(String uId, Long orderId, Integer mqState);

    /**
     * 扫描发货单 MQ 状态，把未发送 MQ 的单子扫描出来，做补偿
     *
     * @param dbCount 指定分库
     * @param tbCount 指定分表
     * @return 发货单
     */
    List<InvoiceVO> scanInvoiceMqState(int dbCount, int tbCount);
}
