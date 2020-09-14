package dao;

import bean.Student;

public interface IStudentDao {
	/**
	 * 展示学生信息
	 * @param username
	 * @return Student：学生信息
	 */
	public Student stuShow(String username);
	/**
	 * 修改班级
	 * @param username
	 * @return int:影像记录行数
	 */
	public int changeClass(String username,String classname);
	/**
	 * 增加学生
	 * @param student
	 * @return int:影响记录条数
	 */
	public int insertStudent(Student student);
	/**
	 * 移除学生
	 * @param username
	 * @return
	 */
	public int removeClass(String username);
	/**
	 * 学生评分
	 * @param username
	 * @param score
	 * @return int:影响记录条数
	 */
	public int putScore(String username,int score);
	/**
	 * 删除学生
	 * @param username
	 * @return int:影响记录条数
	 */
	public int removeStudent(String username);
}
