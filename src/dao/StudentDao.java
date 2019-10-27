package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vo.Student;
/** 
 * �ļ���:       StudentDao.java 
 * ��    ����    �����ݿ��й���ѧ������Ϣ���д���
 */ 
public class StudentDao {
	private Connection conn = null;
	/** 
	 * FunName:           initConnection 
	 * Description :      ʵ�����ݿ�ĳ�ʼ������
	 */
	public void initConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
	}
	/** 
	 * FunName:           getStudentByStuno 
	 * Description :      ����ѧ�Ż�ȡ��Ӧ��ѧ����Ϣ
	 */
	public Student getStudentByStuno(String stuno) throws Exception{//ͨ��ѧ�Ż��ѧ����Ϣ
		Student stu = null;//attention��
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
	 * Description :      ����ѧ����Ϣ�����ݿ�
	 */
	public void updateStudent(Student stu) throws Exception{//�޸�ѧ����Ϣ
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
     * Description :      �ر����ݿ������
     */
	public void closeConnection() throws Exception{
		conn.close();
	}
	
}
