package com.young.sizhou.houserent.dao;

import com.young.sizhou.houserent.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.young.sizhou.houserent.vo.Page;
import com.young.sizhou.houserent.vo.UserOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author sizhou
 * @email 2313381768@qq.com
 * @date 2022-01-03 14:24:54
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

    List<UserOrder> findAllOrder(Page p);
}
