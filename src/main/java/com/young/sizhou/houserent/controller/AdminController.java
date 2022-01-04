package com.young.sizhou.houserent.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.young.sizhou.houserent.entity.AdminEntity;

import com.young.sizhou.houserent.entity.HouseEntity;
import com.young.sizhou.houserent.entity.UsersEntity;
import com.young.sizhou.houserent.service.AdminService;
import com.young.sizhou.houserent.service.HouseService;
import com.young.sizhou.houserent.service.UsersService;
import com.young.sizhou.houserent.vo.Page;
import com.young.sizhou.houserent.vo.UserData;
import com.young.sizhou.houserent.vo.UserHouseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private HouseService houseService;
	@Autowired
	private UsersService usersService;

	/**
	 * 跳转到登录页
	 * 
	 * @return
	 */
	@RequestMapping("/toAdminLogin")
	public String toAdminEntityLogin() {
		return "admin";
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param userpwd
	 * @param req
	 * @return
	 */
	@RequestMapping("/adminAccess")
	@ResponseBody
	public String AdminEntityAccess(String username, String userpwd, HttpServletRequest req) {
		AdminEntity adminEntity = adminService.getOne(new QueryWrapper<AdminEntity>().eq("username",username).eq("userpwd",userpwd));//[从数据库中查询用户名和密码一致的用户]
		req.getSession().setAttribute("admin", adminEntity);
		if (adminEntity != null)
			return "OK";//[如果返回是OK，则会回调，重新跳转到toAdminEntityHomePage]
		return "FAIL";
	}

	/**
	 * 登出
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminSingnout")
	public String signout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "admin";
	}

	@RequestMapping("/toAdminHomePage")
	public String toAdminEntityHomePage() {
		return "adminhome";
	}

	@RequestMapping("/toAllUserPage")
	public String toAllUserPage() {
		return "alluser";
	}

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	@RequestMapping("/AllUsers")
	@ResponseBody
	public UserData findAllUser() {
		List<UsersEntity> findAllUser = usersService.list();
		UserData u = new UserData();
		u.setCode(0);
		u.setCount(findAllUser.size());
		u.setData(findAllUser);
		u.setMsg("OK");
		return u;
	}

	@RequestMapping("/toAllHousePage")
	public String toAllHousePage() {
		return "allhouse";
	}

	/**
	 * 查询所有房源
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/findAllHouse")
	@ResponseBody
	public UserHouseData findAllHouse(int page, int limit) {
		Page p = new Page();
		p.setLimit(limit);
		p.setPage((page - 1) * limit);
		List<HouseEntity> findAllHouse = houseService.findAllHouse(p);
		UserHouseData data = new UserHouseData();
		data.setCode(0);
		data.setCount(findAllHouse.size());
		data.setData(findAllHouse);
		data.setMsg("OK");
		return data;
	}

	/**
	 * 删除房源
	 * 
	 * @param hID
	 * @return
	 */
	@RequestMapping("/deleteHouse")
	@ResponseBody
	public String deleteHouse(Integer hID) {
		boolean b = houseService.removeById(hID);
		if (b) {
			return "OK";
		}
		return "FAIL";
	}

	/**
	 * 跳转到管理员更新房源界面
	 * 
	 * @param hID
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAdminUpdateHousePage")
	public String toUpdatePage(Long hID, Model model) {
		HouseEntity house = houseService.getById(hID);
		model.addAttribute("House", house);
		return "updatehouse";
	}

	/**
	 * 传入id,跳转到修改用户界面
	 * 
	 * @return
	 */
	@RequestMapping("/toEditUserPage")
	public String toEditUserPage(int uID, Model model) {
		UsersEntity findUserById = usersService.getById(uID);
		model.addAttribute("User", findUserById);
		return "editUser";
	}

	/**
	 * 更新用户信息
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping("/editUser")
	@ResponseBody
	public String editUser(UsersEntity users) {
		boolean b = usersService.updateById(users);
		if (b)
			return "OK";
		return "FAIL";
	}

	/**
	 * 管理员删除用户
	 * 
	 * @param uID
	 * @return
	 */
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUser(Integer uID) {
		boolean b = usersService.removeById(uID);
		if (b) {
			return "OK";
		}
		return "FAIL";
	}

	@RequestMapping("/toUpdateAdminPwdPage")
	public String toUpdateAdminEntityPwdPage() {
		return "updateAdminPwd";
	}
	@RequestMapping("/welcome01")
	public String toWelcomePage() {
		return "welcome01";
	}

	@RequestMapping("/updateAdminPwd")
	@ResponseBody
	public String updateAdminEntityPwd(HttpServletRequest request,String oldpwd, String newpwd, String newpwdagain) {
		AdminEntity sessionAdmin = (AdminEntity) request.getSession().getAttribute("admin");
		AdminEntity byId = adminService.getById(sessionAdmin.getId());

		if (byId == null || !byId.getUserpwd().equals(oldpwd)) {
			return "ERROR";
		}
		if (!newpwd.equals(newpwdagain)) {
			return "FAIL";
		}
		byId.setUserpwd(newpwd);
		boolean b = adminService.updateById(byId);
		if (b)
			return "OK";
		return "FAIL";
	}
}
