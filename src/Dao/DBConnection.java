package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 *
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class DBConnection {
		
	    /**
    	 * Gets the connection.
    	 *	获得数据库凝结
    	 * @param driverName the driver name
    	 * @param uri the uri
    	 * @return the connection
    	 */  
	public static Connection getConnection(String driverName, String uri) {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(uri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return conn;
		}
	}
}

