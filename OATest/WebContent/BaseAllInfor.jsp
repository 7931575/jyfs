<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
		<link rel="stylesheet" href="css/postionShow.css" />
		<style type="text/css">
		.bott a{
		margin-left: 0;
		}
	
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
				<p>信息查询管理</p>
				<div class="one">
					<form method="post" action="inforSelect?op=searchByName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字搜索下属"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="inforSelect?op=endLine" class="a2">我的下属</a>
				<a href="inforSelect?op=allInfor" class="a1" >显示所有员工</a>
				
				 <c:if test="${requestScope.showList.size()>0}">
			 <div class="ppp">
			
				<table border="1" cellpadding="0" cellspacing="0">
					<thead>
						<th>员工编号</th>
						<th>员工姓名</th>
						<th>员工职位</th>
						<th>所属部门</th>
						<th>执行操作</th>
					</thead>
					<c:forEach items="${requestScope.showList}" var="p">
					<tr>
					
						<td>${p.employeeAccount}</td>
						<td>${p.employeeName}</td>
						<td>${p.jobName}</td>
						<td>${p.departmentName}</td>
						
						<td><a  href="inforSelect?op=showDetail&employeeId=${p.employeeId}">查看</a>
							</td>
					</tr>
					</c:forEach>
					
				</table>
				</div>
				<div class="bott">
				<c:forEach begin="1" end="${requestScope.allPageNumber}" var="page">
				<c:if test="${requestScope.cruentPage==page}">
				<a href="javascript:void(0);" style="background-color: blue;color: white">${page}</a>
				</c:if>
				<c:if test="${requestScope.cruentPage!=page}">
					<a href="inforSelect?op=allInfor&cruentPage=${page}">${page}</a>
					</c:if>
					</c:forEach>
				</div>
				</c:if>
				 <c:if test="${requestScope.showList.size()==0}">
				           <div class="depa">没有数据</div>
				 </c:if>
				  
			</div>
		
			
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