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
@TableName("t_users")
public class UsersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@JsonProperty("uId")
	private Long uId;
	/**
	 * 
	 */
	@JsonProperty("uName")
	private String uName;
	/**
	 * 
	 */
	@JsonProperty("uPassword")
	private String uPassword;
	/**
	 * 用户注册手机号码，用于找回密码
	 */
	@JsonProperty("uPhoneNumber")
	private String uPhoneNumber;
	/**
	 * 昵称
	 */
	@JsonProperty("uNickname")
	private String uNickname;

}
