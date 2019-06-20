package com.jike.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jike.user.pojo.Goods;
import com.alibaba.fastjson.JSONObject;
import com.jike.user.model.ShowUserGoods;

/**
 * Servlet implementation class UserGoodsServlet
 */
@WebServlet("/Usergoods")
public class UserGoodsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("utf-8");


		ShowUserGoods goods = new ShowUserGoods();
		List<Goods> list = goods.showgood();
		JSONObject  jo =new JSONObject();
		jo.put("data", list);
		response.getWriter().print(jo);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
