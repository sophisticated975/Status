package dao;

import java.util.List;

import bean.MyClass;
import bean.Student;

public interface IClassDao {
	/**
	 * 展示班级信息
	 * @param tid
	 * @return MyClass:班级信息
	 */
	public MyClass showClass(int tid);
	/**
	 * 得到班级学生信息
	 * @param classname
	 * @return List:班级学生信息
	 */
	public List<Student> getStudent(String classname);
	/**
	 * 为班级添加学生
	 * @param classname
	 * @return int:影响记录条数
	 */
	public int addStudent(String classname);
	/**
	 * 为班级删除学生
	 * @param classname
	 * @return int:影响记录条数
	 */
	public int removeStudent(String classname);
	/**
	 * 班级是否存在
	 * @param classname
	 * @return int:班级id
	 */
	public int isExist(String classname);
	/**
	 * 添加班级
	 * @param classname
	 * @return int:影响记录条数
	 */
	public int addClass(String classname,int tid);
	/**
	 * 得到班级tid
	 * @param classname
	 * @return int:tid
	 */
	public int seeTid(String classname);
	/**
	 * 改变班级tid
	 * @param clasname
	 * @param tid
	 * @return int:影像记录条数
	 */
	public int changeTid(String classname,int tid);
}
