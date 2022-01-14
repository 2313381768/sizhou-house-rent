package com.young.sizhou.houserent.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.young.sizhou.houserent.dao.OrderDao;
import com.young.sizhou.houserent.entity.OrderEntity;
import com.young.sizhou.houserent.service.OrderService;
import com.young.sizhou.houserent.utils.PageUtils;
import com.young.sizhou.houserent.vo.Page;
import com.young.sizhou.houserent.vo.SaleDayVo;
import com.young.sizhou.houserent.vo.UserOrder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
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

    @Override
    public SaleDayVo getOneMouthOrder() {
        SaleDayVo dayVo = new SaleDayVo();
        LocalDate cur = LocalDate.now();
        cur = cur.plusDays(-29);
        LocalTime startTime = LocalTime.MIN;
        LocalTime endTime = LocalTime.MAX;
        for(int i = 0; i < 30; i++){
            LocalDateTime start = LocalDateTime.of(cur, startTime);
            LocalDateTime end = LocalDateTime.of(cur, endTime);
            String format1 = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String format2 = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            int count = this.count(new QueryWrapper<OrderEntity>().between("order_time", format1, format2));
            String day = cur.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dayVo.getDay()[i] = day;
            dayVo.getCount()[i] = count;
            cur = cur.plusDays(1);
        }
        return dayVo;
    }
    public String getStart(Long day){
        //计算从当前开始，加上指定天数的时间
        //日期
        LocalDate nowDay = LocalDate.now();
        LocalDate pre = nowDay.plusDays(day);
        //时分秒
        LocalTime startTime = LocalTime.MIN;
        //组合日期和时分秒
        LocalDateTime start = LocalDateTime.of(pre, startTime);
        String format = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }
    public String getEnd(){
        LocalDate nowDay = LocalDate.now();
        LocalTime endTime = LocalTime.MAX;
        LocalDateTime end = LocalDateTime.of(nowDay, endTime);
        String format = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return format;
    }

}