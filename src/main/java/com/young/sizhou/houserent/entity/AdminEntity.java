package com.young.sizhou.houserent.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author sizhou
 * @email 2313381768@qq.com
 * @date 2022-01-03 14:24:54
 */
@Data
@TableName("t_admin")
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	@JsonProperty("id")
	private Long id;
	/**
	 * 
	 */
	@JsonProperty("username")
	private String username;
	/**
	 * 
	 */
	@JsonProperty("userpwd")
	private String userpwd;

}
