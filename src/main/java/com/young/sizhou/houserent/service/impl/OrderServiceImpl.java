package com.young.sizhou.houserent.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.young.sizhou.houserent.dao.OrderDao;
import com.young.sizhou.houserent.entity.OrderEntity;
import com.young.sizhou.houserent.service.OrderService;
import com.young.sizhou.houserent.utils.PageUtils;
import com.young.sizhou.houserent.vo.Page;
import com.young.sizhou.houserent.vo.UserOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;




@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Override
    public List<UserOrder> findAllOrder(Page p) {
        return this.baseMapper.findAllOrder(p);
    }

}