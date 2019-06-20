package com.jike.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jike.admin.model.EditDao;
import com.jike.admin.pojo.Goods;

/**
 * Servlet implementation class EditGoodsServlet
 */
@WebServlet("/Editserv")
public class EditGoodsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EditDao editDao = new EditDao();
		String projectId = request.getParameter("projectId");
		Goods good = editDao.editdao(projectId);
		request.setAttribute("producetList", good);
		request.getRequestDispatcher("admin/project_update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
