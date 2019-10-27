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
 * �ļ���:       LoginServlet.java 
 * ��    ����    �Ե�¼���д���
 */ 
public class LoginServlet extends HttpServlet {
	/** 
	 * FunName:           doPost 
	 * Description :      ��POST��ʽ��login.jsp�еı��ύ��servlet�����е�¼�Ĵ���
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String code = request.getParameter("code");//��֤��
		String account = request.getParameter("account");//�ʺ�
		String password = request.getParameter("password");//����
    	String type = request.getParameter("type"); //��ݣ���ʦ����ѧ����
    	
    	/*1.��֤������Ҫ��ȷ*/
		if(code.equals(request.getSession().getAttribute("code"))){
			/*2.�ʺ����벻��Ϊ��*/
			if(account!=null && !account.equals("")){
				/*3.1 ѧ����¼*/
				if(type.equals("student")){ 
					StudentDao sdao = new StudentDao();
					type = "ѧ��";
					try{
						Student stu = sdao.getStudentByStuno(account);
						//��֤ѧ����¼��Ϣ
						if(stu==null || !stu.getPassword().equals(password)){
							request.setAttribute("msg1", "�ʺŻ�������������,��¼ʧ�ܣ�");
							RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
							dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
						}
						else{	
							request.getSession().setAttribute("student",stu);
							request.getSession().setAttribute("type",type);
							response.sendRedirect("/EduSystem/jsp/student/stu_ope.jsp");
						}
					}catch(Exception ex){	ex.printStackTrace();}
				}
				/*3.2 ��ʦ��¼*/
				else if(type.equals("teacher")){ 
					TeacherDao tdao = new TeacherDao();
					type = "��ʦ";
					try{
						Teacher tea = tdao.getTeacherByTeano(account);
						//��֤��ʦ��¼��Ϣ
						if(tea==null || !tea.getPassword().equals(password)){
							request.setAttribute("msg1", "�ʺŻ�������������,��¼ʧ�ܣ�");
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
		/*4.��֤�������*/
		else{
			request.setAttribute("msg1", "��֤���������,��¼ʧ��!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response); 
		}
	}

}
