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
	  	<td colspan="6" bgcolor="#B0E0E6"><font color="#556B2F">您可以选择的课程如下： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">(注:必须选满20个学分,且不能多选)</td>
	  </tr>
	  <tr bgcolor="#F0FFF0">
	    <td><div align="center">课程编号</div></td>
	    <td><div align="center">课程名称</div></td>
	    <td><div align="center">学分</div></td>
	    <td><div align="center">职工号</div></td>
	    <td><div align="center">授课老师</div></td>
	    <td><div align="center">选课</div></td>
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
	       <td colspan="6"><div align="center"><input type="submit" value="提交结果"></div></td>
	    </tr>
	</table>
	</form>
	</c:if>
</body>