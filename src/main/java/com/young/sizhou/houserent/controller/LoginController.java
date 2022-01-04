package com.young.sizhou.houserent.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.young.sizhou.houserent.entity.UsersEntity;
import com.young.sizhou.houserent.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/login")
	@ResponseBody
	public String toCustomerPage(String username,String password,HttpServletRequest req ) {
		UsersEntity user = new UsersEntity();
		user.setUName(username);
		user.setUPassword(password);
		UsersEntity loginUser = usersService.getOne(new QueryWrapper<UsersEntity>().eq("u_name",username).eq("u_password",password));
		if(loginUser!=null) {
			req.getSession().setAttribute("loginUser", loginUser);
			return "OK";
		}
		return "FAIL";
	}
	
	@RequestMapping("/signout")
	public String signout(HttpSession session) {
		session.invalidate();
		return "redirect:toIndexPage";
	}
	
	@RequestMapping("/regist")
	@ResponseBody
	public String regist(UsersEntity user) {
		UsersEntity exist = usersService.getOne(new QueryWrapper<UsersEntity>().eq("u_name", user.getUName()).or().eq("u_phone_number", user.getUPhoneNumber()));
		if(exist == null){
			usersService.save(user);
			return "OK";
		}
		return "FAIL";
	}
	
}
