package com.young.sizhou.houserent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("t_house")
public class HouseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@JsonProperty("hId")
	private Long hId;
	/**
	 * 租房描述
	 */
	@JsonProperty("houseDesc")
	private String houseDesc;
	/**
	 * 房屋类型，几室几厅
	 */
	@JsonProperty("houseModel")
	private String houseModel;
	/**
	 * 房屋面积
	 */
	@JsonProperty("houseArea")
	private String houseArea;
	/**
	 * 房屋楼层
	 */
	@JsonProperty("houseFloor")
	private String houseFloor;
	/**
	 * 出租方式
	 */
	@JsonProperty("houseType")
	private String houseType;
	/**
	 * 出租价格
	 */
	@JsonProperty("housePrice")
	private Integer housePrice;
	/**
	 * 出租地址
	 */
	@JsonProperty("houseAddress")
	private String houseAddress;
	/**
	 * 房屋简介照片
	 */
	@JsonProperty("houseImage")
	private String houseImage;
	/**
	 * 小区名字
	 */
	@JsonProperty("communityName")
	private String communityName;
	/**
	 * 房屋联系电话
	 */
	@JsonProperty("houseLinkMan")
	private String houseLinkMan;
	/**
	 * 房屋朝向
	 */
	@JsonProperty("houseOriented")
	private String houseOriented;
	/**
	 * 房屋详细页面展示图片
	 */
	@JsonProperty("houseDetailesImg")
	private String houseDetailesImg;
	/**
	 * 发布人
	 */
	@JsonProperty("publisher")
	private String publisher;
	/**
	 * 发布时间
	 */
	@JsonProperty("publishTime")
	private Date publishTime;
	/**
	 * 房屋出租情况 0 待出租 1 已出租
	 */
	private Integer status;
}
