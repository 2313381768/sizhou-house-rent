package com.young.sizhou.houserent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.utils.PageUtils;
import com.young.sizhou.houserent.vo.Page;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author sizhou
 * @email 2313381768@qq.com
 * @date 2022-01-03 14:24:54
 */
public interface HouseService extends IService<HouseEntity> {

    List<HouseEntity> findAllHouse(Page p);

    List<HouseEntity> findHouseByLike(String keywords);

    List<HouseEntity> findHouseByUser(Page p);

    void updateHouseStatus(Long hId,int status);
}

