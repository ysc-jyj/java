package Test;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Dao.AccountsDao;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountsDaoTest.
 *
 * @date 2020-7-3
 * @author ���׭Z
 * @version  v1.0
 */
public class AccountsDaoTest {
	
	/** The driver name. */
	String driverName = "com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri = "jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The adao. */
	AccountsDao adao=new AccountsDao(driverName,uri);
	
	/** The rs. */
	ResultSet rs;
	
	/**
	 * Test query.
	 */
	@Test
	public void testQuery() {
		String sql="select * from payment where username='�����'";
		 rs=adao.queryPay(sql);
		int row=0;
		try {
			while(rs.next()) {
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(85,row);
	}
	
	/**
	 * Test delete.
	 */
	public void testDelete() {
		String sql="delete from payment "
				+ "where username='�����' and payments='����' and type='����' "
				+ "and money=12.3 and pdate='2020-07-02' and remark=''";
		String sql2="select * from payment where username='�����'";
		adao.delete(sql);
		rs=adao.queryPay(sql2);
		int row=0;
		try {
			while(rs.next()) {
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(84,row);//ɾ���������
	}
	
	/**
	 * Test save.
	 */
	public void testSave() {
		String sql="insert into payment "
				+ "set username='�����',payments='����',type='����' "
				+ ",money=12.3 ,pdate='2020-07-02',remark=''";
		String sql2="select * from payment where username='�����'";
		adao.delete(sql);
		rs=adao.queryPay(sql2);
		int row=0;
		try {
			while(rs.next()) {
				row++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(85,row);//ɾ���������
	}
}
