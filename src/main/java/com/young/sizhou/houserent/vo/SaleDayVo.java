package com.young.sizhou.houserent.vo;

import lombok.Data;

/**
 * @title: SaleDayVo
 * @projectName: sizhou-house-rent
 * @description: TODO
 * @author: SiZhou
 * @date: 2022/1/11 14:38
 */
@Data
public class SaleDayVo {
    private String[] day = new String[30];
    private Integer[] count = new Integer[30];
}
