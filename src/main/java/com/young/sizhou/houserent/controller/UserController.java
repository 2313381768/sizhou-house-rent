package com.young.sizhou.houserent.controller;

import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.entity.UsersEntity;
import com.young.sizhou.houserent.service.HouseService;
import com.young.sizhou.houserent.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
	
	@Autowired
	private UsersService usersService;
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/toUserSystem")
	public String toUserSystemPage() {
		return "customer";
	}
	
	@RequestMapping("/toUserRentalPage")
	public String toUserRentalPage() {
		return "myrental";
	}
	
	@RequestMapping("/welcome")
	public String toWelcomePage() {
		return "welcome";
	}
	
	@RequestMapping("/toUpdateHousePage")
	public String toUpdatePage(Long hID, Model model) {
		HouseEntity house = houseService.getById(hID);
		model.addAttribute("House", house);
		System.out.println(house);
		return "updatehouse";
	}
	
	@RequestMapping("/updateUserPwd")
	@ResponseBody
	public String updateUserPwd(String id,String newPwd,String oldPwd) {
		UsersEntity checkUser = usersService.getById(Integer.parseInt(id));

		if(checkUser!=null && checkUser.getUPassword().equals(oldPwd)) {
			checkUser.setUPassword(newPwd);
			boolean b = usersService.updateById(checkUser);
			if(b) {
				return "OK";
			}
		}
		return "FAIL";
	}
}
