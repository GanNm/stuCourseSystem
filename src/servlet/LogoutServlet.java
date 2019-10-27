package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Student;
import vo.Teacher;

import dao.StudentDao;
import dao.TeacherDao;
/** 
 * �ļ���:       LogoutServlet.java 
 * ��    ����    ���˳���¼���д���
 */ 
public class LogoutServlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      ���"�˳�"�˵�����Get��ʽ�ύ����servlet�������˳���¼�Ĵ���
	 * @param��			  HttpServletRequest request, HttpServletResponse response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		/*��������session����ת�ص�¼����*/
		response.setHeader("Cache-Control","no-cache");
		request.getSession().invalidate();
		response.sendRedirect("/EduSystem/index.jsp");
	}
	
}
