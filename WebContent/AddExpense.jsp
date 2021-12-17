<%@page import="com.dao.CategoryDao"%>
<%@page import="com.bean.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>

	<%
		ArrayList<CategoryBean> categories = new CategoryDao().getAllCategories();
	%>


	<form method="post" action="AddExpenseController">
		Title : <input type="text" name="title" /> <br> Category : <select
			name="category" id="category" onchange="getAllSubCategory()">
			<option value="-1">Select Category</option>
			<%
				for (CategoryBean c : categories) {
			%>
			<option value="<%=c.getCategoryId()%>"><%=c.getCategoryName()%></option>
			<%
				}
			%>
		</select> <br> SubCategory : <select id="subcategory"></select> <br>
		Amount :<input type="text" name="amount" /> <br> Date : <input
			type="text" name="date" /><br> <input type="submit"
			value="Add Expense" />

	</form>


	<script type="text/javascript">
		function getAllSubCategory() {
			let categoryId = document.getElementById("category").value;
			//alert(categoryId);
			let data = {
				"categoryId" : categoryId
			}

			$.ajax({
				url : "GetAllSubCatByCatId",
				data : data,
				success : function(result) {
					console.log(result);
					console.log(result[0]);
				}
			});

		}
	</script>
</body>
</html>


