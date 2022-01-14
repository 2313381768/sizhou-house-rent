package com.young.sizhou.houserent;

import com.young.sizhou.houserent.service.impl.OrderServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @title: Test
 * @projectName: sizhou-house-rent
 * @description: TODO
 * @author: SiZhou
 * @date: 2022/1/11 14:27
 */
public class Test {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        System.out.println(orderService.getStart(-29l));
        System.out.println(orderService.getEnd());
    }
}
