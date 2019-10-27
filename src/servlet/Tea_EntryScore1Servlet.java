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
 * �ļ���:       Tea_EntryScore1Servlet.java 
 * ��    ����    ��ʦ¼��ĳ�ſγ̵Ŀ��Գɼ�
 */ 
public class Tea_EntryScore1Servlet extends HttpServlet {
	/** 
	 * �ļ���:      	  doGet
	 * ��    ����    ��ʦ�����¼��ɼ����˵���ϵͳ��ȡ�俪������пγ̣�������ѡ��ĳ�ſγ̽��гɼ�¼��
	 */ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
		CourseDao cdao = new CourseDao();
		
		try{
			ArrayList courses = cdao.getCourseByTeano(tea.getTeano());//��ȡ��ʦ��������пγ̣������ʦѡ��γ̽��гɼ�¼��
			if(courses.size()!=0){
				request.setAttribute("courses",courses);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/teacher/tea_entryscore1.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
