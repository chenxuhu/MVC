package com.jike.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jike.admin.model.DeleteGoodsDao;

/**
 * Servlet implementation class DelGoodServlet
 */
@WebServlet("/DelGoodServ")
public class DelGoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String projectId = request.getParameter("projectId");
		DeleteGoodsDao deldao = new DeleteGoodsDao();
		int res = deldao.deletegoods(projectId);
		JSONObject jo = new JSONObject();
		jo.put("success", res);
		response.getWriter().print(jo);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
