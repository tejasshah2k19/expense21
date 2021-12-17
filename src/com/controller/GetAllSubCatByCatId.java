package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@WebServlet("/GetAllSubCatByCatId")
public class GetAllSubCatByCatId extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("getallsubcatbyid called....");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println(categoryId);
		ArrayList<SubCategoryBean> subCategories = new SubCategoryDao().getAllSubCatByCategoryId(categoryId);
		PrintWriter out = response.getWriter();

//		ArrayList<String> data = new ArrayList<>();		
		Map<Integer, String> data = new HashMap<>();

		for (SubCategoryBean sb : subCategories) {
			data.put(sb.getSubCategoryId(), sb.getSubCategoryName());
		}

		out.print(data);

	}
}
