<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="vo.Student"%>
<%@page import="dao.ScoreDao"%>
<%@page import="vo.Score"%>

<body bgcolor="#cdf2e3">
	 <center><font size="+1" color="red">${msg3}</font></center>
  	 <c:if test="${msg3==null}">
  	 <form action="/EduSystem/servlet/Stu_ExportScoreServlet" method="post">
  		<table width="1000" height="200" align="center" border="1" cellpadding="3">
	 	 <tr bgcolor="#B0E0E6">
	   		 <td colspan="5"><font color="#556B2F"> 您的课程成绩如下：</font></td>
		 </tr>
	  <tr bgcolor="#F0FFF0">
	    <td><div align="center">课程编号</div></td>
	    <td><div align="center">课程名称</div></td>
	    <td><div align="center">学生学号</div></td>
	    <td><div align="center">学生姓名</div></td>
	    <td><div align="center">分数</div></td>
	  </tr>
  		<c:forEach items="${score}" var="score">
  			<tr bgcolor="#F0FFF0">
		    <td><div align="center">${score.courseno }</div></td>
			<td><div align="center">${score.coursename }</div></td>
			    <td><div align="center">${score.stuno }</div></td>
			    <td><div align="center">${student.stuname }</div></td>
			<c:choose>
			    <c:when test="${score.score!=0}">
			    <td><div align="center">${score.score}</div></td> </c:when>   
  				<c:otherwise>
  				<td><div align="center">未登分</div></td> </c:otherwise>
  			</c:choose>
  			</tr>
  		</c:forEach>
  		<tr bgcolor="#B0E0E6">
	       <td colspan="6"><div align="center"><input type="submit" value="导出到PDF文件"></div></td>
	    </tr>
	  </table>
	  </form>
	</c:if>
</body>
