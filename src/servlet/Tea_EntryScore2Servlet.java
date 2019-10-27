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
import vo.Score;
import vo.Student;
import vo.Teacher;

import dao.CourseDao;
import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;
/** 
 * �ļ���:       Tea_EntryScore2Servlet.java 
 * ��    ����    ��ʦ¼��ĳ�ſγ̵Ŀ��Գɼ�
 */ 
public class Tea_EntryScore2Servlet extends HttpServlet {
	/** 
	 * �ļ���:      	  doGet
	 * ��    ����    ��ʦѡ��ĳ�ſγ̡�¼��ɼ�����ϵͳ��ȡ���ſγ̵Ŀ����������ʾ
	 */ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher"); 
		String courseno = request.getParameter("courseno");
  		ScoreDao sdao = new ScoreDao();		
  		
		try{
			ArrayList scores = sdao.getScoreByCourseno(courseno);
			if(scores.size()==0){
				request.getSession().setAttribute("msg5", "�Բ���,����ѧ��ѡ�޸��ſγ̣�");
			}
			else{
				request.setAttribute("msg5", null);
				request.setAttribute("scores", scores);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/teacher/tea_entryscore2.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
	/** 
	 * �ļ���:      	  doPost
	 * ��    ����    �Խ�ʦ¼��Ŀ��Գɼ����д������ݴ桱���ߡ��ύ����
	 */ 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String operate = request.getParameter("submit");//��ʦ��ѡ���������ݴ桱���ߡ��ύ��
	   	String[] stunos = request.getParameterValues("stuno");//ѡ�޸��ſγ̵�����ѧ����ѧ��
	   	String[] coursenos = request.getParameterValues("courseno");//���ſγ̵Ŀγ̺�
	  	String[] scores = request.getParameterValues("score");//��ʦ¼��ķ���
	   	ScoreDao sdao = new ScoreDao();
	   	
	   	if(scores!=null){
		   for(int i=0;i<scores.length;i++){
		   	  if(scores[i]!=null){
		   		 try{
		   			 Score sco = new Score();
		   			 sco.setStuno(stunos[i]);
		   			 sco.setCourseno(coursenos[i]);
		   			 sco.setScore(Float.parseFloat(scores[i]));
		   			 sco.setState(operate);
		   		 	 sdao.updateScore(sco);
		   		 	 request.setAttribute("msg6", "����¼��ɹ���");
		   		 }catch(Exception ex){	ex.printStackTrace();}
		   	  }
		   }
		}
	   	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/teacher/tea_entryscore2.jsp");
		dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
	}
}
