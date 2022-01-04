package com.young.sizhou.houserent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.young.sizhou.houserent.entity.OrderEntity;
import com.young.sizhou.houserent.utils.PageUtils;
import com.young.sizhou.houserent.vo.Page;
import com.young.sizhou.houserent.vo.UserOrder;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author sizhou
 * @email 2313381768@qq.com
 * @date 2022-01-03 14:24:54
 */
public interface OrderService extends IService<OrderEntity> {
    List<UserOrder> findAllOrder(Page p);
}

