package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.UserTakeActivity;
import wang.coisini.middleware.db.router.annotation.DBRouter;

/**
 * @description: 用户领取活动表DAO
 * @author: w_jingbo
 * @date: 2023/4/5
 * @Copyright: 博客：http://coisini.wang
 */
@Mapper
public interface IUserTakeActivityDao {


    /**
     * 插入用户领取活动信息
     *
     * @param userTakeActivity 入参
     */
    @DBRouter(key = "UId")
    void insert(UserTakeActivity userTakeActivity);
}
