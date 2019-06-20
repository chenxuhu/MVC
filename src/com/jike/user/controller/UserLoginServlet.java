package com.jike.user.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jike.user.model.UserLoginDao;
import com.jike.user.pojo.User;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User user = accept(request);
		
		UserLoginDao dao = new UserLoginDao();
		boolean res = dao.UserDao(user);
		
		JSONObject jo = new JSONObject();
		
		if(res){
			jo.put("resultCode", 1);
			jo.put("message", "success");
		}else{
			jo.put("resultCode", 0);
			jo.put("message", "false");
		}
		response.getWriter().print(jo);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public User accept(HttpServletRequest request){
		String accountLogin = request.getParameter("account");
		String passWordLogin = request.getParameter("password");
		
		User user = new User();
		user.setAccount(accountLogin);
		user.setPassword(passWordLogin);
		return user;
		
	}

}
