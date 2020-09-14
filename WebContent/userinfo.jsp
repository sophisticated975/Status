<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>卓越学籍管理系统-用户信息</title>
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style>
			body{
				background-color: aliceblue;
			}
			.white{
				background-color: #FFFFFF;
			}
			.aqua{
				background-color: aqua;
			}
		</style>
	</head>
	<body>
		<div class="container white">
			<div class="row clearfix" style="margin-top: 15px;">
				<div class="col-md-12 column aqua">
					<%@include file="header.jsp" %>
				</div>
			</div>
			<div class="row clearfix" style="margin-top: 30px;">
				<div class="col-md-12 column">
					<table class="table">
						<caption>用户信息</caption>
					   <tbody>
					      <tr>
					         <td>用户名</td>
					         <td>${username }</td>
					      </tr>
					      <tr>
					         <td>密码</td>
					         <td>*********</td>
					      </tr>
					   </tbody>
					</table>
					<a href="modify.jsp"><button type="button" class="btn btn-primary btn-lg btn-block">修改密码</button></a>
				</div>
			</div>
		</div>
	</body>
</html>
