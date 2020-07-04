package Dao;
import java.sql.*;
// TODO: Auto-generated Javadoc

/**
 * The Class AccountsDao.
 *
 * @date 2020-7-3
 * @author ½¹Ò×­Z
 * @version  v1.0
 */
public class AccountsDao {
	
	/** The pstmt. */
	private PreparedStatement pstmt;
	
	/** The stmt. */
	private Statement stmt;
	
	/** The rs. */
	private ResultSet rs;
	
	/** The conn. */
	private Connection conn=null;
	
	/**
	 * Instantiates a new accounts dao.
	 *
	 * @param driverName the driver name
	 * @param uri the uri
	 */
	public AccountsDao(String driverName,String uri) {
		conn=DBConnection.getConnection(driverName, uri);
	}
	    
    	/**
    	 * Save.
    	 *
    	 * @param sql the sql
    	 * @param userName the user name
    	 * @param payments the payments
    	 * @param type the type
    	 * @param way the way
    	 * @param money the money
    	 * @param date the date
    	 * @param remarks the remarks
    	 */	    
	public void save(String sql,String userName,String payments,String type,String way,
			double money,String date,String remarks) {
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, payments);
			pstmt.setString(3, type);
			pstmt.setString(4, way);
			pstmt.setDouble(5, money);
			pstmt.setString(6, date);
			pstmt.setString(7, remarks);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Save total.
	 *
	 * @param sql the sql
	 * @param userName the user name
	 * @param tatolPay the tatol pay
	 * @param totalIncome the total income
	 * @param balance the balance
	 * @param time the time
	 */
	public void saveTotal(String sql,String userName,double tatolPay,
			double totalIncome,double balance,String time) {
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setDouble(2, tatolPay);
			pstmt.setDouble(3, totalIncome);
			pstmt.setDouble(4, balance);
			pstmt.setString(5, time);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	    /**
    	 * Query pay.
    	 *
    	 * @param sql the sql
    	 * @return the result set
    	 */
	    
	public ResultSet queryPay(String sql) {
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
    	 * Delete.
    	 *
    	 * @param sql the sql
    	 */ 
	public void delete(String sql) {
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Close all.
	 */
	/*public void update(String sql,String type,String way,double money,String remarks) {
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, type);
			pstmt.setString(2, way);
			pstmt.setDouble(3, money);
			pstmt.setString(4, remarks);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}*/
	public void closeAll() {
		try {
			if (!(rs == null)) {
				rs.close();
				pstmt.close();
				stmt.close();
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}