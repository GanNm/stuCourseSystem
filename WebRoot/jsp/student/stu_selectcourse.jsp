<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.Student"%>
<%@page import="dao.CourseDao"%>
<%@page import="vo.Course"%>
<%@page import="dao.TeacherDao"%>
<%@page import="vo.Teacher"%>
<%@page import="dao.ScoreDao"%>

<body bgcolor=#cdf2e3>
	<center><font size="+1" color="red">${msg2}</font></center>
	<c:if test="${msg2==null}">
	<form method="post" action="/EduSystem/servlet/Stu_SelectCourseServlet">
	<table width="1000" height="200" align="center" border="1" cellpadding="3">
	  <tr>
	  	<td colspan="6" bgcolor="#B0E0E6"><font color="#556B2F">������ѡ��Ŀγ����£� &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">(ע:����ѡ��20��ѧ��,�Ҳ��ܶ�ѡ)</td>
	  </tr>
	  <tr bgcolor="#F0FFF0">
	    <td><div align="center">�γ̱��</div></td>
	    <td><div align="center">�γ�����</div></td>
	    <td><div align="center">ѧ��</div></td>
	    <td><div align="center">ְ����</div></td>
	    <td><div align="center">�ڿ���ʦ</div></td>
	    <td><div align="center">ѡ��</div></td>
	   </tr>
	   <c:forEach items="${allcourse}" var="course">
			<tr bgcolor="#F0FFF0">
			<td><div align="center">${course.courseno }</div></td>
			<td><div align="center">${course.coursename }</div></td>
			<td><div align="center">${course.credit }</div></td>
			<td><div align="center">${course.teano }</div></td>
			<td><div align="center">${course.teaname }</div></td>
			<td><div align="center"><input type="radio" name="${course.coursename }" value="${course.courseno }"></div></td>
			</tr>
	   </c:forEach>
	    <tr bgcolor="#B0E0E6">
	       <td colspan="6"><div align="center"><input type="submit" value="�ύ���"></div></td>
	    </tr>
	</table>
	</form>
	</c:if>
</body>