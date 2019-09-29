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
<jsp:include page="index.jsp"/>
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
				<form action="${pageContext.request.contextPath}/jobServer?op=addPart" method="post" onsubmit="return checkForm()">
				
				 <div class="addPart">
				 <span>	职务名称：<input type="text" name="jobName" id="pn"/></span><br />
				 <span>	
				  职务部门： <select id="op" name="departmentName" onclick="ck()">
				  	 
				  	
				  </select>
				 </span><br />
					  <span>	
				  职务级别： <select id="oa" name="grade">
				  	    
				  </select>
				 </span><br />
				 <span>	职务描述：<textarea cols="40" rows="5" name="jobDesc"></textarea></span>
				<input type="submit" class="sub" value="确定">
				 </div>
				  </form>
			</div>
		
			
		</div>
		<script type="text/javascript">
		function checkForm() {
			var oa=	document.getElementById("pn");
			if(oa.value.length==0){
				alert("名称不能为空")
				return false;
			}else{
				var oo=	document.getElementById("oa");
				if(oo.value.length==0){
					alert("职务级别不能为空")
					return false;	
				}else{
					return true;
				}
			
			}
		}
		window.onload=function(){
		
			departmentDwr.getPart(function(data){
				var selec=	document.getElementById("op");
				for(var i=0;i<data.length;i++){
					var opt=document.createElement("option");
					opt.innerHTML=data[i];
					opt.setAttribute("value",data[i]);
					selec.appendChild(opt);
				}
			});
			
		}
		
		function ck() {
			GradeDwr.getGrade(function(data){
				var oa=	document.getElementById("oa");
				oa.options.length=0;
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