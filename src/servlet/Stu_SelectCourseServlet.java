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
 * �ļ���:       Stu_SelectCourseServlet.java 
 * ��    ����    ѧ������ѡ�޿γ�
 */ 
public class Stu_SelectCourseServlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      ѧ�����"����ѡ��"�˵���ϵͳ��ȡ������ѡ���������ѧ��δѡ�Σ�����ʾ���пγ̹�ѧ������ѡ�Σ�������ʾ���Ѿ�ѡ�ÿγ��ˡ�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Student stu = (Student)request.getSession().getAttribute("student");
		ScoreDao sdao = new ScoreDao();
		
		try{
			ArrayList info = sdao.getScoreByStuno(stu.getStuno()); 
			if(info.size()!=0){
				request.setAttribute("msg2", "�Բ���,���Ѿ�ѡ�ÿγ��ˣ�");
			}
			else{
				CourseDao cdao = new CourseDao();
				/*������ѡ��,�����ݿ��ȡ���пγ�,����request��*/
				ArrayList allcourse = cdao.getAllCourse();
				for(int i=0;i<allcourse.size();i++){
					Course cou = (Course)allcourse.get(i);
				}
				request.setAttribute("allcourse",allcourse);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcourse.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
	/** 
	 * FunName:           doPost 
	 * Description :      ��ѧ��ѡ����Ϣ���д���
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*Ϊ�����̣���ϵͳҪ��ѧ��ѡ�ε���ѧ�ָպ���20��ѡ�γɹ���ϵͳ�Զ����Գɼ�������Ӽ�¼������ѡ��ʧ�ܣ�����ˢ�º���ͣ����ҳ��*/
		Student stu = (Student)request.getSession().getAttribute("student");
		ScoreDao sdao = new ScoreDao();
		CourseDao cdao = new CourseDao();
		
		try{
			ArrayList al = cdao.getAllCoursename();//�õ����пγ�����
			ArrayList selectedcourses = new ArrayList();
			float allxuefen = 0; 
			/*����ѡȡ�γ̵���ѧ��*/
			for(int i=0;i<al.size();i++){
				String coursename = (String)al.get(i);
				String courseno = request.getParameter(coursename);
				if(courseno!=null){
					Course cou1 = cdao.getCourseByCourseno(courseno);
					allxuefen += cou1.getCredit(); 
					selectedcourses.add(cou1);
				}	
			}
			/*��ѧ�ָպ���20ʱ��ѡ�γɹ���������Ϣ�����ݿ�*/
			if(allxuefen==20){
				for(int i=0;i<selectedcourses.size();i++){
					Course cou2 = (Course)selectedcourses.get(i);
					Score sco = new Score();
					sco.setStuno(stu.getStuno());
					sco.setCourseno(cou2.getCourseno());
					sdao.insertScore(sco);
				}
				request.setAttribute("msg2", "ѡ�γɹ���");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/student/stu_selectcourse.jsp");
			dispatcher.forward(request, response); //�ڲ���ת����������Ϣ�洢��request��
		}catch(Exception ex){	ex.printStackTrace();}
	}
	
}
