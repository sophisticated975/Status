package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Teacher;
import dao.ITeacherDao;
import utils.DBConUtil;

public class ITeacherDaoImpl implements ITeacherDao {
	private static Connection conn = DBConUtil.getConn();
	@Override
	public Teacher teaShow(String username) {
		PreparedStatement pstmt = null;
		String sql = "select tid,name,sex,school,department,major,class,course from teacher where username=?;";
		ResultSet rs = null;
		Teacher teacher = null;
		boolean result = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			result = rs.next();
			if(result) {
				int tid = rs.getInt("tid");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String school = rs.getString("school");
				String department = rs.getString("department");
				String major = rs.getString("major");
				String myclass = rs.getString("class");
				String course = rs.getString("course");
				teacher = new Teacher(tid,name,sex,school,department,major,myclass,course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return teacher;
	}
	@Override
	public List<Teacher> getAllTeacher() {
		PreparedStatement pstmt = null;
		String sql = "select name,sex,username,class from teacher;";
		ResultSet rs = null;
		List<Teacher> tlist = new ArrayList<Teacher>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String username = rs.getString("username");
				String myclass = rs.getString("class");
				Teacher teacher = new Teacher(name,sex,username,myclass);
				tlist.add(teacher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return tlist;
	}
	@Override
	public int addTeacher(Teacher teacher) {
		PreparedStatement pstmt = null;
		String sql = "insert into teacher(name,sex,username,class) values(?,?,?,?);";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getName());
			pstmt.setString(2, teacher.getSex());
			pstmt.setString(3, teacher.getUsername());
			pstmt.setString(4, "空");
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
	public int isExist(String username) {
		PreparedStatement pstmt = null;
		String sql = "select tid from teacher where username=?;";
		ResultSet rs = null;
		int tid = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tid = rs.getInt("tid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return tid;
	}
	@Override
	public int changeClass(String username, String classname) {
		PreparedStatement pstmt = null;
		String sql = "update teacher set class=? where username=?;";
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
	public String seeUsername(int tid) {
		PreparedStatement pstmt = null;
		String sql = "select username from teacher where tid=?;";
		ResultSet rs = null;
		String username = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return username;
	}
	@Override
	public int removeTeacher(String username) {
		PreparedStatement pstmt = null;
		String sql = "delete from teacher where username=?;";
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
