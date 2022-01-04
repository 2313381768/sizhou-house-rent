package com.young.sizhou.houserent.interceptor;


import com.young.sizhou.houserent.entity.AdminEntity;
import com.young.sizhou.houserent.entity.UsersEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();

		if (url.indexOf("toIndexPage") >= 0 || url.indexOf("login") >= 0 || url.indexOf("regist") >= 0
				|| url.indexOf("toDetailsPage") >= 0 || url.indexOf("findHouseByLike") >= 0
				|| url.indexOf("findHousrOrderByAsc") >= 0 || url.indexOf("findHousrOrderByDesc") >= 0
				|| url.indexOf("toAdminLogin") >= 0||url.indexOf("adminAccess")>=0) {
			return true;
		}
		HttpSession session = request.getSession();
		UsersEntity u = (UsersEntity) session.getAttribute("loginUser");
		AdminEntity admin = (AdminEntity) session.getAttribute("admin");
		if (u != null || admin != null) {
			return true;
		}
		response.sendRedirect("/");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
