<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>		
	</head>

	<body>
 
	<body>
<jsp:include page="index.jsp"></jsp:include>
	<jsp:include page="top.jsp"></jsp:include>
		<div class="leftn">
			<a href="limitServer?op=showAllLimits">显示所有权限</a>
			<a href="addLimit.jsp">添加新的权限</a>

		</div>
		<div class="addLi">
			<form method="post" action="limitServer?op=add">
				<span class="qx">权限名称:<input class="pu" type="text" name="limitName" /></span><br /><br /><br />
				<span class="de">权限描述:</span><textarea class="te" cols="30" rows="10" name="limitDesc"></textarea>
			   <br><input type="submit"  class="st"/>
			</form>
		</div>
		<div class="right"></div>
	</body>


</html>