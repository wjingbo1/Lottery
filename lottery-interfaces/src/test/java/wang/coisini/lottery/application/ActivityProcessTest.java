package wang.coisini.lottery.application;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.coisini.lottery.application.process.IActivityProcess;
import wang.coisini.lottery.application.process.req.DrawProcessReq;
import wang.coisini.lottery.application.process.res.DrawProcessResult;

import javax.annotation.Resource;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/4/8
 * @Copyright: 博客：http://coisini.wang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityProcessTest {

    private Logger logger = LoggerFactory.getLogger(ActivityProcessTest.class);

    @Resource
    private IActivityProcess activityProcess;

    @Test
    public void test_doDrawProcess() {
        DrawProcessReq req = new DrawProcessReq();
        req.setUId("王敬博");
        req.setActivityId(100001L);
        DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(req);

        logger.info("请求入参：{}", JSON.toJSONString(req));
        logger.info("测试结果：{}", JSON.toJSONString(drawProcessResult));
    }

}
