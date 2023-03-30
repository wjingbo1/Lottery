package wang.coisini.lottery.domain.strategy.service.draw;

import wang.coisini.lottery.domain.strategy.model.req.DrawReq;
import wang.coisini.lottery.domain.strategy.model.res.DrawResult;

/**
 */
public interface IDrawExec {

    DrawResult doDrawExec(DrawReq req);

}
