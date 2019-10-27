<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body bgcolor=#cdf2e3>
	<center><font size="+1" color="red">${msg7 }</font></center>
	<c:if test="${msg7==null}">
  	<form action="/EduSystem/servlet/Tea_ExportScoreServlet" method="post">
  		<table width="1000" height="200" align="center" border="1" cellpadding="3">
			  <tr bgcolor="#B0E0E6">
			    <td colspan="5"> 课程信息如下：</td>
			  </tr>
			  <tr bgcolor="#F0FFF0">
			    <td><div align="center">课程编号</div></td>
			    <td><div align="center">课程名称</div></td>
			    <td><div align="center">学生学号</div></td>
			    <td><div align="center">学生姓名</div></td>
			    <td><div align="center">分数</div></td>
			  </tr>
  		 <c:forEach items="${scores}" var="score">
	  		<tr bgcolor="#F0FFF0">
			    <td><div align="center">${score.courseno }<input type="hidden" name="courseno" value="${score.courseno }"></div></td>
			    <td><div align="center">${score.coursename }</div></td>
			    <td><div align="center">${score.stuno }</div></td>
			    <td><div align="center">${score.stuname }</div></td>
			    <td>
			    	<c:choose>
				 		<c:when test="${score.score==0 }">
	  					<div align="center">未登分</div>
	  			  		</c:when>
	  			  		<c:otherwise>
	  			  	       <c:choose>
	  			  	          <c:when test="${score.operation==null||score.operation=='暂存'}">
	  					      <div align="center"><input type="text" name="score" value="${score.score }"></div>
	  				          </c:when>
	  				          <c:when test="${score.operation=='提交'}">
	  					      <div align="center">${score.score }</div>
	  				          </c:when>
	  				       </c:choose>
	  			  	    </c:otherwise>
	  			  	</c:choose>
	  			</td> </tr>
	  		</c:forEach>
	  		<tr bgcolor="#B0E0E6">
	       		<td colspan="6"><div align="center"><input type="submit" value="导出到PDF文件"></div></td>
	    	</tr>
  	      </table>
	   </form>
	</c:if>
</body>
