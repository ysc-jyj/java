package Dao;
import java.sql.*;
// TODO: Auto-generated Javadoc

/**
 * The Class AssetsDao.
 * 资产数据库
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class AssetsDao {
	
	/** The pstmt. */
	private PreparedStatement pstmt;
	
	/** The stmt. */
	private Statement stmt;
	
	/** The conn. */
	private Connection conn=null;
	
	/** The rs. */
	private ResultSet rs;
	
	/**
	 * Instantiates a new assets dao.
	 *
	 * @param driverName the driver name
	 * @param uri the uri
	 */
	public AssetsDao(String driverName,String uri) {
		conn=DBConnection.getConnection(driverName, uri);
	}
	
	/**
	 * Save assets. 存储用户资产
	 *
	 * @param sql the sql SQL语句
	 * @param username the username 用户名
	 * @param card the card 银行卡
	 * @param weChat the we chat 微信
	 * @param alipay the alipay 支付宝
	 * @param other the other 其他
	 */
	public void saveAssets(String sql,String username,
			double card,double weChat,double alipay,double other) {
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setDouble(2, card);
			pstmt.setDouble(3, weChat);
			pstmt.setDouble(4,alipay);
			pstmt.setDouble(5, other);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Query. 查询数据
	 *
	 * @param sql the sql SQL语句
	 * @return the result set
	 */
	public ResultSet query(String sql) {
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
	 * Close all.关闭数据库连接
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
