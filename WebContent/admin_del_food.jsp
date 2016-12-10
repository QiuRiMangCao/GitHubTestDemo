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
String id  = request.getParameter("id");
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/mealsystem";
Connection con=DriverManager.getConnection(url,"root","");
Statement stmt = con.createStatement();
//定义预编译的SQL语句
String sql="delete from food where id='"+id+"'";
int result = stmt.executeUpdate(sql);
if(result ==1){
	request.setAttribute("msg", "删除菜品成功！");
}else{
	request.setAttribute("msg", "删除菜品失败！");
}
request.setAttribute("href", "http://localhost:8080/prepare/admin_list_food.jsp");
stmt.close();
con.close();
%>
<jsp:forward page="result.jsp"/>
</body>
</html>