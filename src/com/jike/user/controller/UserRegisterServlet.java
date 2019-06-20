package com.jike.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jike.user.model.UserRegisterDao;
import com.jike.user.pojo.User;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegister")
public class UserRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user = accept(request);
		UserRegisterDao dao = new UserRegisterDao();
		int res = dao.userDao(user);
		
		JSONObject jo = new JSONObject();
		if(res==1){
			jo.put("resultCode", 1);
			jo.put("message", "success");
		}else{
			jo.put("resultCode", 0);
			jo.put("message", "GG");
		}
		response.getWriter().print(jo);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public User accept(HttpServletRequest request) {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setEmail(email);
		user.setAccount(account);
		user.setPassword(password);
		return user;
	}

}
