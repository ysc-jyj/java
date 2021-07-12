package �γ����;

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
 * ����
 * @date 2020-7-3
 * @author ���׭Z
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
	 * @param pP the p P ֧��������
	 * @param pI the p I ���������
	 * @param pT the p T ���������
	 * @param user the user �û���
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
			btnDelete[i] = new JButton("ɾ��");
		}
		sPan1 = new JScrollPane(table[0]);
		pP.setLayout(new BorderLayout());
		sPan1.updateUI();// ˢ�±��
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
	 * Pay sheet. ��ʾ֧����
	 *
	 * @param pP the p P ֧��������
	 * @param user the user �û���
	 */
	public void paySheet(JPanel pP, String user) {
		panSouth = new JPanel();
		panSouth.add(btnDelete[0]);
		pP.removeAll();
		pP.add(sPan1, BorderLayout.NORTH);
		pP.add(panSouth, BorderLayout.CENTER);
		pP.validate();
		show(user, "֧��", 0);
		btnDelete[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete(user, 0);
			}
		});
	}

	/**
	 * Income sheet. ��ʾ�����
	 *
	 * @param pI the p I ���������
	 * @param user the user �û���
	 */
	public void incomeSheet(JPanel pI, String user) {
		panSouth = new JPanel();
		panSouth.add(btnDelete[1]);
		pI.removeAll();
		pI.add(sPan2, BorderLayout.NORTH);
		pI.add(panSouth, BorderLayout.CENTER);
		pI.validate();
		show(user, "����", 1);
		btnDelete[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				delete(user, 1);
			}
		});
	}

	/**
	 * Total sheet. ��ʾ�����
	 *
	 * @param pT the p T ���������
	 * @param user the user �û���
	 */
	public void totalSheet(JPanel pT, String user) {
		pT.removeAll();
		pT.add(sPan3);
		pT.validate();
		showTotal(user, 2);
	}

	/**
	 * Show. ��ѯ��Ŀ�浽JTable
	 *
	 * @param user the user �û���
	 * @param flag the flag �����֧������/֧����
	 * @param j the j �������
	 */
	public void show(String user, String flag, int j) {
		String sql = "select pdate as ����,payments as ��֧,type as ���,way as ֧����ʽ," 
				+ "money as ��Ԫ��,remarks as ��ע "
				+ "from payment where username='" + user + "' and payments='" + flag + "'";
		ResultSet rs = adao.queryPay(sql);
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rs.getMetaData().getColumnCount();
			Vector<String> title = new Vector<>();// �������
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
	 * Show total. ��ѯ����浽JTable
	 *
	 * @param user the user �û���
	 * @param j the j �������
	 */
	public void showTotal(String user, int j) {
		String sql = "select Time as ����,totalPay as ��֧��,totalIncome as ������,balance as ����" + " from total"
				+ " where username='" + user + "'";
		ResultSet rs = adao.queryPay(sql);
		try {
			ResultSetMetaData rsmd = rs.getMetaData();// ��ȡ���� ResultSet �������е����ͺ�������Ϣ�Ķ���
			int colCount = rs.getMetaData().getColumnCount();
			Vector<String> title = new Vector<>();// ����
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
	 * Delete. ɾ��ѡ�������
	 *
	 * @param user the user �û���
	 * @param i the i �������
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
