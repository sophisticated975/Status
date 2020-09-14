package services;

import java.util.List;

import bean.Teacher;

public interface ITeacherServices {
	/**
	 * 老师信息展示
	 * @param username
	 * @return Teacher:老师信息
	 */
	public Teacher teaShow(String username);
	/**
	 * 得到所有教师信息
	 * @return
	 */
	public List<Teacher> getAllTeacher();
	/**
	 * 增加教师
	 * @param teacher
	 * @return true:success
	 */
	public boolean addTeacher(Teacher teacher);
	/**
	 * 教师是否存在
	 * @param username
	 * @return true:exist
	 */
	public boolean isExist(String username);
	/**
	 * 改变教师班级
	 * @param classname
	 * @param username
	 * @return
	 */
	public boolean changeClass(String classname,String username);
	/**
	 * 得到教师tid
	 * @param username
	 * @return
	 */
	public int seeTid(String username);
	/**
	 * 得到教师username
	 * @param tid
	 * @return String:username
	 */
	public String seeUsername(int tid);
	/**
	 * 得到教师班级
	 * @param username
	 * @return
	 */
	public String seeClassname(String username);
	/**
	 * 删除老师
	 * @param username
	 * @return true:success
	 */
	public boolean removeTeacher(String username);
	
}
