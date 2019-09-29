<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/postionMan.css" />
		<link rel="stylesheet" href="css/postionShow.css" />
		<style type="text/css">
		.bott a{
		margin-left: 0px;
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
				<p>岗位调用管理</p>
				<div class="one">
					<form method="post" action="postionCallServer?op=searchByName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字搜索"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="postionCallServer?op=showAll" style="background-color: #ccc">岗位调动记录</a>
				<a href="PostionCallOper.jsp" class="a1" >员工岗位调动</a>
				
				
			 <div class="ppp">
			 	<c:if test="${requestScope.showList.size()>0}">
				<table border="1" cellpadding="0" cellspacing="0">
			
					<thead>
						<th>员工编号</th>
						<th>员工姓名</th>
						<th>所属部门</th>
						<th>操作</th>
					</thead>
					<c:forEach items="${requestScope.showList}" var="list">
					<tr>
						<td>${list.employeeAccount}</td>
					<td>${list.employeeName}</td>
						
						<td>${list.departmentName}</td>
						<td><a href="postionCallServer?op=showDetail&employeeId=${list.employeeId}" style="width: 40px">查看</a> </td>
						
					</tr>
					</c:forEach>
					
				</table>
				</div>
				<div class="bott">
					<c:forEach begin="1" end="${requestScope.allPageNumber}" var="p">
					  <c:if test="${requestScope.cruentPage==p}">
					    <a href="javascript:void(0);" style="background-color:blue;color: white;">${p}</a>
					  </c:if>
					  <c:if test="${requestScope.cruentPage!=p}">
						<a href="postionCallServer?op=showAll&cruentPage=${p}">${p}</a>
					  </c:if>
					</c:forEach>
				    </div>
				  </c:if>
				  <c:if test="${requestScope.showList.size()==0}">
					<div class=""depa>没有数据</div>
				</c:if>
			</div>
		
			
		</div></div>
		<script type="text/javascript">
		var sub = document.getElementById("sub");
		function b() {
			var bb = false;
			var nr = sub.value;
			if (nr.length == 0) {
				alert("不能为空");

			} else {
				bb = true;
			}
			return bb;
		}
		</script>
</body>
</html>