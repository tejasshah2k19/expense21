<%@page import="com.dao.CategoryDao"%>
<%@page import="com.bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>

	<%
		ArrayList<CategoryBean> categories = new CategoryDao().getAllCategories();
	
	%>


	<form method="post" action="AddExpenseController">
		Title : <input type="text" name="title" /> <br> Category : <select
			name="category">
			<option value="-1">Select Category</option>
			<%for(CategoryBean c:categories){ %>
			<option value="<%=c.getCategoryId() %>"><%=c.getCategoryName() %></option>
			<%} %>
		</select> <br> SubCategory :<input type="text" name="subcategory" /> <br>
		Amount :<input type="text" name="amount" /> <br> Date : <input
			type="text" name="date" /><br> <input type="submit"
			value="Add Expense" />

	</form>
</body>
</html>