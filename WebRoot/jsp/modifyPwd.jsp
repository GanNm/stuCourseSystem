<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
  <body bgcolor=#cdf2e3>
  	<center><font size="+1" color="red">${okMsg9}</font></center>	<br><br>
    <c:if test="${okMsg9==null}">
    	<form action="/EduSystem/servlet/ModifyPwdServlet" method="post">
    		<table align=center>
    			<tr>
    				<td align=right>��������룺</td>
    				<td align=left><input type="password" name="oldPassword"></td>
    			</tr>
    			<tr>
    				<td align=right>���������룺</td>
    				<td align=left><input type="password" name="newPassword1"></td>
    			</tr>
    			<tr>
    				<td align=right>ȷ�������룺</td>
    				<td align=left><input type="password" name="newPassword2"></td>
    			</tr>
    			<tr>
    				<td align=right><input type="submit" value="�ύ"></td>
    				<td align=left><input type="reset" value="����"></td>
    			</tr>
    			<tr><td colspan=2>&nbsp;</td></tr>
    			<tr>
    				<td colspan=2 align=center><font color=red size=-1>${msg9}</font></td>
    			</tr>
    		</table>
    	</form>
    </c:if>
  </body>
</html>
