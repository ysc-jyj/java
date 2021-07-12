package Dao;
import java.sql.*;
// TODO: Auto-generated Javadoc

/**
 * The Class AccountsDao.
 * 账目数据库
 * @date 2020-7-3
 * @author 焦易璟
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
    	 * Save. 保存数据
    	 *
    	 * @param sql the sql SQL语句
    	 * @param userName the user name 用户名
    	 * @param payments the payments 收/支
    	 * @param type the type 类型
    	 * @param way the way 支付方式
    	 * @param money the money 金额
    	 * @param date the date 日期
    	 * @param remarks the remarks 备注
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
	 * Save total. 存储结余情况
	 *
	 * @param sql the sql SQL语句
	 * @param userName the user name 用户名
	 * @param tatolPay the tatol pay 总支出
	 * @param totalIncome the total income 总收入
	 * @param balance the balance 总结余
	 * @param time the time 日期
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
    	 * Query pay. 查询支出
    	 *
    	 * @param sql the sql SQL语句
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
    	 * Delete.删除数据
    	 *
    	 * @param sql the sql SQL语句
    	 */ 
	public void delete(String sql) {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Close all.关闭数据库连接
	 */

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