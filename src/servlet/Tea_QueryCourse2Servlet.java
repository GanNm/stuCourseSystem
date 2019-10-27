package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * �ļ���:       Tea_QueryCourse2Servlet.java 
 * ��    ����    ��ʦѡ��ĳ�ſγ̲鿴��Ӧ�Ŀ�����Ϣ
 */ 
public class Tea_QueryCourse2Servlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      ��ʦѡ��ĳ�ſγ̣�������ġ��鿴�����ӣ�ϵͳ��ȡ���ſγ̵Ŀ�����Ϣ����ת����ҳ����ʾ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String courseno = request.getParameter("courseno");
  		ScoreDao sdao = new ScoreDao();	
  		
		try{
			ArrayList scores = sdao.getScoreByCourseno(courseno);//��ȡ��ѡ�γ̵Ŀ�����Ϣ
			if(scores.size()==0){
				request.getSession().setAttribute("msg7", "�Բ���,����ѧ��ѡ�޸��ſγ̣�");
			}
			else{
				request.setAttribute("msg7", null);
				request.setAttribute("scores", scores);
			}
			request.getRequestDispatcher("/jsp/teacher/tea_querycourse2.jsp").forward(request, response);//�ڲ���ת
		}catch(Exception ex){	ex.printStackTrace();}
	}
}
