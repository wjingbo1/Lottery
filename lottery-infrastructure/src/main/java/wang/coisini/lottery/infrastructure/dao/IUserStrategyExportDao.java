package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.UserStrategyExport;
import wang.coisini.middleware.db.router.annotation.DBRouter;
import wang.coisini.middleware.db.router.annotation.DBRouterStrategy;

import java.util.List;

/**
 * @description: 用户策略计算结果表DAO
 * @author: w_jingbo
 * @date: 2023/4/5
 * @Copyright: 博客：http://coisini.wang
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {


    /**
     * 新增数据
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "UId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);

    /**
     * 更新发奖状态
     * @param userStrategyExport 发奖信息
     */
    @DBRouter
    void updateUserAwardState(UserStrategyExport userStrategyExport);

    /**
     * 更新发送MQ状态
     * @param userStrategyExport 发送消息
     */
    @DBRouter
    void updateInvoiceMqState(UserStrategyExport userStrategyExport);


    /**
     * 扫描发货单 MQ 状态，把未发送 MQ 的单子扫描出来，做补偿
     *
     * @return 发货单
     */
    List<UserStrategyExport> scanInvoiceMqState();
}
