package vo;

public class ScoreSection {
	
	private String courseno;//课程号
	private String coursename;//课程名称
	private String section;//分数段
	private int number;//分数段对应的学生人数
	
	/*各个变量对应的getter和setter方法*/
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
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
