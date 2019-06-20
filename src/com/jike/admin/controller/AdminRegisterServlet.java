package com.jike.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jike.admin.model.AdminRegisterDao;
import com.jike.admin.pojo.Admin;

/**
 * Servlet implementation class AdminRegisterServlet
 */
@WebServlet("/AdminRegisterServ")
public class AdminRegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Admin admin = accept(request);
		AdminRegisterDao admindao = new AdminRegisterDao();
		int res = admindao.adminRegister(admin);
		System.out.println(res);
		JSONObject jo = new JSONObject();
		if(res==1){
			jo.put("success", "1");
		}else{
			jo.put("success", "0");
		}
		response.getWriter().print(jo);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public Admin accept(HttpServletRequest request) {
		String user_name = request.getParameter("userName");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String moblie_phone = request.getParameter("phone");
		
		Admin admin  = new Admin();
		admin.setUser_name(user_name);
		admin.setAccount(account);
		admin.setUser_password(password);
		admin.setUser_phone(moblie_phone);
		return admin;
	}
}
