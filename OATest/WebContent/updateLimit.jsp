<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<body>
	<jsp:include page="index.jsp"></jsp:include>
		<jsp:include page="top.jsp"></jsp:include>
		<div class="leftn">
			<a href="limitServer?op=showAllLimits">显示所有权限</a>
			<a href="addLimit.jsp">添加新的权限</a>

		</div>
		<div class="addLi">
		<c:if test="${!empty requestScope.list}">
			<form method="post" action="limitServer?op=update&limitId=${requestScope.list.limitId}">
				<span class="qx">权限名称:<input class="pu" type="text" name="limitName" value="${requestScope.list.limitName}"/></span><br /><br /><br />
				<span class="de">权限描述:</span><textarea class="te" cols="30" rows="10" name="limitDesc">${requestScope.list.limitDesc}</textarea>
			   <br><input type="submit"  class="st"/>
			</form>
		</c:if>
		</div>
		<div class="right"></div>
	</body>

		

</html>