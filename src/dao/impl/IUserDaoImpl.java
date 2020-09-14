package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;
import dao.IUserDao;
import utils.DBConUtil;

public class IUserDaoImpl implements IUserDao {
	private static Connection conn = DBConUtil.getConn();
	@Override
	public String login(User user) {
		PreparedStatement pstmt = null;
		String sql = "select identity from user where username=? and password=?;";
		ResultSet rs = null;
		boolean result = false;
		String identity = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			result = rs.next();
			if(result) {
				identity = rs.getString("identity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return identity;
	}
	@Override
	public int modify(User user) {
		PreparedStatement pstmt = null;
		String sql = "update user set password=? where username=?;";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getUsername());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return result;
	}
	@Override
	public int addUser(String username,String identity) {
		PreparedStatement pstmt = null;
		String sql = "insert into user(username,identity) values(?,?);";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, identity);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return result;
	}
	@Override
	public int removeUser(String username) {
		PreparedStatement pstmt = null;
		String sql = "delete from user where username=?";
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
	public String seeIdentity(String username) {
		PreparedStatement pstmt = null;
		String sql = "select identity from user where username=?";
		ResultSet rs = null;
		String identity = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				identity = rs.getString("identity");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConUtil.close(null, pstmt, null, null);
		}
		return identity;
	}
}
