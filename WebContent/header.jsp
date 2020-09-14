<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul class="nav nav-tabs">
						<li>
							 <a href="index.jsp">首页</a>
						</li>
						<c:if test="${identity == '老师' }">
							<li>
							 <a href="manage.do">学生管理</a>
							</li>
						</c:if>
						<c:if test="${identity == 'admin' }">
							<li>
							 <a href="teachermanage.do">老师管理</a>
							</li>
							<li>
							 <a href="removeuser.jsp">用户删除</a>
							</li>
						</c:if>
						<li class="dropdown pull-right">
							 <a href="#" data-toggle="dropdown" class="dropdown-toggle">
							 	${name } ${identity }
							 <strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="userinfo.jsp">用户信息</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="loginout">注销</a>
								</li>
							</ul>
						</li>
					</ul>
</body>
</html>