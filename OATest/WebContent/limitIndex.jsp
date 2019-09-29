<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/StaffInfor.css" />
<link rel="stylesheet" href="css/limit.css" />
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	
	<div class="box">
		<a href="AllLimit.jsp">总权限管理</a> <a href="departmentLimitMan.jsp">部门权限管理</a>
		<a href="LimitDivision.jsp">用户权限分配</a> <a href="PersonLimitInfor.jsp">个人权限信息</a>
	</div>


	<div class="right"></div>
</body>
</html>