package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.data.category.DefaultCategoryDataset;

import vo.Course;
import vo.Student;
import vo.Teacher;

import dao.CourseDao;
import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;
/** 
 * 文件名:       Tea_QueryScore1Servlet.java 
 * 描    述：    教师查看其开设的所有课程的基本信息，以便选择某门课程查看“成绩分布”
 */ 
public class Tea_QueryScore1Servlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      教师点击“成绩分布”菜单，系统获取该教师开设的所有课程的基本信息并跳转到新页面显示
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
		CourseDao cdao = new CourseDao();
		
		try{
			ArrayList courses = cdao.getCourseByTeano(tea.getTeano());
			if(courses.size()!=0){
				request.setAttribute("courses",courses);
			}
			request.getRequestDispatcher("/jsp/teacher/tea_queryscore1.jsp").forward(request, response);//内部跳转
		}catch(Exception ex){	ex.printStackTrace();}
		
	}
}

