package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConUtil {
	
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/status";
	private static final String USER = "root";
	private static final String PASSWORD = "123";
	private static final String DRIVERPATH = "com.mysql.jdbc.Driver";
	private static Connection conn = null;
	static {
		try {
			Class.forName(DRIVERPATH);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	/**
	 * 获取JDBC Connection对象
	 * @return
	 */
	public static Connection getConn() {
		synchronized(DBConUtil.class) {
			try {
				//如果conn==null或者对象已经被关闭
				if(null == conn || conn.isClosed()) {
					conn = DriverManager.getConnection(URL,USER,PASSWORD);
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}	
		}
		return conn;
	}
	/**
	 * 关闭JDBC相关对象，释放资源
	 * @param conn
	 * @param pstmt
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement pstmt,Statement stmt,ResultSet rs) {
		try {
			if(null != rs){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(null != stmt) {
					stmt.close();
		
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					if(null != pstmt) {
						pstmt.close();
		
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						if(null != conn) {
							conn.close();
			
						}
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}	
}
