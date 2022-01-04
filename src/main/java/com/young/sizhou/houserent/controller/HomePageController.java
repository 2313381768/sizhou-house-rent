package com.young.sizhou.houserent.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomePageController {
	
	@Autowired
	private HouseService houseService;

	
	@RequestMapping(path = {"/","/toIndexPage"})
	public String toIndexPage(Model model) {
		List<HouseEntity> findHomeInfo = houseService.list();
		model.addAttribute("House", findHomeInfo);
		return "index";
	}
	
	@RequestMapping("/findHouseByLike")
	public String findHouseByLike(String keywords, Model model) {
		List<HouseEntity> findHomeInfo = houseService.findHouseByLike(keywords);
		model.addAttribute("House", findHomeInfo);
		return "index";
	}
	
	@RequestMapping("/findHousrOrderByAsc")
	public String findHousrOrderByAsc(Model model) {
		List<HouseEntity> findHomeInfo = houseService.list(new QueryWrapper<HouseEntity>().orderByAsc("house_price"));
		model.addAttribute("House", findHomeInfo);
		return "index";
	}
	
	@RequestMapping("/findHousrOrderByDesc")
	public String findHousrOrderByDesc(Model model) {
		List<HouseEntity> findHomeInfo = houseService.list(new QueryWrapper<HouseEntity>().orderByDesc("house_price"));
		model.addAttribute("House", findHomeInfo);
		return "index";
	}
}
