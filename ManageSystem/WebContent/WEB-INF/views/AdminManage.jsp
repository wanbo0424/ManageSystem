<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${path}/resource/css/AdminManage.css">

<!--以下为使用bootstrap必须引入的三项-->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script type="text/javascript" src="${path}/resource/js/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="${path}/resource/js/bootstrap.min.js"></script>


<title>系统管理员后台管理</title>
<script type="text/javascript" src="Js/jquery-1.11.3.js"></script>
<script>
	$(function() {
		$("#menu li").click(function() {
			$(this).addClass("active").siblings().removeClass("active");
			var index = $(this).index();
			$(".tex-box>div").eq(index).show().siblings().hide();
		})
		$("#list-menu a").click(function() {
			$(this).addClass("active").siblings().removeClass("active");
		})
	})
</script>
<style>
.tex-box>div {
	display: none;
}

.tex-box>div:first-child {
	display: block;
}
</style>
</head>
<body>
	<div class="div1">
		<div class="div3">
			<h1 class="head1">邮政分公司外勤管理系统</h1>
		</div>
	</div>
	<div class="div1">
		<div class="div3">
			<ul class="nav nav-tabs nav-justified" id="menu">
				<li role="presentation" class="active"><a href="#">用户管理</a></li>
				<li role="presentation"><a href="#">部门管理</a></li>
				<li role="presentation"><a href="#">业务管理</a></li>
				<li role="presentation"><a href="#">业务管理</a></li>
				<li role="presentation"><a href="#">角色管理</a></li>
				<li role="presentation"><a href="#">角色权限分配</a></li>
				<li role="presentation"><a href="#">系统参数管理</a></li>
			</ul>
		</div>
	</div>

	<div class="tex-box">

		<div class="col-md-12 column ui-sortable">
			<div class="box box-element ui-draggable"
				style="display: block; position: relative; opacity: 1; left: 20px; padding-right: 5px; top: 10px;">
				<div class="div_width">
					<div class="view">
						<table class="table" contenteditable="true">
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>出生日期</th>
									<th>登录名</th>
									<th>密码</th>
									<th>添加</th>
									<th>注销</th>
									<th>更多信息</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Default</td>
									<td>Default</td>
									<td>Default</td>
									<td><button type="button" class="btn btn-success btn-sm"
											contenteditable="true">添加</button></td>
									<td><button type="button" class="btn btn-danger btn-sm"
											contenteditable="true">注销</button></td>
									<td><button type="button" class="btn btn-sm btn-link"
											contenteditable="true" href="#">查看用户详细信息</button></td>
								</tr>
								<tr class="success">
									<td>1</td>
									<td>TB - Monthly</td>
									<td>01/04/2012</td>
									<td>Approved</td>
									<td>Default</td>
									<td>Default</td>
									<td><button type="button" class="btn btn-success btn-sm"
											contenteditable="true">添加</button></td>
									<td><button type="button" class="btn btn-danger btn-sm"
											contenteditable="true">注销</button></td>
									<td><button type="button" class="btn btn-sm btn-link"
											contenteditable="true" href="#">查看用户详细信息</button></td>

								</tr>
								<tr class="error">
									<td>2</td>
									<td>TB - Monthly</td>
									<td>02/04/2012</td>
									<td>Declined</td>
									<td>Default</td>
									<td>Default</td>
									<td><button type="button" class="btn btn-success btn-sm"
											contenteditable="true">添加</button></td>
									<td><button type="button" class="btn btn-danger btn-sm"
											contenteditable="true">注销</button></td>
									<td><button type="button" class="btn btn-sm btn-link"
											contenteditable="true" href="#">查看用户详细信息</button></td>
								</tr>
								<tr class="warning">
									<td>3</td>
									<td>TB - Monthly</td>
									<td>03/04/2012</td>
									<td>Pending</td>
									<td>Default</td>
									<td>Default</td>
									<td><button type="button" class="btn btn-success btn-sm"
											contenteditable="true">添加</button></td>
									<td><button type="button" class="btn btn-danger btn-sm"
											contenteditable="true">注销</button></td>
									<td><button type="button" class="btn btn-sm btn-link"
											contenteditable="true" href="#">查看用户详细信息</button></td>
								</tr>
								<tr class="info">
									<td>4</td>
									<td>TB - Monthly</td>
									<td>04/04/2012</td>
									<td>Call in to confirm</td>
									<td>Default</td>
									<td>Default</td>
									<td><button type="button" class="btn btn-success btn-sm"
											contenteditable="true">添加</button></td>
									<td><button type="button" class="btn btn-danger btn-sm"
											contenteditable="true">注销</button></td>
									<td><button type="button" class="btn btn-sm btn-link"
											contenteditable="true" href="#">查看用户详细信息</button></td>
								</tr>
							</tbody>
						</table>
						<div class="view">
							<ul class="pagination" contenteditable="true">
								<li><a href="#">Prev</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">Next</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>



		</div>
		<div>
			<p class="div0">这是系统参数管理</p>
		</div>
		<div>
		  
			<p class="div0">这是部门管理</p>
		</div>
		<div>
			<p class="div0">这是业务管理1</p>
		</div>
		<div>
			<p class="div0">这是业务管理2</p>
		</div>
		<div>
			<p class="div0">这是角色管理</p>
		</div>
		<div>
			<p class="div0">这是角色权限分配</p>
		</div>

	</div>
</body>
</html>