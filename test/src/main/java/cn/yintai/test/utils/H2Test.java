package cn.yintai.test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class H2Test {
	public static boolean exTable(Connection conn,String table){
		String sql = "select * from ?";
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, table);
			rs = ps.executeQuery();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			try {
				if(rs != null){
				rs.close();
				}
				if(ps != null){
					ps.close();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static Connection getConnection(Connection conn){
		if(conn==null){
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				return conn;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return conn;
		}
	}
}
