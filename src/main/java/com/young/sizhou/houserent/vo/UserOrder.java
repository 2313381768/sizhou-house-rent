package com.young.sizhou.houserent.vo;

import lombok.Data;

import java.util.Date;
@Data
public class UserOrder {
	private Long oID;
	private Long hID;
	private Date orderTime;
	private String orderUser;
	private String houseDesc;
	private String houseModel;
	private String houseArea;
	private String houseFloor;
	private String houseType;
	private Integer housePrice;
	private String houseAddress;
	private String houseImage;
	private String communityName;
	private String houseLinkMan;
	private String houseOriented;
}
