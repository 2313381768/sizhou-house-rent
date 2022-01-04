package com.young.sizhou.houserent.vo;

import com.young.sizhou.houserent.entity.UsersEntity;
import lombok.Data;

import java.util.List;
@Data
public class UserData {
	private int code;

	private String msg;

	private int count;

	private List<UsersEntity> data;
}
