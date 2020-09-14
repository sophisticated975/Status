package services;

import bean.User;

public interface IUserServices {
	/**
	 * 用户登录
	 * @param user
	 * @return String：用户身份
	 */
	public String login(User user);
	/**
	 * 修改密码
	 * @param user
	 * @return true：success
	 */
	public boolean modify(User user);
	/**
	 * 添加用户
	 * @param username
	 * @param identity
	 * @return true:success
	 */
	public boolean addUser(String username,String identity);
	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	public boolean removeUser(String username,String identity);
}
