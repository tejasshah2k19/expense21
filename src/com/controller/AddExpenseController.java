package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.ExpenseDao;

@WebServlet("/AddExpenseController")
public class AddExpenseController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		int category = Integer.parseInt(request.getParameter("category"));
		int subCategory = Integer.parseInt(request.getParameter("subCategory"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String expenseDate = request.getParameter("date");
		ExpenseBean expenseBean = new ExpenseBean();

		HttpSession session = request.getSession();

		UserBean user = (UserBean) session.getAttribute("user");
		expenseBean.setAmount(amount);
		expenseBean.setCategoryId(category);
		expenseBean.setExpenseDate(expenseDate);
		expenseBean.setSubCategoryId(subCategory);
		expenseBean.setTitle(title);

		if (user == null) {
			expenseBean.setUserId(1);
		} else {
			expenseBean.setUserId(user.getUserId());

		}

		new ExpenseDao().addExpense(expenseBean);

		response.sendRedirect("AddExpense.jsp");

	}
}
