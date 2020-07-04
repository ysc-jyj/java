package Dao;
import java.sql.*;
    // TODO: Auto-generated Javadoc

    /**
     * The Class UserDao.
     *	�û��˺���������ݿ�
     * @date 2020-7-3
     * @author ���׭Z
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
    	 *	�����û��˻�����
    	 * @param sql the sql SQL���
    	 * @param username the username �û���
    	 * @param password the password ����
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
    	 *	 ��ѯ�û����˺�����
    	 * @param sql the sql ��ѯ���
    	 * @return the result set �����
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
	 * Close all. �ر����ݿ�����
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
