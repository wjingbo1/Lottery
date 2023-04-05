package wang.coisini.lottery.domain.support.ids.policy;

import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;
import wang.coisini.lottery.domain.support.ids.IIdGenerator;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

/**
 * @description: 短码生成策略，仅支持很小的调用量，用于生成活动配置类编号，保证全局唯一
 * @author: w_jingbo
 * @date: 2023/4/4
 * @Copyright: 博客：http://coisini.wang
 */
@Component
public class ShortCode implements IIdGenerator {

    @Override
    public synchronized long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 打乱排序：2020年为准 + 小时 + 周期 + 日 + 三位随机数
        StringBuilder idStr = new StringBuilder();
        idStr.append(year - 2020);
        idStr.append(hour);
        idStr.append(String.format("%02d", week));
        idStr.append(day);
        idStr.append(String.format("%03d", new Random().nextInt(1000)));

        return Long.parseLong(idStr.toString());
    }


}
