package Test;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import Dao.AccountsDao;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountsDaoTest.
 *
 * @date 2020-7-3
 * @author 焦易璟
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
	
	private Statement stmt;
	/**
	 * Test query.
	 */
	@Test
	public void testQuery() {
		String sql="select * from payment where username='孙悟空'";
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
		assertEquals(67,row);
	}
	
	/**
	 * Test delete.
	 */
	@Test
	public void testDelete() {
		String user="孙悟空";
		String payments="收入";
		String type="借入";
		String way="其他";
		double money=12.30;
		String pdate="2020-07-02";
		String remarks="";
		String sql = "delete from payment where username='" + user + "'and pdate='" + pdate + "'" + "and type='" + type
				+ "'and way='" + way + "'" + "and money= " + money + " and remarks='" + remarks + "'";
		String sql2="select * from payment where username='孙悟空'";
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
		assertEquals(67,row);//删除后的行数
	}
	
	/**
	 * Test save.
	 */
	@Test
	public void testSave() {
		String user="孙悟空";
		String payments="收入";
		String type="借入";
		String way="其他";
		double money=12.30;
		String pdate="2020-07-02";
		String remarks="";
		String sql = "insert into payment(username,payments,type,way,money,pdate,remarks) values(?,?,?,?,?,?,?)";
		String sql2="select * from payment where username='孙悟空'";
		adao.save(sql, user, payments, type, way, money, pdate, remarks);
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
		assertEquals(68,row);
	}
}
