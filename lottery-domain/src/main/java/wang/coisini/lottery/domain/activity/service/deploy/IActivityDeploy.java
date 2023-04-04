package wang.coisini.lottery.domain.activity.service.deploy;

import wang.coisini.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @description: 部署活动配置接口
 * @author: w_jingbo
 * @date: 2023/4/3
 * @Copyright: 博客：http://coisini.wang
 */
public interface IActivityDeploy {

    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);


}
