<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="vo.Student"%>
<html>
	<body bgcolor="#cdf2e3">
		<table witdh="100%" height="100%" border="1">
			<tr height="10%"><td colspan="2"><p><img src="/EduSystem/res/images/img01.jpg"></p></td></tr>
			<tr>
				<td height="10%" width="10%" align="center"><a href="/EduSystem/servlet/Stu_SelectCourseServlet" target="iframe1" style=text-decoration:none>����ѡ��</a></td>
				<td rowspan="8"><iframe width="100%" height="100%" name="iframe1" frameborder="0" src="/EduSystem/jsp/right.jsp"></iframe></td>
			</tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Stu_QueryCourseServlet" target="iframe1" style=text-decoration:none>ѡ�ν��</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/Stu_QueryScoreServlet" target="iframe1" style=text-decoration:none>ѧ���ɼ�</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/jsp/modifyPwd.jsp" target="iframe1" style=text-decoration:none>�޸�����</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="stu_ope.jsp" style=text-decoration:none>��������</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="stu_ope.jsp" style=text-decoration:none>�� ̳</a></td></tr>
			<tr height="10%"><td width="10%" align="center"><a href="/EduSystem/servlet/LogoutServlet" style=text-decoration:none>�� ��</a></td></tr>
			<tr heigth="10%"><td>&nbsp;</td></tr>
			<tr heigth="5%"><td colspan="2">
			<pre style="display:inline"><font color="#556B2F">    ${type }��[${student.stuno}] ${student.stuname }                                                                                                                     COPYRIGHT 2000-2010 BY  ����  ALL RIGHTS RESERVED</font></pre>
			</td></tr>
		</table>
	</body>
</html>