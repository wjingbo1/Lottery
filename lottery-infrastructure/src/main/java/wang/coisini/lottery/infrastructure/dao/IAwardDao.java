package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.Award;

@Mapper
public interface IAwardDao {
    Award queryAwardInfo(Long awardId);
}
