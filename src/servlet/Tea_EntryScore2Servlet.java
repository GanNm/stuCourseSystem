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
 * 文件名:       Tea_EntryScore2Servlet.java 
 * 描    述：    教师录入某门课程的考试成绩
 */ 
public class Tea_EntryScore2Servlet extends HttpServlet {
	/** 
	 * 文件名:      	  doGet
	 * 描    述：    教师选择某门课程“录入成绩”，系统获取该门课程的考试情况并提示
	 */ 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher"); 
		String courseno = request.getParameter("courseno");
  		ScoreDao sdao = new ScoreDao();		
  		
		try{
			ArrayList scores = sdao.getScoreByCourseno(courseno);
			if(scores.size()==0){
				request.getSession().setAttribute("msg5", "对不起,暂无学生选修该门课程！");
			}
			else{
				request.setAttribute("msg5", null);
				request.setAttribute("scores", scores);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/teacher/tea_entryscore2.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}catch(Exception ex){	ex.printStackTrace();}
	}
	/** 
	 * 文件名:      	  doPost
	 * 描    述：    对教师录入的考试成绩进行处理（“暂存”或者“提交”）
	 */ 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		String operate = request.getParameter("submit");//教师所选操作：“暂存”或者“提交”
	   	String[] stunos = request.getParameterValues("stuno");//选修该门课程的所有学生的学号
	   	String[] coursenos = request.getParameterValues("courseno");//该门课程的课程号
	  	String[] scores = request.getParameterValues("score");//教师录入的分数
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
		   		 	 request.setAttribute("msg6", "分数录入成功！");
		   		 }catch(Exception ex){	ex.printStackTrace();}
		   	  }
		   }
		}
	   	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/teacher/tea_entryscore2.jsp");
		dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
	}
}
