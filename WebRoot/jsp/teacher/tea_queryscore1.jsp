<%@ page contentType="text/html; charset=gb2312" language="java" import="java.util.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="dao.TeacherDao"%>
<%@page import="vo.Teacher"%>
<%@page import="dao.CourseDao"%>
<%@page import="vo.Course"%>

<body bgcolor=#cdf2e3>
<table width="1000" height="200" align="center" border="1" cellpadding="3">
  <tr bgcolor="#B0E0E6">
    <td colspan="5"> 您所开设的课程如下：</td>
  </tr>
  <tr bgcolor="#F0FFF0">
    <td><div align="center">课程编号</div></td>
    <td><div align="center">课程名称</div></td>
    <td><div align="center">学分</div></td>
    <td><div align="center">操作</div></td>
  </tr>
  	 <c:forEach items="${courses}" var="course">
  		<tr bgcolor="#F0FFF0">
   			 <td><div align="center">${course.courseno }</div></td>
    		 <td><div align="center">${course.coursename }</div></td>
   			 <td><div align="center">${course.credit }</div></td>
    		 <td><div align="center"><a href="/EduSystem/servlet/Tea_QueryScore2Servlet?courseno=${course.courseno }">成绩分布</div></td>
  	   </tr>
  	 </c:forEach>	
   </table>
</body>
