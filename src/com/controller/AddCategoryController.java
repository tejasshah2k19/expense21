package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/AddCategoryController")
public class AddCategoryController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryName = request.getParameter("categoryName");

		CategoryDao categoryDao = new CategoryDao();

		categoryDao.addCategory(categoryName);
		request.getRequestDispatcher("ListCategoriesController");
	}
}
