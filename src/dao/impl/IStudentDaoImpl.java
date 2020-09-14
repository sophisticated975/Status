package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Student;
import dao.IStudentDao;
import utils.DBConUtil;

public class IStudentDaoImpl implements IStudentDao {
	private static Connection conn = DBConUtil.getConn();
	@Override
	public Student stuShow(String username) {
		PreparedStatement pstmt = null;
		String sql = "select sid,name,sex,school,department,major,class,score from student where username=?;";
		ResultSet rs = null;
		Student student = null;
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			result = rs.next();
			if(result) {
				int sid = rs.getInt("sid");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String school = rs.getString("school");
				String department = rs.getString("department");
				String major = rs.getString("major");
				String myclass = rs.getString("class");//class是关键字，这里换种写法
				int score = rs.getInt("score");
				student = new Student(sid,name,sex,school,department,major,myclass,score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return student;
	}
	@Override
	public int changeClass(String username,String classname) {
		PreparedStatement pstmt = null;
		String sql = "update student set class=? where username=?;";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classname);
			pstmt.setString(2, username);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return i;
	}
	@Override
	public int insertStudent(Student student) {
		PreparedStatement pstmt = null;
		String sql = "insert into student(name,sex,username,school,department,major,class) values(?,?,?,?,?,?,?);";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getSex());
			pstmt.setString(3, student.getUsername());
			pstmt.setString(4, student.getSchool());
			pstmt.setString(5, student.getDepartment());
			pstmt.setString(6, student.getMajor());
			pstmt.setString(7, student.getMyclass());
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return i;
	}
	@Override
	public int removeClass(String username) {
		PreparedStatement pstmt = null;
		String sql = "update student set class='空' where username=?;";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return i;
	}
	@Override
	public int putScore(String username, int score) {
		PreparedStatement pstmt = null;
		String sql = "update student set score=? where username=?;";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, score);
			pstmt.setString(2, username);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return i;
	}
	@Override
	public int removeStudent(String username) {
		PreparedStatement pstmt = null;
		String sql = "delete from student where username=?;";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return i;
	}
}
