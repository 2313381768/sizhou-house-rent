package com.young.sizhou.houserent.dao;

import com.young.sizhou.houserent.entity.HouseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.sizhou.houserent.vo.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author sizhou
 * @email 2313381768@qq.com
 * @date 2022-01-03 14:24:54
 */
@Mapper
public interface HouseDao extends BaseMapper<HouseEntity> {

    List<HouseEntity> findAllHouse(Page p);

    List<HouseEntity> findHouseByLike(String keywords);

    List<HouseEntity> findHouseByUser(Page p);

    void updateHouseStatus(@Param("hId") Long hId,@Param("status") int status);
}
