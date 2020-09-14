package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MyClass;
import bean.Student;
import dao.IClassDao;
import utils.DBConUtil;

public class IClassDaoImpl implements IClassDao {
	private static Connection conn = DBConUtil.getConn();
	@Override
	public MyClass showClass(int tid) {
		PreparedStatement pstmt = null;
		String sql = "select classname,number from class where tid=?;";
		ResultSet rs = null;
		MyClass myclass = null;
		boolean result = false;
		IClassDao iclassDao = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			rs = pstmt.executeQuery();
			result = rs.next();
			if(result) {
				String classname = rs.getString("classname");
				int number = rs.getInt("number");
				iclassDao = new IClassDaoImpl();
				List<Student> list = iclassDao.getStudent(classname);
				myclass = new MyClass(classname,number,tid,list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return myclass;
	}
	@Override
	public List<Student> getStudent(String classname) {
		PreparedStatement pstmt = null;
		String sql = "select name,sex,username,score from student where class=?;";
		ResultSet rs = null;
		List<Student> list = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classname);
			rs = pstmt.executeQuery();
			list = new ArrayList<Student>();
			while(rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String username = rs.getString("username");
				int score = rs.getInt("score");
				Student student = new Student(name,sex,username,classname,score);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return list;
	}
	@Override
	public int addStudent(String classname) {
		PreparedStatement pstmt = null;
		String sql = "update class set number=number+1 where classname=?;";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,classname);
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
	public int isExist(String classname) {
		PreparedStatement pstmt = null;
		String sql = "select cid from class where classname=?;";
		ResultSet rs = null;
		int cid = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cid = rs.getInt("cid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return cid;
	}
	@Override
	public int addClass(String classname,int tid) {
		PreparedStatement pstmt = null;
		String sql = "insert into class(classname,tid) values(?,?);";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classname);
			pstmt.setInt(2, tid);
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
	public int removeStudent(String classname) {
		PreparedStatement pstmt = null;
		String sql = "update class set number=number-1 where classname=?;";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,classname);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return 0;
	}
	@Override
	public int seeTid(String classname) {
		PreparedStatement pstmt = null;
		String sql = "select tid from class where classname=?;";
		ResultSet rs = null;
		int tid = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classname);
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
	public int changeTid(String classname, int tid) {
		PreparedStatement pstmt = null;
		String sql = "update class set tid =? where classname=?;";
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			pstmt.setString(2, classname);
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
