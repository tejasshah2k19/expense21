package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddExpenseController")
public class AddExpenseController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		int category = Integer.parseInt(request.getParameter("category"));
		int subCategory = Integer.parseInt(request.getParameter("subCategory"));
		float amount = Float.parseFloat(request.getParameter("amount"));

	}
}
