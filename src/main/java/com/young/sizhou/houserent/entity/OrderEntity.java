package com.young.sizhou.houserent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 
 * 
 * @author sizhou
 * @email 2313381768@qq.com
 * @date 2022-01-03 14:24:54
 */
@Data
@TableName("t_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@JsonProperty("oId")
	private Long oId;
	/**
	 * 房屋租赁id
	 */
	@JsonProperty("hId")
	private Long hId;
	/**
	 * 用户id
	 */
	@JsonProperty("uId")
	private Long uId;
	/**
	 * 
	 */
	@JsonProperty("orderTime")
	private Date orderTime;
	/**
	 * 
	 */
	@JsonProperty("orderUser")
	private String orderUser;

}
