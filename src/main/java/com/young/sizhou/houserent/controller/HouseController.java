package com.young.sizhou.houserent.controller;


import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.entity.UsersEntity;
import com.young.sizhou.houserent.service.HouseService;
import com.young.sizhou.houserent.vo.Page;
import com.young.sizhou.houserent.vo.UserHouseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/findUserHouse")
	@ResponseBody
	public UserHouseData houseByUser(HttpServletRequest request, int page, int limit) {
		Page p = new Page();
		UsersEntity u = (UsersEntity) request.getSession().getAttribute("loginUser");
		String publisher = u.getUName();
		p.setPublisher(publisher);
		p.setLimit(limit);
		p.setPage((page - 1) * limit);
		List<HouseEntity> list = houseService.findHouseByUser(p);
		UserHouseData data = new UserHouseData(0, "200", list.size(), list);
		return data;
	}
	
	@RequestMapping("/deleteUserHouse")
	@ResponseBody
	public String deleteUserHouse(String hID) {
		boolean b = houseService.removeById(Integer.parseInt(hID));
		if(b) {
			return "OK";
		}
		return "FAIL";
	}
	
	@PostMapping ("/updateHouse")
	@ResponseBody
	public String updateHouse(HouseEntity house) {
		boolean b = houseService.updateById(house);
		if(b)
			return "OK";
		return "FAIL";
	}
}
