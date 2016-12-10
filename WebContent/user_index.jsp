<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户首页</title>
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
						<li class="active">
							<a href="user_index">正在点餐</a>
						</li>
						<li>
							<a href="user_show_dc">我的点餐</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a class="dropdown-toggle" href="#" data-toggle="dropdown">
								<span class="glyphicon glyphicon-user"></span>&nbsp;${userName}<strong class="caret"></strong>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">修改个人资料</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">退出登录</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
			<form method="post" action="add_diningcar_multiple">
			<table class="table table-striped table-hover table-condensed">
				<thead>
					<tr class="info">
						<th>
							#
						</th>
						<th>
							菜名
						</th>
						<th>
							特色
						</th>
						<th>
							主料
						</th>
						<th>
							价格
						</th>
						<th>
							分类
						</th>
						<th>
							图片
						</th>
						<th>
							点餐率
						</th>
						<th>
							备注
						</th>
						<th>
							选择
						</th>
					</tr>
				</thead>
				<tbody>
				 <%
				 ArrayList<Food> foods = (ArrayList)request.getAttribute("allFoods");
			     int num = 1;
			     for(Food x:foods){
				 %>
					<tr>
						<th>
							<%=num %>
						</th>
						<td>
							<%=x.getFoodName() %>
						</td>
						<td>
							<%=x.getFeature() %>
						</td>
						<td>
							<%=x.getMaterial() %>
						</td>
						<td>
							<%=x.getPrice() %>元
						</td>
						<td>
							<%=x.getTypeName() %>
						</td>
						<td>
							<img class="img-rounded" src="./images/06.jpg" />
						</td>
						<td>
							<%=x.getHits() %>次
						</td>
						<td>
							厨师推荐
						</td>
						<td>
						  <input type="hidden" name="id" value="<%=x.getId()%>">
						  <input type="checkbox" name="ids" value="<%=x.getId() %>">
						</td>
					</tr>
					
					<%num++; } %>
				</tbody>
			</table>
			<div class="form-group">
			    <div class="col-md-offset-4 col-md-4">
			    	<button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;将 菜 品 添 加 到 点 餐 车&nbsp;&nbsp;<span class="glyphicon glyphicon-heart"></span></button>
			    </div>
			</div>
			</form>
			<nav class="pull-right">
				<ul class="pagination">
					<li>
						<a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
						</a>
					</li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li>
						<a href="#" aria-label="Next">
					    <span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>
</div>
</body>
</html>