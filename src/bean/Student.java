package bean;

public class Student {
	private int sid;
	private String name;
	private String sex;
	private String username;
	private String school;
	private String department;
	private String major;
	private String myclass;
	private int score;
	public Student() {
		
	}
	public Student(int sid, String name,String sex, String username, String school, String department, String major,
			String myclass, int score) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.username = username;
		this.school = school;
		this.department = department;
		this.major = major;
		this.myclass = myclass;
		this.score = score;
	}
	public Student(int sid, String name,String sex, String school, String department, String major, String myclass, int score) {
		super();
		this.sid = sid;
		this.name = name;
		this.sex = sex;
		this.school = school;
		this.department = department;
		this.major = major;
		this.myclass = myclass;
		this.score = score;
	}
	public Student(String name, String sex, String username,String myclass,int score) {
		super();
		this.name = name;
		this.sex = sex;
		this.username = username;
		this.myclass = myclass;
		this.score = score;
	}
	public Student(String name, String sex, String username, String school, String department, String major,
			String myclass) {
		super();
		this.name = name;
		this.sex = sex;
		this.username = username;
		this.school = school;
		this.department = department;
		this.major = major;
		this.myclass = myclass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMyclass() {
		return myclass;
	}
	public void setMyclass(String myclass) {
		this.myclass = myclass;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}	
