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
	<form action="Savesubcategory" method="post">

		SubCategoryName : <input type="text" name="subCategoryName" /><Br>


	Category :<select name="category">



			<option value="-1">Select Category</option>
			<%
				for (CategoryBean cb : categories) {
			%>
			<option value="<%=cb.getCategoryId()%>">
				<%=cb.getCategoryName()%></option>
			<%
				}
			%>
		</select> <br> <input type="submit" value="Save SubCategory">

	</form>

</body>
</html>