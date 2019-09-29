<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/AddPart.css" />
<script type='text/javascript' src='/OATest/dwr/engine.js'></script>
  <script type='text/javascript' src='/OATest/dwr/interface/departmentDwr.js'></script>
   <script type='text/javascript' src='/OATest/dwr/interface/GradeDwr.js'></script>

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
				<p>职务管理</p>
				
				<div class="one">
					<form method="post" action="${pageContext.request.contextPath}/jobServer?op=searchName" onsubmit="return b()">
					<input type="text" class="inp" placeholder="部门名称搜索职务"  id="sub" name="jobName"/>
					<input type="submit"  value="确定" class="bt"/>
					</form>
					<a href="jobServer?op=show" class="a1">显示所有职务</a>
					<a href="AddPostion.jsp" class="a2">添加职务</a>
				</div>
				 <div class="addPart">
				 <form action="${pageContext.request.contextPath}/jobServer?op=doUpdate&jobId=${requestScope.job.jobId}" method="post">
				 
				 <span>	职务名称：<input type="text" value="${requestScope.job.jobName}" name="jobName"/></span><br />
				 <span>	
				  职务部门： <select id="op" name="departmentName">
				  	 
				  </select>
				 </span><br />
				 
				  <span>	
				  职务级别： <select id="oa" name="grade">
				  	
				  </select>
				 </span><br />
				 <span>	职务描述：<textarea cols="40" rows="5" name="jobDesc">${requestScope.job.jobDesc}</textarea></span>
				<input type="submit" class="sub" value="确定">
				 </form>
				 </div>
				  
			</div>
		
			
		</div>
		<script type="text/javascript">
		window.onload=function(){
		
			departmentDwr.getPart(function(data){
				var selec=	document.getElementById("op");
				for(var i=0;i<data.length;i++){
					var opt=document.createElement("option");
					opt.innerHTML=data[i];
					opt.setAttribute("value",data[i]);
					if(data[i]=='${requestScope.job.departmentName}'){
						opt.setAttribute("selected",true);
					}
					selec.appendChild(opt);
				}
			});
			GradeDwr.getGrade(function(data){
				var oa=	document.getElementById("oa");
				for(var i=0;i<data.length;i++){
					var opt=document.createElement("option");
					opt.innerHTML=data[i];
					opt.setAttribute("value",data[i]);
					oa.appendChild(opt);
				}
			});
			
		}
		
		
		
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