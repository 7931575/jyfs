<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
		<div id="ho">
			
			<jsp:include page="index.jsp"></jsp:include>
				<jsp:include page="top.jsp"></jsp:include>
			
			<div class="box3">
				
				<span onclick="dep()">部门权限检索</span>
				<span onclick="sho()">部门职务权限</span>

		

			</div>
			<div class="tb">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>部门编号</th>
					<th>部门名称</th>
					<th>职务</th>
					<th>操作</th>
				</tr>
				<tr>
					<td>1</td>
				
					<td>技术部</td>
					<td>经理</td>
					<td>
						<a href="updateDemartLimit.jsp">修改</a>|
						<a href="#"  onclick="return confirm('确定要删除')">删除</a>
					</td>
				</tr>			
			</table>
			<div class="dt">
				<a href="#">1</a>
				<a href="#">1</a>
				<a href="#">1</a>
				<a href="#">1</a>
				<a href="#">1</a>
			</div>
			</div>
		</div>
		
	<div id="departmentSearch" class="sd">
			<span class="clo" onclick="cl()">关闭</span>

			<form action="departmentLimitList.jsp" method="get">

				<div class="sele">
					部门:
					<select>
						<option>---请选择---</option>
					</select><br /><br />
					
					<input type="submit" value="确定" class="stj" />
				</div>
				</form>
		</div>
		<div id="searchDe" class="sd">
			<span class="clo" onclick="gb()">关闭</span>

			<form action="departmentLimitList.jsp" method="post">

				<div class="sele">
					部门:
					<select>
						<option>---请选择---</option>
					</select><br /> 职位:
					<select>
						<option>---请选择---</option>
					</select><br />
					<input type="submit" value="确定" class="stj" />
				</div>
			</form>

		</div>

		<div class="right"></div>
	</body>
	<script type="text/javascript">
		function dep(){
		var p=	document.getElementById("departmentSearch");
			var ho = document.getElementById("ho");
			ho.className = "hid";
			p.className = "s";
		}
		function cl(){
			var departmentSearch = document.getElementById("departmentSearch");
			var ho = document.getElementById("ho");
			departmentSearch.className = "sd"
			ho.className = "yb";
		}
		
		function sho() {
			var searchDe = document.getElementById("searchDe");
			var ho = document.getElementById("ho");
			ho.className = "hid";
			searchDe.className = "s";

		}

		function gb() {
			var searchDe = document.getElementById("searchDe");
			var ho = document.getElementById("ho");
			searchDe.className = "sd"
			ho.className = "yb";
		}
		var btn = document.getElementsByClassName("btn")[0];
		var right = document.getElementsByClassName("right")[0];
		var i = 0;
		btn.onclick = function() {
			i++;
			if(i % 2 != 0) {
				right.style.right = "0px";
			} else {
				right.style.right = "-200px";
			}

		}
	</script>

</html>