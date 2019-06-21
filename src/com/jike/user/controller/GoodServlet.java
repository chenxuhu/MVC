package com.jike.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jike.user.model.GoodsDao;
import com.jike.user.pojo.Goods;

/**
 * Servlet implementation class GoodServlet
 */
@WebServlet("/GoodServlet")
public class GoodServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("id");
		 
		 System.out.println("id============================="+id);
		 GoodsDao goodsdao=new GoodsDao();
		 Goods goods = goodsdao.selectGoodss(id);
		 JSONObject jo=new JSONObject();
		 
			System.out.println("122"+goods);
		 jo.put("data", goods);
		 response.setCharacterEncoding("utf-8");
			response.getWriter().print(jo);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
