<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="css/postionMan.css" />
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
				<a href="PartMan.jsp">部门管理</a>
			<a href="PostionMan.jsp">职务管理</a>
			<a href="EmplyeeMan.jsp">员工信息管理</a>
			<a href="PostionCall.jsp">岗位调用管理</a>
			<a href="InforSelect.jsp">信息查询管理</a>
			<a href="Infor_Analyst.jsp">信息分析管理</a>	
			</div>
             <div class="rightb">
				<p>职务管理</p>
				<div class="one">
					<form method="post" action="${pageContext.request.contextPath}/jobServer?op=searchName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="部门名称搜索职务"  id="sub" name="jobName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="jobServer?op=show" class="a1">显示所有职务</a>
					<a href="AddPostion.jsp" class="a2">添加职务</a>
				</div>
				<c:if test="${requestScope.job.size()>0}">
				<table border="1" cellpadding="0" cellspacing="0">
					<thead>
						<th>职务编号</th>
						<th>职务名称</th>
						<th>职务部门</th>
						<th>执行操作</th>
					</thead>
					<c:forEach items="${requestScope.job}" var="p">
					<tr>
						<td>${p.jobId}</td>
						<td>${p.jobName}</td>
						<td>${p.departmentName}</td>
						
						<td><a  href="jobServer?op=delete&jobId=${p.jobId}&jobName=${requestScope.jobName}" onclick="return confirm('确定要删除吗')" >删除|</a><a href="jobServer?op=update&jobId=${p.jobId}">修改</a> </td>
					</tr>
				</c:forEach>
				
				</table>
				<div class="bott">
				<c:forEach begin="1" end="${requestScope.allPageNumber}" var="num">
			      <c:if test="${requestScope.cruentPage==num}">
			   
			      	<a href="javascript:void(0);" style="background-color: blue;color: white;">${num}</a>
			      </c:if>
			       <c:if test="${requestScope.cruentPage!=num}">
					<a href="jobServer?op=searchName&cruentPage=${num}&jobName=${requestScope.jobName}">${num}</a>
					  </c:if>
				
				</c:forEach>
				</div>
				 </c:if> 
				 <c:if test="${requestScope.job.size()==0}">
				  <div class="depa">没有任何内容</div> 
				 
				 </c:if>
			</div>
		</div>
		<script type="text/javascript">

		  var sub=document.getElementById("sub");
	     function b(){
	     	var bb=false;
	     	var nr=sub.value;
	     	if (nr.length==0) {
	     		alert("不能为空");
	     		
	     	} else{
	     		bb=true;
	     	}
	     	return bb;
	     }
	     </script>
</body>
</html>