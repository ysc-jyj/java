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
 * 	���Ե�����֧����
 * @date 2020-7-3
 * @author ���׭Z
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
	 * Prints ����
	 */
	@Test
	public void print() {
		String user = "�����";
		WritableWorkbook workBook = null;
		try {
			File file = new File("E://�γ��й�//Java���//�γ����Test.xls");
			workBook = Workbook.createWorkbook(file);
			WritableSheet sheet = workBook.createSheet("��֧��Ϣ", 0);
			String sql = "select pdate as ����,payments as ��֧,type as ���,way as ֧����ʽ,"
					+ "money as ��Ԫ��,remarks as ��ע from payment where username='" + user + "' order by pdate,payments,type";
			rs = adao.queryPay(sql);
			ResultSetMetaData rsmd = rs.getMetaData();// ��ȡ���� ResultSet �������е����ͺ�������Ϣ�Ķ���
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
