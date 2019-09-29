<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
		<link rel="stylesheet" href="css/PartMan.css" />
		<style type="text/css">
		.depa{
		  width: 130px;
		  margin: 50px auto 50px;
		  text-align: center;
		}
		
		</style>
	
		
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<div class="content">
			<div class="left">
				<a href="deparementServer?op=show">部门管理</a>
			<a href="PostionMan.jsp">职务管理</a>
			<a href="EmplyeeMan.jsp">员工信息管理</a>
			<a href="PostionCall.jsp">岗位调用管理</a>
			<a href="InforSelect.jsp">信息查询管理</a>
			<a href="Infor_Analyst.jsp">信息分析管理</a>	
			</div>
			<div class="rightb">
				<p>部门管理</p>
				<a href="PartAdd.jsp" class="add">添加部门</a>
			
			<c:if test="${requestScope.departmentList.size()>0}">
			
				<table border="1" cellpadding="0" cellspacing="0">
					<thead>
						<th>部门编号</th>
						<th>部门名称</th>
						<th>部门描述</th>
						<th>执行操作</th>
					</thead>
					 <c:forEach items="${requestScope.departmentList}" var="depart">
					<tr>
						<td>${depart.departmentId}</td>
						<td>${depart.departmentName}</td>
						<td>${depart.departmentDesc}</td>
						<td><a href="deparementServer?op=delete&departmentId=${depart.departmentId}" onclick="return confirm('确定删除')"> 删除</a> <a href="deparementServer?op=update&departmentId=${depart.departmentId}">修改</a> </td>
					</tr>
					</c:forEach>
				</table>
					<div class="bott">
				<c:forEach begin="1" end="${requestScope.allPageNumber}" var="num">
			      <c:if test="${requestScope.page==num}">
			   
			      	<a href="javascript:void(0);" style="background-color: blue;color: white;">${num}</a>
			      </c:if>
			       <c:if test="${requestScope.page!=num}">
					<a href="deparementServer?op=show&cruentPage=${num}" >${num}</a>
					  </c:if>
				
				</c:forEach>
				</div>
				</c:if>
				
					<c:if test="${requestScope.departmentList.size()==0}">
					 <div class="depa">没有任何部门</div> 
					</c:if>
			</div>
			
		
			
		</div>
		
</body>
</html>