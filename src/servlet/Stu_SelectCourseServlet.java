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
 * 文件名:       Stu_SelectCourseServlet.java 
 * 描    述：    学生网上选修课程
 */ 
public class Stu_SelectCourseServlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      学生点击"网上选课"菜单，系统获取该生的选课情况。若学生未选课，则显示所有课程供学生进行选课；否则提示“已经选好课程了”
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
		ScoreDao sdao = new ScoreDao();
		
		try{
			ArrayList info = sdao.getScoreByStuno(stu.getStuno()); 
			if(info.size()!=0){
				request.setAttribute("msg2", "对不起,您已经选好课程了！");
			}
			else{
				CourseDao cdao = new CourseDao();
				/*若可以选课,从数据库获取所有课程,放入request中*/
				ArrayList allcourse = cdao.getAllCourse();
				for(int i=0;i<allcourse.size();i++){
					Course cou = (Course)allcourse.get(i);
				}
				request.setAttribute("allcourse",allcourse);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcourse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}catch(Exception ex){	ex.printStackTrace();}
	}
	/** 
	 * FunName:           doPost 
	 * Description :      对学生选课信息进行处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*为简化流程，该系统要求学生选课的总学分刚好满20则选课成功，系统自动向考试成绩表中添加记录；否则，选课失败，界面刷新后仍停留本页面*/
		Student stu = (Student)request.getSession().getAttribute("student");
		ScoreDao sdao = new ScoreDao();
		CourseDao cdao = new CourseDao();
		
		try{
			ArrayList al = cdao.getAllCoursename();//得到所有课程名称
			ArrayList selectedcourses = new ArrayList();
			float allxuefen = 0; 
			/*计算选取课程的总学分*/
			for(int i=0;i<al.size();i++){
				String coursename = (String)al.get(i);
				String courseno = request.getParameter(coursename);
				if(courseno!=null){
					Course cou1 = cdao.getCourseByCourseno(courseno);
					allxuefen += cou1.getCredit(); 
					selectedcourses.add(cou1);
				}	
			}
			/*总学分刚好满20时，选课成功，更新信息到数据库*/
			if(allxuefen==20){
				for(int i=0;i<selectedcourses.size();i++){
					Course cou2 = (Course)selectedcourses.get(i);
					Score sco = new Score();
					sco.setStuno(stu.getStuno());
					sco.setCourseno(cou2.getCourseno());
					sdao.insertScore(sco);
				}
				request.setAttribute("msg2", "选课成功！");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcourse.jsp");
			dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
		}catch(Exception ex){	ex.printStackTrace();}
	}
	
}
