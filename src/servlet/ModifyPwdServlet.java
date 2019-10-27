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
 * �ļ���:       ModifyPwdServlet.java 
 * ��    ����    ���޸�������д���
 */ 
public class ModifyPwdServlet extends HttpServlet {
	/** 
	 * FunName:           doPost 
	 * Description :      ���޸�������д���
	 * @param��			  HttpServletRequest request, HttpServletResponse response
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getSession().getAttribute("type").toString();
		String oldPassword = request.getParameter("oldPassword");
		String newPassword1 = request.getParameter("newPassword1");
		String newPassword2 = request.getParameter("newPassword2");
		
		/*1.��Ϣ��дҪ����*/
		if(oldPassword.equals("") || newPassword1.equals("") || newPassword2.equals("")){
			request.setAttribute("msg9", "�뽫��Ϣ��д����");
		}
		/*2.�����������ȷ��Ҫһ��*/
		else if(!newPassword1.equals(newPassword2)){
			request.setAttribute("msg9", "����ȷ�ϲ�һ��");
		}
		/*3.��������дҪ��ȷ*/
		else{
			if(type.equals("ѧ��")){
				Student stu = (Student)request.getSession().getAttribute("student");
				if(!oldPassword.equals(stu.getPassword())){
					request.setAttribute("msg9", "��������ȷ�ľ�����");
				}
				else{
					StudentDao sdao = new StudentDao();
					stu.setPassword(newPassword1);
					try{
						sdao.updateStudent(stu);
					}catch(Exception ex){	ex.printStackTrace();}
					request.setAttribute("okMsg9", "�����޸ĳɹ��� ��Ϊ�˱�֤�����ʺŰ�ȫ���������µ�¼������");
				}
			}
			else if(type.equals("��ʦ")){
				Teacher tea = (Teacher)request.getSession().getAttribute("teacher");
				if(!oldPassword.equals(tea.getPassword())){
					request.setAttribute("msg9", "��������ȷ�ľ�����");
				}
				else{
					TeacherDao tdao = new TeacherDao();
					tea.setPassword(newPassword1);
					try{
						tdao.updateTeacher(tea);
					}catch(Exception ex){	ex.printStackTrace();}
					request.setAttribute("okMsg9", "�����޸ĳɹ��� ��Ϊ�˱�֤�����ʺŰ�ȫ���������µ�¼������");
				}	
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/modifyPwd.jsp");
		dispatcher.forward(request, response);//�ڲ���ת
	}
}
