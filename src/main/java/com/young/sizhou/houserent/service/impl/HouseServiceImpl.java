package com.young.sizhou.houserent.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.young.sizhou.houserent.dao.HouseDao;
import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.service.HouseService;
import com.young.sizhou.houserent.utils.PageUtils;
import com.young.sizhou.houserent.vo.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;



@Service("houseService")
public class HouseServiceImpl extends ServiceImpl<HouseDao, HouseEntity> implements HouseService {

    @Override
    public List<HouseEntity> findAllHouse(Page p) {
        return this.baseMapper.findAllHouse(p);
    }

    @Override
    public List<HouseEntity> findHouseByLike(String keywords) {
        return this.baseMapper.findHouseByLike(keywords);
    }

    @Override
    public List<HouseEntity> findHouseByUser(Page p) {
        return this.baseMapper.findHouseByUser(p);
    }

    @Override
    public void updateHouseStatus(Long hId, int status) {
        this.baseMapper.updateHouseStatus(hId,status);
    }

}