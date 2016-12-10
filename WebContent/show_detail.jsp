<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>菜品详细信息</title>
	<link rel="stylesheet" href="./bootstrap3.3.5/css/bootstrap.min.css">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="./jquery1.11.3/jquery-1.11.3.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="./bootstrap3.3.5/js/bootstrap.min.js"></script>
    <style>
		table.table tr th {
			vertical-align: middle;
		}
    </style>
</head>
<body>
	<p></p>
	<%
	    Food f = (Food)request.getAttribute("food");
	    
	%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
            </div>
            <div class="col-md-6">
                <table class="table table-hover table-bordered">
				<tbody>
                    <tr class="info">
						<th class="text-center">菜 名</th>
						<td><%=f.getFoodName() %></td>
					</tr>
					<tr class="warning">
						<th class="text-center">特 色</th>
						<td><%=f.getFeature() %></td>
					</tr>
					<tr class="active">
						<th class="text-center">食 材</th>
						<td><%=f.getMaterial() %></td>
					</tr>
					<tr class="info">
						<th class="text-center">类 型</th>
						<td><%=f.getTypeName() %></td>
					</tr>
					<tr class="warning">
						<th class="text-center">价 格</th>
						<td><%=f.getPrice() %>元</td>
					</tr>
					<tr class="active">
						<th class="text-center">图 片</th>
						<td><img class="img-rounded" alt="Bootstrap Image Preview" src="./images/140.jpg" /></td>
					</tr>
					<tr class="info">
						<th class="text-center">点 餐 率</th>
						<td><%=f.getHits() %>次</td>
					</tr>
					<tr class="warning">
						<th class="text-center">备 注</th>
						<td><%=f.getComment() %></td>
					</tr>
				</tbody>
			</table>
            <form method="post" action="AddDiningCar">
            <input type="hidden" name="foodId" value="<%=f.getId()%>">
            
            <div class="col-md-offset-4">
            	<button type="submit" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-heart"></span> 加入点餐车</button>
            </div>
            </form>
            </div>
            <div class="col-md-3">
            </div>
        </div>
    </div>
</body>
</html>