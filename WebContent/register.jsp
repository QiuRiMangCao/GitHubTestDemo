<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String username = request.getParameter("un");
String pwd = request.getParameter("pw");
String tel = request.getParameter("tel");
String addr = request.getParameter("addr");
Class.forName("com.mysql.jdbc.Driver");
String dburl = "jdbc:mysql://localhost:3306/mealsystem";
Connection con = DriverManager.getConnection(dburl,"root",""); 
Statement stmt = con.createStatement();
String sql = "insert into user(userName,password,ident,telephone,address)values('"+username+"','"+pwd+"','0','"+tel+"','"+addr+"')";
int i = stmt.executeUpdate(sql);
if(i == 1){
	response.sendRedirect("homepage.jsp");
}else{
	response.sendRedirect("register_fail.jsp");
}
%>
</body>
</html>