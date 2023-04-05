package wang.coisini.lottery.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wang.coisini.lottery.common.Constants;
import wang.coisini.lottery.domain.support.ids.IIdGenerator;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/4/4
 * @Copyright: 博客：http://coisini.wang
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SupportTest {


    private Logger logger = LoggerFactory.getLogger(SupportTest.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Test
    public void test_ids() {
        logger.info("雪花算法策略，生成ID：{}", idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        logger.info("日期算法策略，生成ID：{}", idGeneratorMap.get(Constants.Ids.ShortCode).nextId());
        logger.info("随机算法策略，生成ID：{}", idGeneratorMap.get(Constants.Ids.RandomNumeric).nextId());
    }
}
