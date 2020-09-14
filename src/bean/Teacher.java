package bean;

public class Teacher {
	private int tid;
	private String name;
	private String sex;
	private String username;
	private String school;
	private String department;
	private String major;
	private String myclass;
	private String course;
	public Teacher() {
		
	}
	public Teacher(int tid, String name,String sex, String username, String school, String department, String major,
			String myclass, String course) {
		super();
		this.tid = tid;
		this.name = name;
		this.sex = sex;
		this.username = username;
		this.school = school;
		this.department = department;
		this.major = major;
		this.myclass = myclass;
		this.course = course;
	}
	public Teacher(int tid, String name,String sex, String school, String department, String major, String myclass,
			String course) {
		super();
		this.tid = tid;
		this.name = name;
		this.sex = sex;
		this.school = school;
		this.department = department;
		this.major = major;
		this.myclass = myclass;
		this.course = course;
	}
	public Teacher(String name, String sex, String username, String school, String department, String major) {
		super();
		this.name = name;
		this.sex = sex;
		this.username = username;
		this.school = school;
		this.department = department;
		this.major = major;
	}
	public Teacher(String name, String sex, String username, String myclass) {
		super();
		this.name = name;
		this.sex = sex;
		this.username = username;
		this.myclass = myclass;
	}
	public Teacher(String name, String sex, String username) {
		super();
		this.name = name;
		this.sex = sex;
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
}
