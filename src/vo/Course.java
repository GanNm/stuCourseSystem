package vo;

public class Course {
	
	private String courseno;//�γ̺�
	private String coursename;//�γ�����
	private float credit;//�γ�ѧ��
	private String teano;//�ڿν�ʦְ����
	private String teaname;//�ڿν�ʦ����
	
	/*����������Ӧ��getter��setter����*/
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}
	public String getCourseno() {
		return courseno;
	}
	public void setCourseno(String courseno) {
		this.courseno = courseno;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getTeano() {
		return teano;
	}
	public void setTeano(String teano) {
		this.teano = teano;
	}
	
	
}
