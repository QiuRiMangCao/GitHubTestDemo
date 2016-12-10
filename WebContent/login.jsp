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
String un = request.getParameter("un");
String pw = request.getParameter("pw");
Class.forName("com.mysql.jdbc.Driver");
String dburl = "jdbc:mysql://localhost:3306/mealsystem";
Connection con = DriverManager.getConnection(dburl,"root",""); 
Statement stmt = con.createStatement();
String sql ="select * from user where userName='"+un+"' and password='"+pw+"'";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
	int ident = rs.getInt("ident");
	int id = rs.getInt("id");
	session.setAttribute("userId", id);
	session.setAttribute("userName", un);
	if(ident == 1){
		response.sendRedirect("admin_list_user");
	}else{
		response.sendRedirect("user_index");
	}
}
rs.close();
stmt.close();
con.close();
%>
</body>
</html>