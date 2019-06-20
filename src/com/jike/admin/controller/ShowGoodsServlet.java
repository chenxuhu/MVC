package com.jike.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jike.admin.model.ShowGoodsDao;
import com.jike.admin.pojo.Goods;

/**
 * Servlet implementation class ShowGoodsServlet
 */
@WebServlet("/showservlet")
public class ShowGoodsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ShowGoodsDao goods = new ShowGoodsDao();
		List<Goods> list = goods.showgood();
		request.setAttribute("producetList", list);
		request.getRequestDispatcher("admin/project_list.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
