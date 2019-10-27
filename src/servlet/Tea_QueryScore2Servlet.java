package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;

import vo.Course;
import vo.ScoreSection;
import vo.Student;
import vo.Teacher;

import dao.CourseDao;
import dao.ScoreDao;
import dao.StudentDao;
import dao.TeacherDao;
/** 
 * �ļ���:       Tea_QueryScore2Servlet.java 
 * ��    ����    ��ʦѡ��ĳ�ſγ̡�¼��ɼ���
 */ 
public class Tea_QueryScore2Servlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      ��ʦѡ��ĳ�ſγ̣�������ġ��ɼ��ֲ������ӣ�ϵͳ��ȡ���ſγ̵ĳɼ��ֲ���������ͳ��ͼ����ʽ��ʾ
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher"); 
		String courseno = request.getParameter("courseno");//��ѡ�γ̵Ŀγ̺�
		String coursename = null;
  		ScoreDao sdao = new ScoreDao();		
  		
		try{
			ArrayList scoresection = sdao.getScoreSectionByCourseno(courseno);//��ȡ���ſγ̵ĳɼ��ֲ�
			if(scoresection.size()==0){
				request.setAttribute("msg8", "�Բ���,����ѧ��ѡ�޸��ſγ̣�");
			}
			else{
				request.setAttribute("msg8", null);
				/*������ͳ��ͼ����ʽ��ʾ�ɼ��ֲ�*/
		    	DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		    	for(int i=0;i<scoresection.size();i++){
		    		ScoreSection ss = (ScoreSection)scoresection.get(i);
		    		dcd.addValue(ss.getNumber(),ss.getSection(),ss.getSection());//����1�Ǳ�ʾ���ݣ�����2��ʾ����(����)������3��ʾ����
		    		coursename = ss.getCoursename();
		    	}
		    	JFreeChart chart = ChartFactory.createBarChart3D(coursename+"�ɼ��ֲ�","������","����",
		    							dcd,PlotOrientation.VERTICAL,true,false,false);//��Chart��ʾ����
		    	String filename = ServletUtilities.saveChartAsJPEG(chart,1000,300,request.getSession());//��chart����ΪͼƬ�ļ�
		    	String chartUri = "/EduSystem/DisplayChart?filename="+filename;
		    	request.setAttribute("chartUri", chartUri);
			}
			request.getRequestDispatcher("/jsp/teacher/tea_queryscore2.jsp").forward(request, response);//�ڲ���ת
		}catch(Exception ex){	ex.printStackTrace();}
		
	}
}
