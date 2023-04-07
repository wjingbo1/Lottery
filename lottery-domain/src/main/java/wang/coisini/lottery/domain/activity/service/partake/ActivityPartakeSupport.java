package wang.coisini.lottery.domain.activity.service.partake;

import wang.coisini.lottery.domain.activity.model.req.PartakeReq;
import wang.coisini.lottery.domain.activity.model.vo.ActivityBillVO;
import wang.coisini.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @description: 活动领取模操作，一些通用的数据服务
 * @author: w_jingbo
 * @date: 2023/4/6
 * @Copyright: 博客：http://coisini.wang
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }

}
