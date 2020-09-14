<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<title>卓越学籍管理系统-学生管理</title>
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
						<caption><h1>${myclass }</h1>班级人数：${number }</caption>
						<thead>
							<tr>
								<th>姓名</th>
								<th>性别</th>
								<th>学号</th>
								<th>成绩</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items='${list }' var='list'>
								<tr>
									<td>${list.name }</td>
									<td>${list.sex }</td>
									<td>${list.username }</td>
									<td>
										<c:choose>
								     		<c:when test="${list.score == -1 }">暂时没有成绩</c:when>
								     		<c:otherwise>${list.score}</c:otherwise>
								     	</c:choose>
								     </td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="addstudent.jsp"><button type="button" class="btn btn-primary ">增加学生</button></a>
					<a href="removestudent.jsp"><button type="button" class="btn btn-danger ">删除学生</button></a>
					<a href="score.jsp"><button type="button" class="btn btn-warning ">学生评分</button></a>
					<a href="varscore.jsp"><button type="button" class="btn btn-warning ">评分修改</button></a>
				</div>
			</div>
		</div>
	</body>
</html>