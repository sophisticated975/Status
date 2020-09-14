package services;

import bean.Student;

public interface IStudentServices {
	/**
	 * 学生信息展示
	 * @param username
	 * @return	Student:学生信息
	 */
	public Student stuShow(String username);
	/**
	 * 学生是否存在
	 * @param username
	 * @return true:存在
	 */
	public boolean isExist(String username);
	/**
	 * 展示学生班级
	 * @param username
	 * @return String:班级
	 */
	public String showClass(String username);
	/**
	 * 修改学生班级
	 * @param username
	 * @return true:success
	 */
	public boolean changeClass(String username,String classname);
	/**
	 * 插入学生
	 * @param student
	 * @return true:success
	 */
	public boolean insertStudent(Student student);
	/**
	 * 删除学生
	 * @param username
	 * @return true:success
	 */
	public boolean removeClass(String username);
	/**
	 * 学生评分
	 * @param username
	 * @param socre
	 * @return true:success
	 */
	public boolean putScore(String username,int socre);
	/**
	 * 删除学生
	 * @param username
	 * @return true:success
	 */
	public boolean removeStudent(String username);
}
