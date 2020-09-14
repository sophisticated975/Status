package bean;

import java.util.List;

public class MyClass {
	private int cid;
	private String classname;
	private int number;
	private int tid;
	private List<Student> list;
	public MyClass() {
		
	}
	public MyClass(int cid, String classname, int number, int tid, List<Student> list) {
		super();
		this.cid = cid;
		this.classname = classname;
		this.number = number;
		this.tid = tid;
		this.list = list;
	}
	public MyClass(String classname, int number, int tid, List<Student> list) {
		super();
		this.classname = classname;
		this.number = number;
		this.tid = tid;
		this.list = list;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	
}
