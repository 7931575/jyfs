<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  .o{
   width: 300px;
   height: 300px;
   margin: 100px auto 20px;
  }
  .o input{
  height: 22px;
  margin-top: 15px;
  }
</style>
</head>
<body>
<h2 style="text-align: center;">登录</h2>
<hr>
	<form action="employeeServer?op=login" method="post">
         <div class="o">  
             账号:<input type="text" name="employeeAccount"><br>
             密码:<input type="text" name="employeePassWord"><br>
             <input type="submit" value="登录">
</div>  
     </form>
</body>
</html>