<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>管理员查看用户点餐情况</title>
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
					<li><a href="admin_list_foodType">菜品分类管理</a></li>
					<li><a href="admin_list_food">菜品管理</a></li>
					<li class="active"><a href="admin_show_dc.jsp">查看用户点餐情况</a></li>
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
	<div class="col-md-offset-2 col-md-8"> 
		<div class="list-group">
			<div class="list-group-item active">
			<span class="glyphicon glyphicon-user"></span>
			Sam
			</div>
			<a class="list-group-item">菠菜炒鸡蛋
			<span class="badge">¥9.00</span>
			</a>
			<a class="list-group-item">韭菜炒鸡蛋
			<span class="badge">¥8.00</span>
			</a>
			<a class="list-group-item">渝味辣白菜
			<span class="badge">¥6.00</span>
			</a>
			<a class="list-group-item active">合计
			<span class="badge">¥23.00</span>
			</a>
		</div>
		<div class="list-group">
			<div class="list-group-item active">
			<span class="glyphicon glyphicon-user"></span>
			Lily
			</div>
			<a class="list-group-item">酸辣白菜
			<span class="badge">¥14.00</span>
			</a>
			<a class="list-group-item">肉末豆腐
			<span class="badge">¥7.00</span>
			</a>
			<a class="list-group-item">小葱拌豆腐
			<span class="badge">¥22.00</span>
			</a>
			<a class="list-group-item">布丁
			<span class="badge">¥6.00</span>
			</a>
			<a class="list-group-item">姜撞奶
			<span class="badge">¥14.00</span>
			</a>
			<a class="list-group-item active">合计
			<span class="badge">¥66.00</span>
			</a>
		</div>
	</div>
	</div><!--ending 2th row-->
	</div><!--ending container-->
</body>
</html>