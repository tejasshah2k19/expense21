package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@WebServlet("/AddSubCategory")
public class AddSubCategory extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String subCategoryName = request.getParameter("subCategoryName");
		int category = Integer.parseInt(request.getParameter("category"));
		SubCategoryBean sb = new SubCategoryBean();
		sb.setSubCategoryName(subCategoryName);
		sb.setCategoryId(category);

		SubCategoryDao sbDao =new SubCategoryDao();
		sbDao.addSubCategory(sb);
		request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
	}
}
