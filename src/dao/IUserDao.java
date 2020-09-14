package dao;

import bean.User;

public interface IUserDao {
	/**
	 * 用户登录
	 * @param user
	 * @return String:用户身份
	 */
	public String login(User user);
	/**
	 * 修改密码
	 * @param user
	 * @return int:影像记录行数
	 */
	public int modify(User user);
	/**
	 * 添加用户
	 * @param username
	 * @return int:影响记录条数
	 */
	public int addUser(String username,String identity);
	/**
	 * 移除用户
	 * @param username
	 * @return
	 */
	public int removeUser(String username);
	/**
	 * 查看用户身份
	 * @param username
	 * @return String:用户身份
	 */
	public String seeIdentity(String username);
}
