<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>卓越学籍管理系统-首页</title>
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
					<table class="table">
						<c:choose>
							<c:when test="${identity == '同学' }">
								<caption><h1>学生信息</h1></caption>
								<tbody>
							      <tr>
							         <td>学生姓名</td>
							         <td>${name }</td>
							      </tr>
							      <tr>
							         <td>学生性别</td>
							         <td>${sex }</td>
							      </tr>
								  <tr>
								     <td>学生编号</td>
								     <td>${username }</td>
								  </tr>
							      <tr>
							         <td>学校</td>
							         <td>${school }</td>
							      </tr>
								  <tr>
								     <td>所属院系</td>
								     <td>${department }</td>
								  </tr>
								  <tr>
								     <td>专业名称</td>
								     <td>${major }</td>
								  </tr>
								  <tr>
								     <td>班级名称</td>
								     <td>${myclass }</td>
								  </tr>
								  <tr>
								     <td>学期成绩</td>
								     <td>
								     	<c:choose>
								     		<c:when test="${score == -1 }">暂时没有成绩</c:when>
								     		<c:otherwise>${score}</c:otherwise>
								     	</c:choose>
									 </td>
								  </tr>
							   </tbody>
							</c:when>
							<c:when test="${identity == '老师' }">
								<caption><h1>老师信息</h1></caption>
								<tbody>
							      <tr>
							         <td>老师姓名</td>
							         <td>${name }</td>
							      </tr>
							      <tr>
							         <td>老师性别</td>
							         <td>${sex }</td>
							      </tr>
								  <tr>
								     <td>老师编号</td>
								     <td>${username }</td>
								  </tr>
							      <tr>
							         <td>学校</td>
							         <td>${school }</td>
							      </tr>
								  <tr>
								     <td>所属院系</td>
								     <td>${department }</td>
								  </tr>
								  <tr>
								     <td>专业名称</td>
								     <td>${major }</td>
								  </tr>
								  <tr>
								     <td>班级名称</td>
								     <td>${myclass }</td>
								  </tr>
								  <tr>
								     <td>教授课程</td>
								     <td>${course }</td>
								  </tr>
							   </tbody>
							</c:when>
							<c:when test="${identity == 'admin' }">
								<h1>欢迎管理员</h1>
							</c:when>
						</c:choose>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>
