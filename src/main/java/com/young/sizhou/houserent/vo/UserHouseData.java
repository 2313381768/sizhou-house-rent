package com.young.sizhou.houserent.vo;

import com.young.sizhou.houserent.entity.HouseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserHouseData {
	private Integer code;

	private String msg;

	private Integer count;

	private List<HouseEntity> data;

}
