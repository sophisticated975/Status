<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<title>卓越学籍管理系统-用户删除</title>
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
					<div class="alert alert-danger 
						<c:if test="${empty info }">hidden</c:if>
					" style="padding-left:200px;">
						<h3>${info }</h3>
					</div>
					<form class="form-horizontal" role="form" action="removeuser.do">
						<div class="form-group">
							<label class="col-sm-2 control-label">用户名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="username"
									   placeholder="请输入用户名" required>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label">身份</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="identity"
									   placeholder="请输入身份" required>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-danger">完成</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>