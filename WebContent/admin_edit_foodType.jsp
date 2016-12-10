<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>管理员修改菜品分类</title>
	<link rel="stylesheet" href="./bootstrap3.3.5/css/bootstrap.min.css">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="./jquery1.11.3/jquery-1.11.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./bootstrap3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	<div class="row">
    <div class="col-md-12">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
		    	<a class="navbar-brand" href="Homepage"><span class="text-warning">网络点餐系统</span></a>
	   		</div>	  
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="admin_list_user">用户管理</a></li>
					<li class="active"><a href="#">菜品分类管理</a></li>
					<li><a href="admin_list_food">菜品管理</a></li>
					<li><a href="admin_show_dc.jsp">查看用户点餐情况</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" href="#" data-toggle="dropdown">
						 	<span class="glyphicon glyphicon-user"></span>&nbsp;Admin
						 	<strong class="caret"></strong>
						</a>
						<ul class="dropdown-menu">
							<li>
								<a href="#">退出登录</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>
	</div>
	</div><!--ending 1st row-->
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<div class="panel panel-success">
			<div class="panel-heading text-center">修  改 菜 品 分 类
			</div>
			<%String id = request.getParameter("id");
			String typeN= request.getParameter("typeName");
			%>
			<form role="form" method="post" action="admin_edit_foodType_do">
			<div class="panel-body">
			<input type="hidden" value="<%=id%>" name="id">
				<div class="form-group">
					<label for="foodtypename">
						<span class="glyphicon glyphicon-credit-card"></span> 分类名称
					</label>
					<input type="text" class="form-control" id="foodtypename" name="ftn"
					autofocus="autofocus" required="required" value="<%=typeN%>"/>
				</div>				
			</div>
			<div class="panel-footer text-center">
				<button type="submit" class="btn btn-success">确认修改</button>&nbsp;&nbsp;
				<a role="button" class="btn btn-default" href="admin_list_foodType">放弃返回</a>
			</div>
			</form>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div><!--ending 2th row-->
	</div><!--ending container-->
</body>
</html>