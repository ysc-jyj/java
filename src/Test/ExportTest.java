package Test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;

import org.junit.Test;

import Dao.AccountsDao;
import Dao.DBConnection;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportTest.
 * 	测试导出收支表功能
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class ExportTest {
	
	/** The driver name. */
	String driverName = "com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri = "jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The adao. */
	AccountsDao adao = new AccountsDao(driverName, uri);
	
	/** The rs. */
	private ResultSet rs;
	
	/**
	 * Prints 导出
	 */
	@Test
	public void print() {
		String user = "孙悟空";
		WritableWorkbook workBook = null;
		try {
			File file = new File("E://课程有关//Java相关//课程设计Test.xls");
			workBook = Workbook.createWorkbook(file);
			WritableSheet sheet = workBook.createSheet("收支信息", 0);
			String sql = "select pdate as 日期,payments as 收支,type as 类别,way as 支付方式,"
					+ "money as 金额（元）,remarks as 备注 from payment where username='" + user + "' order by pdate,payments,type";
			rs = adao.queryPay(sql);
			ResultSetMetaData rsmd = rs.getMetaData();// 获取关于 ResultSet 对象中列的类型和属性信息的对象
			int colCount = rs.getMetaData().getColumnCount();
			List<ArrayList<String>> data = new ArrayList<>();
			int rowCount = 0;
			while (rs.next()) {
				rowCount++;
				ArrayList<String> rowdata = new ArrayList<>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			for (int j = 0; j < data.size(); j++) {
				sheet.addCell(new Label(0, j, data.get(j).get(0)));
				sheet.addCell(new Label(1, j, data.get(j).get(1)));
				sheet.addCell(new Label(2, j, data.get(j).get(2)));
				sheet.addCell(new Label(3, j, data.get(j).get(3)));
				sheet.addCell(new Label(4, j, data.get(j).get(4)));
				sheet.addCell(new Label(5, j, data.get(j).get(5)));
			}
			workBook.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				workBook.close();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
