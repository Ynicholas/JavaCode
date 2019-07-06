package cn.zyf;

public class Student {
	private String sname;
	private String sno;
	private String grade;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Student() {
	}
	public Student(String sname, String sno, String grade) {
		this.sname = sname;
		this.sno = sno;
		this.grade = grade;
	}

}
