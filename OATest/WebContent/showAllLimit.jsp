<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<a href="limitServer?op=showAllLimits">显示所有权限</a> <a href="addLimit.jsp">添加新的权限</a>

	</div>
	<div class="showtab">
	<c:if test="${requestScope.showList.size()>0}">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th>权限编号</th>
				<th>权限名称</th>
				<th>权限描述</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.showList}" var="p">
			<tr>
			
				<td>${p.limitId}</td>
				<td>${p.limitName}</td>
				<td>${p.limitDesc}</td>
				<td><a href="limitServer?op=beforeUpda&limitId=${p.limitId}">修改</a>| <a href="limitServer?op=limitDelete&limitId=${p.limitId}"
					onclick="return confirm('确定要删除')" >删除</a></td>
			</tr>
	</c:forEach>
		</table>
		<div class="dt">
			<c:forEach begin="1"  end="${requestScope.allPageNumber}" var="c">
			<c:if test="${requestScope.cruentPage==c}">
			<a href="javascript:void(0)" style="background-color: blue;color: white">${c}</a>
			</c:if>
			<c:if test="${requestScope.cruentPage!=c}">
			<a href="limitServer?op=showAllLimits&cruentPage=${c}">${c}</a>
			</c:if>
			</c:forEach>
		</div>
		</c:if>
	</div>
	
	<div class="right"></div>
</body>


</html>