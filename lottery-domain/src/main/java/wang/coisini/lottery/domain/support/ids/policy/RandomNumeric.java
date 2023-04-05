package wang.coisini.lottery.domain.support.ids.policy;

import org.springframework.stereotype.Component;
import org.apache.commons.lang3.RandomStringUtils;
import wang.coisini.lottery.domain.support.ids.IIdGenerator;

/**
 * @description: 工具类生成 org.apache.commons.lang3.RandomStringUtils
 * @author: w_jingbo
 * @date: 2023/4/4
 * @Copyright: 博客：http://coisini.wang
 */

@Component
public class RandomNumeric implements IIdGenerator {

    @Override
    public long nextId() {
        //生成11位数字
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
