package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Course;
import vo.Student;
import vo.Teacher;

import dao.CourseDao;
import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;
/** 
 * �ļ���:       Stu_QueryCourseServlet.java 
 * ��    ����    ѧ���鿴ѡ�ν��
 */ 
public class Stu_QueryCourseServlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      ѧ���鿴ѡ�ν��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
		CourseDao cdao = new CourseDao();
		
		try{
			ArrayList selectedcourses = cdao.getCourseByStuno(stu.getStuno());//��ȡ����ѡ�޺õĿγ�
			if(selectedcourses.size()==0){
				request.setAttribute("msg4", "�Բ���,����û��ѡ��!");
			}
			else{
				request.setAttribute("msg4", null);
				request.setAttribute("selectedcourses",selectedcourses);	
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_querycourse.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
