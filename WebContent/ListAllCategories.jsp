<%@page import="com.bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Categories</title>
</head>
<body>
	<%
		ArrayList<CategoryBean> categories = (ArrayList<CategoryBean>) request.getAttribute("categories");
	%>

	<a href="AddCategory.jsp">Add Category</a>
	<br>
	<table border="1">
		<tr>
			<td>CategoryId</td>
			<td>CategoryName</td>
		</tr>
		<%
			for (CategoryBean cb : categories) {
		%>
		<tr>
			<td><%=cb.getCategoryId()%></td>
			<td><a
				href="PrintSubCategoryController?categoryId=<%=cb.getCategoryId()%>">
					<%=cb.getCategoryName()%>
			</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>







