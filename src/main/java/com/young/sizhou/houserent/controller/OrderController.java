package com.young.sizhou.houserent.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.entity.OrderEntity;
import com.young.sizhou.houserent.entity.UsersEntity;
import com.young.sizhou.houserent.service.HouseService;
import com.young.sizhou.houserent.service.OrderService;
import com.young.sizhou.houserent.vo.Page;
import com.young.sizhou.houserent.vo.UserOrder;
import com.young.sizhou.houserent.vo.UserOrderData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Controller
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private HouseService houseService;
	
	@RequestMapping("/myorder")
	public String toOrderPage() {
		return "myorder";
	}
	
	@RequestMapping("/updatepwd")
	public String toUpdatepwdPage() {
		return "updatepwd";
	}
	
	@RequestMapping("/addOrder")
	@ResponseBody
	@Transactional
	public String addOrder(String id,HttpServletRequest request) {
		UsersEntity u = (UsersEntity) request.getSession().getAttribute("loginUser");
		HouseEntity house = houseService.getOne(new QueryWrapper<HouseEntity>().eq("h_id", Long.parseLong(id)));
		if (u == null || house.getStatus() == 1){
			return "FAIL";
		}
		try {
			OrderEntity order = new OrderEntity();
			order.setHId(Long.parseLong(id));
			order.setOrderUser(u.getUNickname());
			order.setUId(u.getUId());
			order.setOrderTime(new Date());
			houseService.updateHouseStatus(Long.parseLong(id),1);
			boolean b = orderService.save(order);
			if(b) {
				return "OK";
			}
		} catch (NumberFormatException e) {
			log.error("订单保存失败："+e.getMessage());
			return "FAIL";
		}
		return "FAIL";
	}
	
	@RequestMapping("/myOrderInfo")
	@ResponseBody
	public UserOrderData findAllOrder(Integer page, int limit, HttpServletRequest request){
		Page p = new Page();
		p.setPage((page - 1) * limit);
		p.setLimit(limit);
		UsersEntity u = (UsersEntity) request.getSession().getAttribute("loginUser");
		p.setUID(u.getUId());
		UserOrderData uod = new UserOrderData();
		List<UserOrder> order = orderService.findAllOrder(p);
		uod.setCode(0);
		List<OrderEntity> list = orderService.list(new QueryWrapper<OrderEntity>().eq("u_id", u.getUId()));
		uod.setCount(list == null ? 0 : list.size());
		uod.setData(order);
		uod.setMsg("200");
		return  uod;
	}
	
	@RequestMapping("/deleteOrder")
	@ResponseBody
	public String deleteOrder(int oID) {
		boolean b = orderService.removeById(oID);
		if(b)
			return "OK";
		return "FAIL";
	}
}
