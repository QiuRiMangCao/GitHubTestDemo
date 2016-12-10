<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>管理员管理菜品信息</title>
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
					<li class="active"><a href="admin_list_food">菜品管理</a></li>
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
		<div class="col-md-12">
			<div class="panel panel-info">
			<div class="panel-heading">
				<form class="form-inline" role="search" method="post" action="admin_list_food">
					<div class="form-group">
						<input class="form-control" type="text" name="s_fn" placeholder="按菜名查询" />
					</div>
					<div class="form-group">
						<select class="form-control" name="s_type">
							<option value="0">所有分类</option>
							<option value="1">家常</option>
							<option value="2">凉菜</option>
							<option value="3">主食</option>
							<option value="4">甜品</option>
						</select>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-sm btn-info" data-toggle="tooltip" title="搜索菜品">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</div>
					<div class="form-group pull-right">
						<a class="btn btn-sm btn-success" data-toggle="tooltip" title="添加菜品" href="admin_add_food.jsp" role="button"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;添加菜品</a>
					</div>
				</form>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-hover table-condensed">
					<thead>
						<tr>
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
								操作
							</th>
						</tr>
					</thead>
					<tbody>
					
					<%
				 ArrayList<Food> foods = (ArrayList)request.getAttribute("adminListFood");
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
								<img class="img-rounded" src="./images/140.jpg" />
							</td>
							<td>
								<%=x.getHits() %>次
							</td>
							<td>
								厨师推荐
							</td>
							<td>
								<a class="btn btn-xs btn-warning" data-toggle="tooltip" title="修改菜品" href="admin_edit_food?id=<%=x.getId() %>" role="button"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
								<button type="button" class="btn btn-xs btn-danger"  data-toggle="modal" data-toggle="tooltip" title="删除菜品" onclick="delConfirm('<%=x.getId() %>')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button>
							</td>
						</tr>
					<%
					num++;
					} 
					
					%>
					</tbody>
				</table>
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
			</div><!--ending panel-->
		</div>
	</div><!--ending 2th row-->
	</div><!--ending container-->
	<!--删除确认框-->
	<div class="modal fade" id="delConfirmModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">删除确认</h4>
				</div>
				<div class="modal-body">
					<h4 class="text-danger">确定要删除该菜品吗？</h4>
				</div>
				<div class="modal-footer">
				<input type="hidden" id="url">
					<button type="button" class="btn btn-default" data-dismiss="modal">放弃</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="delSubmit()">删除</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
<script>
function delConfirm(id){
	$('#url').val('admin_del_food?id='+id);
	$('#delConfirmModal').modal();
}
function delSubmit(){
	location.replace($('#url').val());
}
</script>
</body>
</html>