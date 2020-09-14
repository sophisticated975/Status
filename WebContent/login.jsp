<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>卓越学籍管理系统-登录</title>
		<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style>
			.mydiv{
				margin-top:250px;
				margin-left: 600px;
				background-color: white;
				width: 500px;
				border-radius:25px;
			}
			body{
				background-image:url('image/logo.png');
			}
			
		</style>
	</head>
	<body style="background-color: aqua;">
		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="mydiv">
						<h1 style="color: blue;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户登录</h1>
						<hr>
						<form class="form-horizontal" role="form" action="login.do">
							<div class="form-group">
								 <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputEmail3" name="username" required/>
								</div>
							</div>
							<div class="form-group">
								 <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="inputPassword3" name="password" required/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-2" style="padding-left: 20px;">
									 <button type="submit" class="btn btn-primary col-sm-2">登录</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
