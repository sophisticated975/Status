package services.impl;

import bean.MyClass;
import dao.IClassDao;
import dao.ITeacherDao;
import dao.impl.IClassDaoImpl;
import dao.impl.ITeacherDaoImpl;
import services.IClassServices;

public class IClassServicesImpl implements IClassServices {
	private IClassDao iclassDao = new IClassDaoImpl();
	private ITeacherDao iteacherDao = new ITeacherDaoImpl();
	@Override
	public MyClass showClass(int tid) {
		
		return iclassDao.showClass(tid);
	}
	@Override
	public boolean addStudent(String classname) {
		int i = iclassDao.addStudent(classname);
		return i>0?true:false;
	}
	@Override
	public boolean removeStudent(String classname) {
		int i = iclassDao.removeStudent(classname);
		return i>0?true:false;
	}
	@Override
	public boolean isExist(String classname) {
		int cid = iclassDao.isExist(classname);
		return cid>0?true:false;
	}
	@Override
	public boolean addClass(String classname, String username) {
		int tid = iteacherDao.isExist(username);
		int i = iclassDao.addClass(classname, tid);
		return i>0?true:false;
	}
	@Override
	public int seeCid(String classname) {
		
		return iclassDao.isExist(classname);
	}
	@Override
	public int seeTid(String classname) {
		
		return iclassDao.seeTid(classname);
	}
	@Override
	public boolean changeTid(String classname, int tid) {
		int i = iclassDao.changeTid(classname, tid);
		return i>0?true:false;
	}

}
