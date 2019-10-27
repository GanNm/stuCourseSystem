package vo;

public class Teacher {
	
	private String teano;//职工号
	private String teaname;//姓名
	private String password;//密码
	private String teasex;//性别
	private String title;//职称
	
	/*各个变量对应的getter和setter方法*/
	public String getTeano() {
		return teano;
	}
	public void setTeano(String teano) {
		this.teano = teano;
	}
	public String getTeaname() {
		return teaname;
	}
	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTeasex() {
		return teasex;
	}
	public void setTeasex(String teasex) {
		this.teasex = teasex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
