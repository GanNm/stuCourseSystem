<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.Student"%>
<%@page import="dao.CourseDao"%>
<%@page import="vo.Course"%>
<%@page import="dao.TeacherDao"%>
<%@page import="vo.Teacher"%>
<%@page import="dao.ScoreDao"%>

<body bgcolor=#cdf2e3>
	<center><font size="+1" color="red">${msg4}</font></center>	
	<c:if test="${msg4==null}">
	<table width="1000" height="200" align="center" border="1" cellpadding="3">
    <tr bgcolor="#B0E0E6">
    	<td colspan="5"><font color="#556B2F"> ѡ�ν�����£�</font></td>
    </tr>
  	<tr bgcolor="#F0FFF0">
	    <td><div align="center">�γ̱��</div></td>
	    <td><div align="center">�γ�����</div></td>
	    <td><div align="center">ѧ��</div></td>
	    <td><div align="center">ְ����</div></td>
	    <td><div align="center">�ڿ���ʦ</div></td>
  	</tr>	
  	<c:forEach items="${selectedcourses}" var="selectedcourse">
		<tr bgcolor="#F0FFF0">
		<td><div align="center">${selectedcourse.courseno }</div></td>
		<td><div align="center">${selectedcourse.coursename }</div></td>
		<td><div align="center">${selectedcourse.credit }</div></td>
		<td><div align="center">${selectedcourse.teano }</div></td>
		<td><div align="center">${selectedcourse.teaname }</div></td>
		</tr>
	</c:forEach>
	</table>
  </c:if>
</body>

