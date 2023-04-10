package wang.coisini.lottery.domain.rule.service.engine;

import wang.coisini.lottery.domain.rule.service.logic.LogicFilter;
import wang.coisini.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import wang.coisini.lottery.domain.rule.service.logic.impl.UserGenderFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 规则配置
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
public class EngineConfig {

    protected static Map<String, LogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    @Resource
    private UserAgeFilter userAgeFilter;
    @Resource
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init() {
        logicFilterMap.put("userAge", userAgeFilter);
        logicFilterMap.put("userGender", userGenderFilter);
    }

}
