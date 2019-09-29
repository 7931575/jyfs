<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
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
				<p>员工信息管理</p>
				<div class="one">
					<form method="post" action="archivesServer?op=searchByName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字查询档案"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>			
					<form method="post" action="archivesServer?op=searchByDepartName" onsubmit="return bb()">
						<input type="text" class="inp" placeholder="按部门查询档案"  id="part" name="departmentName"/>
						<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="archivesServer?op=showAll">所有员工档案</a>
						<a href="AddRecord.jsp">添加档案</a>
						
				</div>
				<c:if test="${requestScope.showList.size()>0}">
					<table border="1px" cellpadding="0" cellspacing="0">
						<thead>
						<th>员工编号</th>
						<th>员工姓名</th>
						<th>所属部门</th>
						<th>执行操作</th>
					</thead>
					<c:forEach items="${requestScope.showList}" var="list">
					<tr>
						<td>${list.employeeAccount}</td>
						<td>${list.employeeName}</td>
						<td>${list.departmentName}</td>
						<td><a  href="archivesServer?op=detail&employeeId=${list.employeeId}" >操作</a></td>
					</tr>
					</c:forEach>
					</table>
					<div class="bott">
					<c:forEach begin="1" end="${requestScope.allPageNumber}" var="p">
					  <c:if test="${requestScope.cruentPage==p}">
					    <a href="javascript:void(0);" style="background-color:blue;color: white;">${p}</a>
					  </c:if>
					  <c:if test="${requestScope.cruentPage!=p}">
						<a href="archivesServer?op=showAll&cruentPage=${p}">${p}</a>
					  </c:if>
					</c:forEach>
				    </div>
					</c:if>
						
				<c:if test="${requestScope.showList.size()==0}">
					没有数据
				</c:if>
						
			</div>
		
			
		</div>
		<script type="text/javascript">
		
			var subb= document.getElementById("sub");
			var partt= document.getElementById("part");
			        
			 function b(){
				 var c=false;
				 
				 if(subb.value.length==0){
					
					 alert("不能为空");
				 }else{
					 c=true;
				 }
				 return c;
			 }
			 function bb(){
				 var cc=false;
				 if(partt.value.length==0){
					 alert("不能为空");
				 }else{
					
					 cc=true;
				 }
				 return cc;
			 }

		</script>
</body>
</html>