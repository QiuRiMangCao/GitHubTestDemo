<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>管理员添加菜品信息</title>
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
		    	<a class="navbar-brand" href="homepage.html"><span class="text-warning">网络点餐系统</span></a>
	   		</div>	  
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="admin_list_user.jsp">用户管理</a></li>
					<li><a href="admin_list_foodType.jsp">菜品分类管理</a></li>
					<li class="active"><a href="admin_list_food.jsp">菜品管理</a></li>
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
			<div class="panel panel-warning">
			<div class="panel-heading text-center">添 加 菜 品
			</div>
			<form role="form" method="post" action="admin_add_foodAction.jsp">
			<div class="panel-body">
				<div class="form-group">
					<label for="foodname">菜品名称</label>
					<input type="text" class="form-control" name="fn" id="foodname" required="required" />
				</div>
				<div class="form-group">
					<label for="feature">菜品特色</label>
					<textarea class="form-control" rows="3" name="fea" id="feature" required="required"></textarea>
				</div>
				<div class="form-group">
					<label for="material">主要原料</label>
					<textarea class="form-control" rows="3" name="mat" id="material" required="required"></textarea>
				</div>
				<div class="form-group">
					<label for="type">所属分类</label>
					<select class="form-control" name="type" id="type">
                          <option value="1">家常</option>
                          <option value="2">凉菜</option>
                          <option value="3">主食</option>
                          <option value="4">甜品</option>
                      </select>
				</div>
				<div class="form-group">
					<label for="price">菜品价格</label>
					<input type="number" class="form-control" name="price" id="price" required="required" />
					<p class="help-block">单位：元</p>
				</div>
				<div class="form-group">
					<label for="img">菜品图片</label>
					<input type="file" id="img" name="img" />
                    <p class="help-block">请选择上传的菜品图片</p>
				</div>
				<div class="form-group">
					<label for="comment">菜品备注</label>
					<input type="text" class="form-control" name="com" id="comment" value="-1" required="required" />
					<p class="help-block">-1代表正常菜，0代表厨师推荐，正整数代表特价菜价格。</p>
				</div>
			</div>
			<div class="panel-footer text-center">
				<button type="submit" class="btn btn-warning">确认添加</button>&nbsp;&nbsp;
				<a role="button" class="btn btn-default" href="admin_list_food.jsp">放弃返回</a>
			</div>
			</form>
			</div>
		</div>
		<div class="col-md-2"></div>
	</div><!--ending 2th row-->
	</div><!--ending container-->
</body>
</html>