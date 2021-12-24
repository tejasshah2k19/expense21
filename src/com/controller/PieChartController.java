package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ExpenseBean;
import com.dao.ExpenseDao;

@WebServlet("/PieChartController")
public class PieChartController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ExpenseDao ed = new ExpenseDao();
		ArrayList<ExpenseBean> exp = ed.getAllExpense(1);

		HashMap<String, Integer> expMap = new HashMap<>();

		for (ExpenseBean e : exp) {

			if (expMap.get(e.getCategoryName()) == null) {
				expMap.put(e.getCategoryName(), e.getAmount());// party,250
			} else {
				expMap.put(e.getCategoryName(), expMap.get(e.getCategoryName()) + e.getAmount());
			}

		}

		request.setAttribute("exp", exp);
		request.setAttribute("expMap", expMap);

		System.out.println("--------------");
		request.getRequestDispatcher("PieChartDemo.jsp").forward(request, response);

	}
}
