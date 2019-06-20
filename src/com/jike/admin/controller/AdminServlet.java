package com.jike.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jike.admin.model.AdminDao;
import com.jike.admin.pojo.Admin;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Admin admin = accept(request);
		AdminDao adminDao = new AdminDao();
		boolean res = adminDao.adminDao(admin);
		
		JSONObject jo = new JSONObject();
		
		if(res){
			jo.put("flag", "success");
		}
	
		response.getWriter().print(jo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

public Admin accept(HttpServletRequest request){
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		Admin admin = 	new Admin();
		admin.setUser_name(name);
		admin.setUser_password(password);
		return admin;
		
	}
}
