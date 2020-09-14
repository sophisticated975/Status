package services.impl;

import java.util.List;

import bean.Teacher;
import dao.ITeacherDao;
import dao.impl.ITeacherDaoImpl;
import services.ITeacherServices;

public class ITeacherServicesImpl implements ITeacherServices {
	private ITeacherDao iteacherDao = new ITeacherDaoImpl();
	@Override
	public Teacher teaShow(String username) {
		
		return iteacherDao.teaShow(username);
	}
	@Override
	public List<Teacher> getAllTeacher() {
		
		return iteacherDao.getAllTeacher();
	}
	@Override
	public boolean addTeacher(Teacher teacher) {
		int i = iteacherDao.addTeacher(teacher);
		return i>0?true:false;
	}
	@Override
	public boolean isExist(String username) {
		int tid = iteacherDao.isExist(username);
		return tid != 0?true:false;
	}
	@Override
	public boolean changeClass(String classname, String username) {
		int i = iteacherDao.changeClass(username, classname);
		return i>0?true:false;
	}
	@Override
	public int seeTid(String username) {
		
		return iteacherDao.isExist(username);
	}
	@Override
	public String seeUsername(int tid) {
		
		return iteacherDao.seeUsername(tid);
	}
	@Override
	public String seeClassname(String username) {
		Teacher teacher = iteacherDao.teaShow(username);
		return teacher.getMyclass();
	}
	@Override
	public boolean removeTeacher(String username) {
		int i = iteacherDao.removeTeacher(username);
		return i>0?true:false;
	}

}
