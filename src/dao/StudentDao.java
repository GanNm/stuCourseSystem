package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Student;
/** 
 * 文件名:       StudentDao.java 
 * 描    述：    对数据库中关于学生的信息进行处理
 */ 
public class StudentDao {
	private Connection conn = null;
	/** 
	 * FunName:           initConnection 
	 * Description :      实现数据库的初始化连接
	 */
	public void initConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
	}
	/** 
	 * FunName:           getStudentByStuno 
	 * Description :      根据学号获取对应的学生信息
	 */
	public Student getStudentByStuno(String stuno) throws Exception{//通过学号获得学生信息
		Student stu = null;//attention！
		this.initConnection();
		Statement stat = conn.createStatement();
		String sql = "select * from t_student where stuno='"+stuno+"'";
		ResultSet rs = stat.executeQuery(sql);
		if(rs.next()){
			stu = new Student();
			stu.setStuno(stuno);
			stu.setPassword(rs.getString("stupwd").trim());
			stu.setStuname(rs.getString("stuname").trim());	
			stu.setStusex(rs.getString("stusex").trim());
		}
		this.closeConnection();
		return stu;		
	}
	/** 
	 * FunName:           updateStudent 
	 * Description :      更新学生信息到数据库
	 */
	public void updateStudent(Student stu) throws Exception{//修改学生信息
		this.initConnection();
		String sql = "update t_student set stupwd=? where stuno=?";
		PreparedStatement ps = conn.prepareStatement(sql);		
		ps.setString(1, stu.getPassword());
		ps.setString(2, stu.getStuno());
		ps.executeUpdate();
		this.closeConnection();
	}
	/** 
     * FunName:           closeConnection 
     * Description :      关闭数据库的连接
     */
	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
