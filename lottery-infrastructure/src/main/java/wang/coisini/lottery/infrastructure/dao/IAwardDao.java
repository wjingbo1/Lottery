package wang.coisini.lottery.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import wang.coisini.lottery.infrastructure.po.Award;

import java.util.List;

@Mapper
public interface IAwardDao {

    /**
     * 查询奖品信息
     *
     * @param awardId 奖品ID
     * @return        奖品信息
     */
    Award queryAwardInfo(Long awardId);

    /**
     * 插入奖品配置
     *
     * @param list 奖品配置
     */
    void insertList(List<Award> list);
}
