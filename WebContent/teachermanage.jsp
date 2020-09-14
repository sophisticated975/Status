<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<title>卓越学籍管理系统-老师管理</title>
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style>
			.white{
				background-color: #FFFFFF;
			}
			.aqua{
				background-color: aqua;
			}
		</style>
</head>
	<body style="background-color: aliceblue;">
		<div class="container white">
			<div class="row clearfix" style="margin-top: 15px;">
				<div class="col-md-12 column aqua">
					<%@include file="header.jsp" %>
				</div>
			</div>
			<div class="row clearfix" style="margin-top: 30px;">
				<div class="col-md-12 column">
					<table class="table table-striped">
						<caption><h1>教师信息</h1></caption>
						<thead>
							<tr>
								<th>姓名</th>
								<th>性别</th>
								<th>教师编号</th>
								<th>班级</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items='${tlist }' var='tlist'>
								<tr>
									<td>${tlist.name }</td>
									<td>${tlist.sex }</td>
									<td>${tlist.username }</td>
									<td>${tlist.myclass }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="addteacher.jsp"><button type="button" class="btn btn-primary ">增加老师</button></a>
					<a href="giveclass.jsp"><button type="button" class="btn btn-warning ">老师带班</button></a>
				</div>
			</div>
		</div>
	</body>
</html>