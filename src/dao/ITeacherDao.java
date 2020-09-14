package dao;

import java.util.List;

import bean.Teacher;

public interface ITeacherDao {
	/**
	 * 展示老师信息
	 * @param username
	 * @return Teacher:老师信息
	 */
	public Teacher teaShow(String username);
	/**
	 * 得到所有老师信息
	 * @return List<teacher>:所有老师信息
	 */
	public List<Teacher> getAllTeacher();
	/**
	 * 添加教师
	 * @param teacher
	 * @return int:影响记录条数
	 */
	public int addTeacher(Teacher teacher);
	/**
	 * 教师是否存在
	 * @param username
	 * @return int:教师id
	 */
	public int isExist(String username);
	/**
	 * 老师带班
	 * @param username
	 * @param calssname
	 * @return int:影响记录条数
	 */
	public int changeClass(String username,String classname);
	/**
	 * 得到教师username
	 * @param tid
	 * @return String:username
	 */
	public String seeUsername(int tid);
	/**
	 * 删除老师
	 * @param username
	 * @return int:影响记录条数
	 */
	public int removeTeacher(String username);
}
