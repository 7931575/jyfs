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
				<a href="AllUserLimit.jsp">所有用户权限</a>
				<span onclick="sho()">详细查询</span>

			</div>
			<div class="tb">
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>账号</th>
					<th>姓名</th>
					<th>部门</th>
					<th>职务</th>
					<th>操作</th>
				</tr>
				<tr>
					<td>1</td>
					<td>张三</td>
					<td>技术部</td>
					<td>经理</td>
					<td>
						<a href="updatePersonLimit.jsp">修改</a>|
						<a href="#"  onclick="return confirm('确定要删除')">删除</a>
					</td>
				</tr>			
			</table>
			
			</div>
		</div>
		
		
		<div id="searchDe" class="sd">
			<span class="clo" onclick="gb()">关闭</span>

			<form>

				<div class="sele">
					部门:
					<select>
						<option>---请选择---</option>
					</select><br /> 职位:
					<select>
						<option>---请选择---</option>
					</select><br /> 员工编号:
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

		
	</script>

</html>