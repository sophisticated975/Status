package services.impl;

import bean.User;
import dao.IUserDao;
import dao.impl.IUserDaoImpl;
import services.IUserServices;

public class IUserServicesImpl implements IUserServices {
	private IUserDao iuserDao =  new IUserDaoImpl();
	@Override
	public String login(User user) {
		
		return iuserDao.login(user);
	}
	@Override
	public boolean modify(User user) {
		int i = iuserDao.modify(user);
		return i>0?true:false;
	}
	@Override
	public boolean addUser(String username, String identity) {
		int i = iuserDao.addUser(username, identity);
		return i>0?true:false;
	}
	@Override
	public boolean removeUser(String username,String identity) {
		int i = iuserDao.removeUser(username);
		return i>0?true:false;
	}
}
