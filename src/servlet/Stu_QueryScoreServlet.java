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
 * 文件名:       Stu_QueryScoreServlet.java 
 * 描    述：    学生查看考试成绩
 */ 
public class Stu_QueryScoreServlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      学生查看考试成绩
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
  		ScoreDao sdao = new ScoreDao();
  		
  		try{
  			ArrayList score = sdao.getScoreByStuno(stu.getStuno());//获取该生的考试信息
  			if(score==null){
  				request.setAttribute("msg3", "对不起,您还没有选课！");
  			}
  			else{
				request.setAttribute("msg3", null);
  				request.setAttribute("score", score);
  			}
  			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_queryscore.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
  		}catch(Exception ex){	ex.printStackTrace();}
	}

}
