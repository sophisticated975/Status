package services.impl;

import bean.Student;
import dao.IStudentDao;
import dao.impl.IStudentDaoImpl;
import services.IStudentServices;

public class IStudentServicesImpl implements IStudentServices {
	private IStudentDao istudentDao = new IStudentDaoImpl();
	@Override
	public Student stuShow(String username) {
		
		return istudentDao.stuShow(username);
	}
	@Override
	public boolean isExist(String username) {
		Student student = istudentDao.stuShow(username);
		return student == null ? false:true;
	}
	@Override
	public String showClass(String username) {
		Student student = istudentDao.stuShow(username);
		return student.getMyclass();
	}
	@Override
	public boolean changeClass(String username,String classname) {
		int i = istudentDao.changeClass(username, classname);
		return i>0?true:false;
	}
	@Override
	public boolean insertStudent(Student student) {
		int i = istudentDao.insertStudent(student);
		return i>0?true:false;
	}
	@Override
	public boolean removeClass(String username) {
		int i = istudentDao.removeClass(username);
		return i>0?true:false;
	}
	@Override
	public boolean putScore(String username, int score) {
		int i = istudentDao.putScore(username, score);
		return i>0?true:false;
	}
	@Override
	public boolean removeStudent(String username) {
		int i = istudentDao.removeStudent(username);
		return i>0?true:false;
	}
	
}
