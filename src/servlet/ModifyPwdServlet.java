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
 * 文件名:       ModifyPwdServlet.java 
 * 描    述：    对修改密码进行处理
 */ 
public class ModifyPwdServlet extends HttpServlet {
	/** 
	 * FunName:           doPost 
	 * Description :      对修改密码进行处理
	 * @param：			  HttpServletRequest request, HttpServletResponse response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getSession().getAttribute("type").toString();
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		
		/*1.信息填写要完整*/
		if(oldPassword.equals("") || newPassword1.equals("") || newPassword2.equals("")){
			request.setAttribute("msg9", "请将信息填写完整");
		}
		/*2.新密码和密码确认要一致*/
		else if(!newPassword1.equals(newPassword2)){
			request.setAttribute("msg9", "密码确认不一致");
		}
		/*3.旧密码填写要正确*/
		else{
			if(type.equals("学生")){
				Student stu = (Student)request.getSession().getAttribute("student");
				if(!oldPassword.equals(stu.getPassword())){
					request.setAttribute("msg9", "请输入正确的旧密码");
				}
				else{
					StudentDao sdao = new StudentDao();
					stu.setPassword(newPassword1);
					try{
						sdao.updateStudent(stu);
					}catch(Exception ex){	ex.printStackTrace();}
					request.setAttribute("okMsg9", "密码修改成功！ （为了保证您的帐号安全，建议重新登录！！）");
				}
			}
			else if(type.equals("教师")){
				Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
				if(!oldPassword.equals(tea.getPassword())){
					request.setAttribute("msg9", "请输入正确的旧密码");
				}
				else{
					TeacherDao tdao = new TeacherDao();
					tea.setPassword(newPassword1);
					try{
						tdao.updateTeacher(tea);
					}catch(Exception ex){	ex.printStackTrace();}
					request.setAttribute("okMsg9", "密码修改成功！ （为了保证您的帐号安全，建议重新登录！！）");
				}	
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/modifyPwd.jsp");
		dispatcher.forward(request, response);//内部跳转
	}
}
