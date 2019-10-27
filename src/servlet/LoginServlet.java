package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Student;
import vo.Teacher;

import dao.StudentDao;
import dao.TeacherDao;
/** 
 * 文件名:       LoginServlet.java 
 * 描    述：    对登录进行处理
 */ 
public class LoginServlet extends HttpServlet {
	/** 
	 * FunName:           doPost 
	 * Description :      用POST方式将login.jsp中的表单提交到servlet，进行登录的处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");//验证码
		String account = request.getParameter("account");//帐号
		String password = request.getParameter("password");//密码
    	String type = request.getParameter("type"); //身份（教师或者学生）
    	
    	/*1.验证码输入要正确*/
		if(code.equals(request.getSession().getAttribute("code"))){
			/*2.帐号输入不能为空*/
			if(account!=null && !account.equals("")){
				/*3.1 学生登录*/
				if(type.equals("student")){ 
					StudentDao sdao = new StudentDao();
					type = "学生";
					try{
						Student stu = sdao.getStudentByStuno(account);
						//验证学生登录信息
						if(stu==null || !stu.getPassword().equals(password)){
							request.setAttribute("msg1", "帐号或密码输入有误,登录失败！");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
							dispatcher.forward(request, response); //内部跳转，将处理信息存储在request中
						}
						else{	
							request.getSession().setAttribute("student",stu);
							request.getSession().setAttribute("type",type);
							response.sendRedirect("/EduSystem/jsp/student/stu_ope.jsp");
						}
					}catch(Exception ex){	ex.printStackTrace();}
				}
				/*3.2 教师登录*/
				else if(type.equals("teacher")){ 
					TeacherDao tdao = new TeacherDao();
					type = "教师";
					try{
						Teacher tea = tdao.getTeacherByTeano(account);
						//验证教师登录信息
						if(tea==null || !tea.getPassword().equals(password)){
							request.setAttribute("msg1", "帐号或密码输入有误,登录失败！");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
							dispatcher.forward(request, response); 
						}
						else{
							request.getSession().setAttribute("teacher",tea);
							request.getSession().setAttribute("type",type);
							response.sendRedirect("/EduSystem/jsp/teacher/tea_ope.jsp");
						}
					}catch(Exception ex){	ex.printStackTrace();}
				}
			}
		}
		/*4.验证码错误处理*/
		else{
			request.setAttribute("msg1", "验证码输入错误,登录失败!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response); 
		}
	}

}
