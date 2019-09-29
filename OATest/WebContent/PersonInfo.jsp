<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/postionMan.css" />
				<link rel="stylesheet" href="css/personInfo.css" />
<script type="text/javascript" src="js/check.js"></script>
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
					<form method="post" action="employeeServer?op=searchName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="按名字查询"  id="sub" name="employeeName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>			
					<form method="post" action="employeeServer?op=searchByDepartmentName" onsubmit="return ba()">
						<input type="text" class="inp" placeholder="按部门查询"  id="part" name="departmentName"/>
						<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="employeeServer?op=show">所有员工信息</a>
						<a href="AddPersonInfo.jsp">添加员工</a>
							<a href="employeeServer?op=personInfor">个人信息</a>
				</div>
				<div class="per">
				<c:if test="${! empty requestScope.details}">
					<table border="1px" cellpadding="0" cellspacing="0">
					
						<tr>
							<td>编号:${requestScope.details.employeeId}</td>					
							<td>姓名:${requestScope.details.employeeName}</td>
                        </tr>
                        <tr>
							<td>民族:${requestScope.details.employeeNation}</td>					
							<td>年龄:${requestScope.details.age}</td>
                        </tr>
                        <tr>
							<td>性别:<c:if test="${requestScope.details.employeeGender==1}">
							                   男
							          </c:if>
							          <c:if test="${requestScope.details.employeeGender==0}">
							                   女
							          </c:if>
							</td>				
							<td>电话:${requestScope.details.employeeIphone}</td>
                        </tr>
                        <tr>
							<td>身份证:${requestScope.details.employeeIdNumber}</td>					
							<td>现居住地址:${requestScope.details.employeeAddress}</td>	
                        </tr>
                        <tr>
							<td>毕业院校:${requestScope.details.employeeGraduateSchool}</td>
							<td>学历:${requestScope.details.employeeEduBackground}</td>
                        </tr>
                        <tr>
							<td>结婚信息:<c:if test="${requestScope.details.employeeMarry==1}">
							是
							</c:if>
							<c:if test="${requestScope.details.employeeMarry==0}">
							否</c:if>
							</td>	
								<td>部门:${requestScope.details.departmentName}</td>	
                        </tr>
                        <tr>
						
							<td>职位:${requestScope.details.jobName}</td>
							<td>账号:${requestScope.details.employeeAccount}</td>
                        </tr>
						
                         <tr>
                        	
                        	
                        	<td>密码:${requestScope.details.employeePassWord}</td>
                        	<td>进入公司时间:${requestScope.details.employeeEntryTiime}</td>
                        </tr>
                        <tr>
                        		
						<td>头像:<img src="${requestScope.details.employeeHeadImg}"  class="im"/></td>				
							
                        </tr>
                      
					</table>
					<a href="UpdatePass.jsp">修改密码</a>
					 </c:if>
					 
					 
				</div>
				  
			</div>
		
			
		</div>
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
		var part = document.getElementById("part");
		function ba() {
			var bb = false;
			var nr = part.value;
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