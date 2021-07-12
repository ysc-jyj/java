package 课程设计;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import Dao.AccountsDao;
import Dao.DBConnection;

import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Sheet.
 * 报表
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class Sheet {
	
	/** The driver name. */
	String driverName = "com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri = "jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The conn. */
	Connection conn = DBConnection.getConnection(driverName, uri);
	
	/** The adao. */
	AccountsDao adao = new AccountsDao(driverName, uri);
	
	/** The pan south. */
	private JPanel pP, pI, pT, panSouth;
	
	/** The s pan 3. */
	private JScrollPane sPan1, sPan2, sPan3;
	
	/** The btn delete. */
	private JButton btnDelete[] = new JButton[3];
	
	/** The model. */
	private DefaultTableModel model[] = new DefaultTableModel[3];
	
	/** The table. */
	private JTable table[] = new JTable[3];
	
	/**
	 * Instantiates a new sheet.
	 *
	 * @param pP the p P 支出表容器
	 * @param pI the p I 收入表容器
	 * @param pT the p T 结余表容器
	 * @param user the user 用户名
	 */
	public Sheet(JPanel pP, JPanel pI, JPanel pT, String user) {
		model[0] = new DefaultTableModel();
		model[1] = new DefaultTableModel();
		model[2] = new DefaultTableModel();
		table[0] = new JTable(model[0]);
		table[0].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table[1] = new JTable(model[1]);
		table[1].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table[2] = new JTable(model[2]);
		table[2].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for (int i = 0; i < 3; i++) {
			btnDelete[i] = new JButton("删除");
		}
		sPan1 = new JScrollPane(table[0]);
		pP.setLayout(new BorderLayout());
		sPan1.updateUI();// 刷新表格
		paySheet(pP, user);
		sPan2 = new JScrollPane(table[1]);
		pI.setLayout(new BorderLayout());
		sPan2.updateUI();
		incomeSheet(pI, user);
		sPan3 = new JScrollPane(table[2]);
		pT.setLayout(new BorderLayout());
		sPan3.updateUI();
		totalSheet(pT, user);
	}

	/**
	 * Pay sheet. 显示支出表
	 *
	 * @param pP the p P 支出表容器
	 * @param user the user 用户名
	 */
	public void paySheet(JPanel pP, String user) {
		panSouth = new JPanel();
		panSouth.add(btnDelete[0]);
		pP.removeAll();
		pP.add(sPan1, BorderLayout.NORTH);
		pP.add(panSouth, BorderLayout.CENTER);
		pP.validate();
		show(user, "支出", 0);
		btnDelete[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete(user, 0);
			}
		});
	}

	/**
	 * Income sheet. 显示收入表
	 *
	 * @param pI the p I 收入表容器
	 * @param user the user 用户名
	 */
	public void incomeSheet(JPanel pI, String user) {
		panSouth = new JPanel();
		panSouth.add(btnDelete[1]);
		pI.removeAll();
		pI.add(sPan2, BorderLayout.NORTH);
		pI.add(panSouth, BorderLayout.CENTER);
		pI.validate();
		show(user, "收入", 1);
		btnDelete[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete(user, 1);
			}
		});
	}

	/**
	 * Total sheet. 显示结余表
	 *
	 * @param pT the p T 结余表容器
	 * @param user the user 用户名
	 */
	public void totalSheet(JPanel pT, String user) {
		pT.removeAll();
		pT.add(sPan3);
		pT.validate();
		showTotal(user, 2);
	}

	/**
	 * Show. 查询账目存到JTable
	 *
	 * @param user the user 用户名
	 * @param flag the flag 标记收支（收入/支出）
	 * @param j the j 数组参数
	 */
	public void show(String user, String flag, int j) {
		String sql = "select pdate as 日期,payments as 收支,type as 类别,way as 支付方式," 
				+ "money as 金额（元）,remarks as 备注 "
				+ "from payment where username='" + user + "' and payments='" + flag + "'";
		ResultSet rs = adao.queryPay(sql);
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rs.getMetaData().getColumnCount();
			Vector<String> title = new Vector<>();// 存放列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			Vector<Vector<String>> data = new Vector<>();
			int rowCount = 0;
			while (rs.next()) {
				rowCount++;
				Vector<String> rowdata = new Vector<>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
				model[j].setDataVector(null, title);
				model[j].setDataVector(data, title);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Show total. 查询结余存到JTable
	 *
	 * @param user the user 用户名
	 * @param j the j 数组参数
	 */
	public void showTotal(String user, int j) {
		String sql = "select Time as 日期,totalPay as 总支出,totalIncome as 总收入,balance as 结余" + " from total"
				+ " where username='" + user + "'";
		ResultSet rs = adao.queryPay(sql);
		try {
			ResultSetMetaData rsmd = rs.getMetaData();// 获取关于 ResultSet 对象中列的类型和属性信息的对象
			int colCount = rs.getMetaData().getColumnCount();
			Vector<String> title = new Vector<>();// 列名
			for (int i = 1; i <= colCount; i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			Vector<Vector<String>> data = new Vector<>();
			int rowCount = 0;
			while (rs.next()) {
				rowCount++;
				Vector<String> rowdata = new Vector<>();
				for (int i = 1; i <= colCount; i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
				model[j].setDataVector(null, title);
				model[j].setDataVector(data, title);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Delete. 删除选择的数据
	 *
	 * @param user the user 用户名
	 * @param i the i 数组参数
	 */
	public void delete(String user, int i) {
		int selectRow = table[i].getSelectedRow();
		String date = table[i].getValueAt(selectRow, 0).toString();
		String payments = table[i].getValueAt(selectRow, 1).toString();
		String type = table[i].getValueAt(selectRow, 2).toString();
		String way = table[i].getValueAt(selectRow, 3).toString();
		String money = table[i].getValueAt(selectRow, 4).toString();
		String remarks = table[i].getValueAt(selectRow, 5).toString();
		Double M = Double.parseDouble(money);
		if (selectRow != -1) {
			model[i].removeRow(selectRow);
		}
		String sql = "delete from payment where username='" + user + "'and pdate='" + date + "'" + "and type='" + type
				+ "'and way='" + way + "'" + "and money= " + M + " and remarks='" + remarks + "'";
		adao.delete(sql);
		showTotal(user,2);
	}

}
