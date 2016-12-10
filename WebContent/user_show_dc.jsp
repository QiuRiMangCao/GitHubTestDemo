<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户点餐车</title>
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
						<li>
							<a href="user_index">正在点餐</a>
						</li>
						<li class="active">
							<a href="user_show_dc">我的点餐</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a class="dropdown-toggle" href="#" data-toggle="dropdown">
								<span class="glyphicon glyphicon-user"></span>&nbsp;用户名<strong class="caret"></strong>
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
			<form>
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
				   ArrayList<Food> foods = (ArrayList)request.getAttribute("foods");
			       int num = 1;
			       for(Food f:foods){
			      %>
					<tr>
						<th>
							<%=num %>
						</th>
						<td>
							<%=f.getFoodName() %>
						</td>
						<td>
							<%=f.getFeature() %>
						</td>
						<td>
							<%=f.getMaterial() %>
						</td>
						<td>
							<%=f.getPrice() %>元
						</td>
						<td>
							<%=f.getTypeName() %>
						</td>
						<td>
							<img class="img-rounded" src="./images/06.jpg" />
						</td>
						<td>
							<%=f.getHits() %>
						</td>
						<td>
							<%=f.getComment() %>
						</td>
						<td>
							<input type="checkbox" name="ids">
						</td>
					</tr>
					<%
					num++;
			       } %>
					
				</tbody>
			</table>
			<div class="form-group">
			    <div class="col-md-offset-4 col-md-4">
			      <button type="submit" class="btn btn-danger btn-block"><span class="glyphicon glyphicon-minus-sign"></span>&nbsp;&nbsp;将 菜 品 从 点 餐 车 删 除&nbsp;&nbsp;<span class="glyphicon glyphicon-minus-sign"></span></button>
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