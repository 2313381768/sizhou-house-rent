package com.young.sizhou.houserent.vo;

import lombok.Data;

import java.util.List;
@Data
public class UserOrderData {
	private Integer code;

	private String msg;

	private Integer count;

	private List<UserOrder> data;

}
