<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
</head>
<body>


	<%
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>


	<table border="1">
		<tr>
			<td>UserId</td>
			<td>FirstName</td>
			<td>Email</td>
		</tr>


		<%
			for (UserBean user : users) {
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getEmail()%></td>
		</tr>
		<%
			}
		%>


	</table>
</body>
</html>