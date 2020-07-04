package 课程设计;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.*;
import Dao.AccountsDao;
import Dao.DBConnection;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

// TODO: Auto-generated Javadoc
/**
 * The Class Export.
 *	导出收支
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class Export {
	
	/** The driver name. */
	String driverName = "com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri = "jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The conn. */
	Connection conn=null;
	
	/** The pstmt. */
	private PreparedStatement pstmt=null;
	
	/** The stmt. */
	private Statement stmt=null;
	
	/** The rs. */
	private ResultSet rs;
	
	/**
	 * Instantiates a new export.
	 * 
	 * @param user the user
	 * 	用户名
	 * 
	 */
	public Export(String user) {
		WritableWorkbook workBook=null;
		try {
			File file = new File("E://课程有关//Java相关//课程设计Test.xls");
			workBook=Workbook.createWorkbook(file);
			WritableSheet sheet=workBook.createSheet("收支信息", 0);
			String sql="select pdate as 日期,payments as 收支,type as 类别,way as 支付方式,"
					+ "money as 金额（元）,remarks as 备注 from payment where username='"+user+"'order by pdate,payments,type";
			conn=DBConnection.getConnection(driverName, uri);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
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
			sheet.addCell(new Label(0, 0, "日期"));
			sheet.addCell(new Label(1, 0, "收支"));
			sheet.addCell(new Label(2, 0, "类别"));
			sheet.addCell(new Label(3, 0, "支付方式"));
			sheet.addCell(new Label(4, 0, "金额（元）"));
			sheet.addCell(new Label(5, 0, "备注"));
			for (int j = 1; j <=data.size(); j++) {
				sheet.addCell(new Label(0, j, data.get(j-1).get(0)));
				sheet.addCell(new Label(1, j, data.get(j-1).get(1)));
				sheet.addCell(new Label(2, j, data.get(j-1).get(2)));
				sheet.addCell(new Label(3, j, data.get(j-1).get(3)));
				sheet.addCell(new Label(4, j, data.get(j-1).get(4)));
				sheet.addCell(new Label(5, j, data.get(j-1).get(5)));
			}
			workBook.write();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
