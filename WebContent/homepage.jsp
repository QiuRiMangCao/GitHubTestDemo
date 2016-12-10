<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>首页</title>
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
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a class="btn" role="button" href="#modal-login" data-toggle="modal">登录</a>
						</li>
						<li>
							<a class="btn" role="button" href="#modal-register" data-toggle="modal">注册</a>
						</li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<div class="list-group">
				 <h4 class="list-group-item active">热点菜品</h4>
				 <%
				 ArrayList<Food> foods = (ArrayList)request.getAttribute("hotFoods");
			     for(Food x:foods){
				 %>
				<div class="list-group-item center-block">
					<img class="img-rounded" alt="Bootstrap Image Preview" src="./images/140.jpg" />
					<a href="showfooddetail?foodId=<%=x.getId() %>" target="_blank"><%=x.getFoodName() %></a>
					&nbsp;&nbsp;
					<span><%=x.getPrice() %>元</span>
				</div>
				<%} %>
			</div>
		</div>
		<div class="col-md-4">
			<div class="list-group">
				 <h4 class="list-group-item active">今日特价</h4>
				 <%
				 ArrayList<Food> lowPriceFoods = (ArrayList)request.getAttribute("hotFoods");
			     for(Food x:lowPriceFoods){
				 %>
				<div class="list-group-item center-block">
					<img class="img-rounded" alt="Bootstrap Image Preview" src="./images/140.jpg" />
					<a href="#"><%=x.getFoodName() %></a>
					&nbsp;&nbsp;
					<span><%=x.getPrice() %>元</span>
				</div>
				<%} %>
				
			</div>
		</div>
		<div class="col-md-4">
			<div class="list-group">
				 <h4 class="list-group-item active">厨师推荐</h4>
				 <%
				 ArrayList<Food> commentFoods = (ArrayList)request.getAttribute("commentFoods");
			     for(Food x:commentFoods){
				 %>
				<div class="list-group-item center-block">
					<img class="img-rounded" alt="Bootstrap Image Preview" src="./images/140.jpg" />
					<a href="#"><%=x.getFoodName() %></a>
					&nbsp;&nbsp;
					<span><%=x.getPrice() %>元</span>
				</div>
				<%} %>
				
				
			</div>
		</div>
</div>
</div>

<!--登录对话框-->
<div class="modal fade" id="modal-login" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" aria-hidden="true" type="button" data-dismiss="modal">
					×
				</button>
				<h3 class="modal-title text-center text-primary" id="myModalLabel">
					用户登录
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="login.jsp">
				<div class="modal-body">
					<div class="form-group">
						<label class="col-sm-4 control-label" for="username">
							用户名
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="username" name="un" type="text" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="pwd">
							密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="pwd" name="pw" type="password" required />
						</div>
					</div>
				</div>
				<div class="modal-footer">	
        			<button type="submit" class="btn btn-primary">登录</button>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</form>	
		</div>
	</div>
</div>
<!--注册对话框-->
<div class="modal fade" id="modal-register" role="dialog" aria-hidden="true" aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" aria-hidden="true" type="button" data-dismiss="modal">
					×
				</button>
				<h3 class="modal-title text-center text-primary" id="myModalLabel">
					用户注册
				</h3>
			</div>
			<form class="form-horizontal" role="form" method="post" action="register.jsp">
				<div class="modal-body">
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="username">
							用户名
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="username" name="un" type="text" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="pwd">
							密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="pwd" name="pw" type="password" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="pwd2">
							确认密码
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="pwd2" name="pw2" type="password" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="phone">
							电话
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="phone" name="tel" type="number" required />
						</div>
					</div>
					<div class="form-group">
						 
						<label class="col-sm-4 control-label" for="address">
							地址
						</label>
						<div class="col-sm-6">
							<input class="form-control" id="address" name="addr" type="text" required />
						</div>
					</div>
				</div>
				<div class="modal-footer">	
        			<button type="submit" class="btn btn-primary">注册</button>
        			<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>