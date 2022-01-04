package com.young.sizhou.houserent.controller;


import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HouseDetailsController {
	
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/toDetailsPage")
	public String toDetailsPage(int id, Model model) {
		HouseEntity HouseDetails = houseService.getById(id);
		List<String> list = new ArrayList<String>();
		String[] split = HouseDetails.getHouseDetailesImg().split("~");
		for(int i=0;i<split.length;i++) {
			list.add(split[i]);
		}
		model.addAttribute("Details", HouseDetails);
		model.addAttribute("DetailsImg", list);
		return "housedetails";
	}
}
