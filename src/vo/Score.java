package vo;

public class Score {
	
	private String stuno;//ѧ��
	private String stuname;//����
	private String courseno;//�γ̺�
	private String coursename;//�γ�����
	private String type;//�������ͣ������С����ߡ���ĩ����
	private float score;//����
	private String state;//״̬����ʦ����ѡ���ݴ桱���ߡ��ύ��¼��ĳɼ�����ͬ�Ĳ�����Ӧ��ͬ��״̬��
	
	/*����������Ӧ��getter��setter����*/
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
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
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
