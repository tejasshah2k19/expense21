package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.dao.CategoryDao;

@WebServlet("/ListCategoriesController")
public class ListCategoriesController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryDao categoryDao = new CategoryDao();
		ArrayList<CategoryBean> categories = categoryDao.getAllCategories();
		request.setAttribute("categories", categories);

		request.getRequestDispatcher("ListAllCategories.jsp").forward(request, response);
	}

}
