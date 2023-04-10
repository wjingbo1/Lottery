package wang.coisini.lottery.domain.rule.service.logic.impl;

import org.springframework.stereotype.Component;
import wang.coisini.lottery.domain.rule.model.req.DecisionMatterReq;
import wang.coisini.lottery.domain.rule.service.logic.BaseLogic;

/**
 * @description:
 * @author: w_jingbo
 * @date: 2023/4/9
 * @Copyright: 博客：http://coisini.wang
 */
@Component
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }

}
