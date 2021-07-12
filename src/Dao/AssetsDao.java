package Dao;
import java.sql.*;
// TODO: Auto-generated Javadoc

/**
 * The Class AssetsDao.
 * �ʲ����ݿ�
 * @date 2020-7-3
 * @author ���׭Z
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
	 * Save assets. �洢�û��ʲ�
	 *
	 * @param sql the sql SQL���
	 * @param username the username �û���
	 * @param card the card ���п�
	 * @param weChat the we chat ΢��
	 * @param alipay the alipay ֧����
	 * @param other the other ����
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
	 * Query. ��ѯ����
	 *
	 * @param sql the sql SQL���
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
	 * Close all.�ر����ݿ�����
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
