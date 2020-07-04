package Dao;
import java.sql.*;
    // TODO: Auto-generated Javadoc

    /**
     * The Class UserDao.
     *	用户账号密码的数据库
     * @date 2020-7-3
     * @author 焦易璟
     * @version  v1.0
     */  
public class UserDao {
	
	/** The pstmt. */
	private PreparedStatement pstmt;
	
	/** The stmt. */
	private Statement stmt;
	
	/** The rs. */
	private ResultSet rs;
	
	/** The conn. */
	private Connection conn=null;
	
	/**
	 * Instantiates a new user dao.
	 *
	 * @param driverName the driver name 
	 * @param uri the uri
	 */
	public UserDao(String driverName,String uri){
		conn=DBConnection.getConnection(driverName, uri);
	}
	    
    	/**
    	 * Save user.
    	 *	保存用户账户密码
    	 * @param sql the sql SQL语句
    	 * @param username the username 用户名
    	 * @param password the password 密码
    	 */  
	public void saveUser(String sql,String username,String password) {
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	    
    	/**
    	 * Query user. 
    	 *	 查询用户的账号密码
    	 * @param sql the sql 查询语句
    	 * @return the result set 结果集
    	 */    
	public ResultSet queryUser(String sql) {
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return rs;
		}	
	}
	
	/**
	 * Close all. 关闭数据库连接
	 */
	public void closeAll() {
		if(!(rs==null)) {
			try {
				rs.close();
				pstmt.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
