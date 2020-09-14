<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<title>卓越学籍管理系统-学生评分</title>
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
					<form class="form-horizontal" role="form" action="putscore.do">
						<table class="table table-striped">
						  <caption><h1>${myclass }</h1></caption>
						  <thead>
						    <tr>
						      <th>姓名</th>
						      <th>学号</th>
						      <th>成绩</th>
						    </tr>
						  </thead>
						  <tbody>
						   <c:forEach items='${list }' var='list'>
								<tr>
									<td>${list.name }</td>
									<td>${list.username }</td>
									<td class="col-md-2">
						    		  <input type="text" class="form-control" id="score" name="${list.username }" placeholder="请输入分数" required>
						      		</td>
								</tr>
							</c:forEach>
						  </tbody>
						</table>
						<button type="submit" class="btn btn-warning">完成</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>