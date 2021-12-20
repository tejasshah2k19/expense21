package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@WebServlet("/PrintSubCategoryController")
public class PrintSubCategoryController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		SubCategoryDao sbDao = new SubCategoryDao();
		ArrayList<SubCategoryBean> subCategories = sbDao.getAllSubCatByCategoryId(categoryId);
		request.setAttribute("subCategories", subCategories);
		
		request.getRequestDispatcher("PrintSubCategory.jsp").forward(request, response);
	}
}