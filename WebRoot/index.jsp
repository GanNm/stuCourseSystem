<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
  <body >
  <script type="text/javascript">
  		function getCode(){
  			document.form1.codeimg.src="/EduSystem/res/code/code.jsp";
  		}
  </script>
    <table bgcolor="#cdf2e3" width="100%" height="80%">
  <tr>
    <td height="30%" colspan="2"><p><img src="/EduSystem/res/images/part01.jpg" width="1440" height="256"></p>
    </td>
  </tr>
  <tr>
    <td width="36%" height="40%">
    	<form method="post" action="/EduSystem/servlet/LoginServlet" name="form1">
		<table width="280" align="center">
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">身份:</font></div></td>
		    <td><select name="type" style="width:152">
		        <option value="student" selected>学生</option>
		        <option value="teacher">教师</option>
		      </select></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">账号:</font></div></td>
		    <td><input type="text" name="account"></td>
		  </tr>
		  <tr>
		    <td><div align="right"><font size="-1" color="#556B2F">密码:</font></div></td>
		    <td><input type="password" name="password" size=21></td>
		  </tr>
		  <tr><td><div align="right"><font size="-1" color="#556B2F">验证码:</font></div></td>
		  	  <td><input name="code" size=12> <a href="#" onclick="getCode()"><font size="-1">看不清，换一张</font></a></td>
		  </tr>
    	  <tr><td colspan="2"><div align="center">
    	  	  <img name="codeimg" src="/EduSystem/res/code/code.jsp"></div></td>
    	  </tr>
		  <tr>
		    <td colspan="2"><div align="center">
		        <input type="submit" name="submit" value="登录">
		        <input type="reset" name="reset" value="重置">      
		          </div></td>
		  </tr>
		  <tr>
		    <td colspan="2"><div align="center"><font size="-1" color="red"><b>${msg1}</b></font></div></td>
		  </tr>
		</table>
    </form>    </td>
    <td width="64%"><img src="/EduSystem/res/images/part02.jpg" width="925" height="242"></td>
  </tr>
  <tr>
    <td height="10%" colspan="2"><img src="/EduSystem/res/images/part03.jpg" width="1440" height="36"></td>
  </tr>
</table>
	<p align="center"><font size="-1" color="#556B2F">COPYRIGHT 2000-2010 BY 流殇 ALL RIGHTS RESERVED</font></p>
  </body>
</html>
