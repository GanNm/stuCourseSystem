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
 * 文件名:       LogoutServlet.java 
 * 描    述：    对退出登录进行处理
 */ 
public class LogoutServlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      点击"退出"菜单，用Get方式提交到该servlet，进行退出登录的处理
	 * @param：			  HttpServletRequest request, HttpServletResponse response
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		/*销毁所有session，跳转回登录界面*/
		response.setHeader("Cache-Control","no-cache");
		request.getSession().invalidate();
		response.sendRedirect("/EduSystem/index.jsp");
	}
	
}
