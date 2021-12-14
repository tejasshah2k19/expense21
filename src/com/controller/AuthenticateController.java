package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/authenticate")
public class AuthenticateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDao userDao = new UserDao();
		UserBean user = userDao.authenticate(email, password);
		RequestDispatcher rd = null;
		if (user == null) {
			request.setAttribute("errMsg", "Invalid Credentials");
			rd = request.getRequestDispatcher("Login.jsp");
		} else {
			request.setAttribute("msg", "Welcome");
			if (user.getRole() == 1) {
				// user
				rd = request.getRequestDispatcher("Home.jsp");
			} else if (user.getRole() == 2) {
				rd = request.getRequestDispatcher("AdminDashboard.jsp");
			} else {

				request.setAttribute("errMsg", "Please contact Admin with LG123");
				rd = request.getRequestDispatcher("Login.jsp");
			}
		}

		rd.forward(request, response);
	}
}
