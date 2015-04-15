<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*" pageEncoding="UTF-8" import="edu.neu.cs5200.rest.client.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MovieSearch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table>
    <%
    	MyApiFilmsClient client = new MyApiFilmsClient();
    	Movie[] movies = client.findMovieByTitle("star trek");
    	for (Movie movie:movies)
    	{
    	%> <tr>
    		<td><%=movie.getIdIMDB() %></td>
    		<td><%=movie.getTitle() %></td>
    		<td><%=movie.getPlot() %></td>
    		<td><img src="<%= movie.getPoster() %>"/></td>
    		</tr>
    		
    	<% 
    	}
     %>
     </table>
  </body>
</html>
