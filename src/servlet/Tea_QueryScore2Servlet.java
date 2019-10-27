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
 * 文件名:       Tea_QueryScore2Servlet.java 
 * 描    述：    教师选择某门课程“录入成绩”
 */ 
public class Tea_QueryScore2Servlet extends HttpServlet {
	/** 
	 * FunName:           doGet 
	 * Description :      教师选择某门课程，点击其后的“成绩分布”链接，系统获取该门课程的成绩分布并以条形统计图的形式显示
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		Teacher tea = (Teacher)request.getSession().getAttribute("teacher"); 
		String courseno = request.getParameter("courseno");//所选课程的课程号
		String coursename = null;
  		ScoreDao sdao = new ScoreDao();		
  		
		try{
			ArrayList scoresection = sdao.getScoreSectionByCourseno(courseno);//获取该门课程的成绩分布
			if(scoresection.size()==0){
				request.setAttribute("msg8", "对不起,暂无学生选修该门课程！");
			}
			else{
				request.setAttribute("msg8", null);
				/*以条形统计图的形式显示成绩分布*/
		    	DefaultCategoryDataset dcd = new DefaultCategoryDataset();
		    	for(int i=0;i<scoresection.size();i++){
		    		ScoreSection ss = (ScoreSection)scoresection.get(i);
		    		dcd.addValue(ss.getNumber(),ss.getSection(),ss.getSection());//参数1是表示数据，参数2表示话题(行名)，参数3表示列名
		    		coursename = ss.getCoursename();
		    	}
		    	JFreeChart chart = ChartFactory.createBarChart3D(coursename+"成绩分布","分数段","人数",
		    							dcd,PlotOrientation.VERTICAL,true,false,false);//用Chart显示出来
		    	String filename = ServletUtilities.saveChartAsJPEG(chart,1000,300,request.getSession());//将chart保存为图片文件
		    	String chartUri = "/EduSystem/DisplayChart?filename="+filename;
		    	request.setAttribute("chartUri", chartUri);
			}
			request.getRequestDispatcher("/jsp/teacher/tea_queryscore2.jsp").forward(request, response);//内部跳转
		}catch(Exception ex){	ex.printStackTrace();}
		
	}
}
