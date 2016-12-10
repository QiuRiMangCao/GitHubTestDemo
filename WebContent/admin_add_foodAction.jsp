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
String fn = request.getParameter("fn");
String mat = request.getParameter("mat");
String fea = request.getParameter("fea");
String type = request.getParameter("type");
String price = request.getParameter("price");
String com = request.getParameter("com");
Class.forName("com.mysql.jdbc.Driver");
String dbUrl = "jdbc:mysql://localhost:3306/mealsystem";
Connection con = DriverManager.getConnection(dbUrl,"root","");
Statement stmt =con.createStatement();
String sql = "insert into food(foodName,feature,material,price,type,picture,hits,comment)values('"
+fn+"','"+fea+"','"+mat+"','"+price+"','"+type+"','"+"img/140.jpg"+"','"+"0"+"','"+com+"')";
int result = stmt.executeUpdate(sql);
if(result == 1){
	request.setAttribute("msg","添加菜品成功！");
}else{
	request.setAttribute("msg", "添加用户失败！");
}
request.setAttribute("href","http://localhost:8080/prepare/admin_list_food");
stmt.close();
con.close();
%>
<jsp:forward page="result.jsp"/>
</body>
</html>