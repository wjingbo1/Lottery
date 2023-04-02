package wang.coisini.lottery;

import wang.coisini.lottery.domain.strategy.model.vo.AwardRateInfo;
import wang.coisini.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawAlgorithmTest {

    //@Resource(name = "defaultRateRandomDrawAlgorithm")
    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm randomDrawAlgorithm;

    @Before
    public void init() {
        // 奖品信息
        List<AwardRateInfo> strategyList = new ArrayList<>();
        strategyList.add(new AwardRateInfo(11L, new BigDecimal("0.05")));
        strategyList.add(new AwardRateInfo(22L, new BigDecimal("0.15")));
        strategyList.add(new AwardRateInfo(33L, new BigDecimal("0.20")));
        strategyList.add(new AwardRateInfo(44L, new BigDecimal("0.25")));
        strategyList.add(new AwardRateInfo(55L, new BigDecimal("0.35")));

        // 初始数据
        randomDrawAlgorithm.initRateTuple(100001L, strategyList);
    }

    @Test
    public void test_randomDrawAlgorithm() {

        List<Long> excludeAwardIds = new ArrayList<>();
        excludeAwardIds.add(33L);
        excludeAwardIds.add(44L);

        for (int i = 0; i < 20; i++) {
            System.out.println("中奖结果：" + randomDrawAlgorithm.randomDraw(100001L, excludeAwardIds));
        }

    }

}