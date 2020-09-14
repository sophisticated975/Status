package services;

import bean.MyClass;

public interface IClassServices {
	/**
	 * 展示班级信息
	 * @param tid
	 * @return MyClass:班级信息
	 */
	public MyClass showClass(int tid);
	/**
	 * 为班级添加学生
	 * @param classname
	 * @return true:success
	 */
	public boolean addStudent(String classname);
	/**
	 * 为班级删除学生
	 * @param classname
	 * @return true:success
	 */
	public boolean removeStudent(String classname);
	/**
	 * 班级是否存在
	 * @param classname
	 * @return true:exist
	 */
	public boolean isExist(String classname);
	/**
	 * 添加班级
	 * @param classname
	 * @param username
	 * @return true:success
	 */
	public boolean addClass(String classname,String username);
	/**
	 * 得到cid
	 * @param classname
	 * @return int:cid
	 */
	public int seeCid(String classname);
	/**
	 * 得到班级tid
	 * @param classname
	 * @return int:tid
	 */
	public int seeTid(String classname);
	/**
	 * 改变班级tid
	 * @param classname
	 * @param tid
	 * @return true:success
	 */
	public boolean changeTid(String classname,int tid);
}
