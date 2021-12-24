<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script
	src="https://cdn.jsdelivr.net/npm/chart.js@3.7.0/dist/chart.min.js"></script>

</head>
<body>

	<%
		ArrayList<ExpenseBean> exp = (ArrayList<ExpenseBean>) request.getAttribute("exp");
		HashMap<String, Integer> expMap = (HashMap<String, Integer>) request.getAttribute("expMap");
	%>



	<canvas id="myChart" width="40" height="40"></canvas>

</body>



<script>

<%Set<String> hs = expMap.keySet();
			//[party,automobile,household]%>
	const ctx = document.getElementById('myChart').getContext('2d');
	const myChart = new Chart(ctx, {
		type : 'pie',
		data : {
			labels :  
				[ 
					<%for (String x : hs) {%>
						'<%=x%>',
					<%}%>
					
			],
			datasets : [ {
				label : 'Categories',
				data : [ 
					<%for (String x : hs) {%>
					<%=expMap.get(x)%>,
					<%}%>

					],
				backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
						'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)',
						'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)',
						'rgba(255, 159, 64, 0.2)' ],
				borderColor : [ 'rgba(255, 99, 132, 1)',
						'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
						'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)',
						'rgba(255, 159, 64, 1)' ],
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				y : {
					beginAtZero : true
				}
			}
		}
	});
</script>
</html>