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
String id = request.getParameter("id");
//第一步：接收admin_edit_food.jsp页面传递过来的修改后的数据
String foodName = request.getParameter("fn");
String fea = request.getParameter("fea");
String mat = request.getParameter("mat");
String price = request.getParameter("price");
String type=request.getParameter("type");
String com = request.getParameter("com");
//第二步：连接数据库，将更新后的菜品信息更新到数据库中
Class.forName("com.mysql.jdbc.Driver");
String dbUrl="jdbc:mysql://localhost:3306/mealsystem";
Connection con = DriverManager.getConnection(dbUrl,"root","");
Statement stmt = con.createStatement();
String sql ="update food set foodName ='"+foodName+"',feature='"+fea+"',material='"+mat+"',price='"+price+"',comment='"+com+"',type='"+type+"' where id='"+id+"'";		
int result = stmt.executeUpdate(sql);
if(result ==1){
	request.setAttribute("msg","修改菜品成功！");
}else{
	request.setAttribute("msg","修改菜品成功！");
}
stmt.close();
con.close();
request.setAttribute("href","http://localhost:8080/prepare/admin_list_food.jsp");
%>
<jsp:forward page="admin_list_food.jsp"/>
</body>
</html>