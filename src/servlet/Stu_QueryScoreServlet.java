package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Student;
import vo.Teacher;

import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;
/** 
 * �ļ���:       Stu_QueryScoreServlet.java 
 * ��    ����    ѧ���鿴���Գɼ�
 */ 
public class Stu_QueryScoreServlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      ѧ���鿴���Գɼ�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
  		ScoreDao sdao = new ScoreDao();
  		
  		try{
  			ArrayList score = sdao.getScoreByStuno(stu.getStuno());//��ȡ�����Ŀ�����Ϣ
  			if(score==null){
  				request.setAttribute("msg3", "�Բ���,����û��ѡ�Σ�");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("score", score);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_queryscore.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
