package �γ����;

import java.awt.*;
import javax.swing.*;

import Dao.AccountsDao;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

// TODO: Auto-generated Javadoc
/**
 * The Class Record.ʵ�ּ��˹���
 *
 * @date 2020-7-3
 * @author ���׭Z
 * @version  v1.0
 */
public class Record {
	
	/** The driver name. */
	String driverName = "com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri = "jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The adao. */
	AccountsDao adao=new AccountsDao(driverName,uri);
	
	/** The lblMoney.*/
	/** The lblPType.*/
	/** The lblIType.*/
	/** The lblWay.*/
	/** The lblDate. */

	private JLabel lblMoney, lblPType,lblIType, lblWay, lblDate;
	
	/** The txtMoney. */
	private JTextField txtMoney = new JTextField(20);
	
	/** The pay. */
	private JRadioButton pay = new JRadioButton("֧��");
	
	/** The income. */
	private JRadioButton income = new JRadioButton("����");
	
	/** The group. */
	private ButtonGroup group = new ButtonGroup();// ʵ�ֵ�ѡ
	
	/** The type1[]. */
	String type1[] = { "����", "��ͨ", "����", "ҽ��", "����", "ѧϰ", "����" ,"���"};
	
	/** The jcbPType. */
	private JComboBox jcbPType = new JComboBox(type1);
	
	/** The type2[]. */
	String type2[] = { "����", "���", "�����", "�˿�", "����"};
	
	/** The jcbIType. */
	private JComboBox jcbIType = new JComboBox(type2);
	
	/** The way. */
	String way[] = { "���п�", "΢��", "֧����", "����" };
	
	/** The jcbWay. */
	private JComboBox jcbWay = new JComboBox(way);
	
	/** The dateFormat. */
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/** The currentDate. */
	String currentDate = dateFormat.format(new Date());
	
	/** The lbl remarks. */
	private JLabel lblRemarks = new JLabel("��ע��");
	
	/** The txt remarks. */
	private JTextField txtRemarks = new JTextField(20);
	
	/** The btn record. */
	private JButton btnRecord = new JButton("��һ��");
	
	/**
	 * Instantiates a new record.
	 *
	 * @param p1 the p1 ��Ƭ���ֹ����һ������
	 * @param user the user �û���
	 */
	public Record(JPanel p1, String user) {
		p1.setLayout(null);
		lblDate = new JLabel("���ڣ�" + currentDate);
		lblDate.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblDate.setBounds(180, 30, 200, 50);
		p1.add(lblDate);
		pay.setBounds(200, 100, 70, 30);
		income.setBounds(300, 100, 70, 30);
		p1.add(pay);
		p1.add(income);
		group.add(pay);
		group.add(income);
		lblMoney = new JLabel("�����");
		lblMoney.setBounds(200, 150, 70, 30);
		txtMoney.setBounds(270, 150, 70, 30);
		p1.add(lblMoney);
		p1.add(txtMoney);
		lblPType = new JLabel("֧�����ͣ�");
		lblPType.setBounds(120, 200, 70, 30);
		jcbPType.setBounds(190, 200, 70, 30);
		p1.add(lblPType);
		p1.add(jcbPType);
		lblIType = new JLabel("�������ͣ�");
		lblIType.setBounds(290, 200, 70, 30);
		jcbIType.setBounds(360, 200, 70, 30);
		p1.add(lblIType);
		p1.add(jcbIType);
		lblWay = new JLabel("ѡ���˻���");
		lblWay.setBounds(200, 250, 70, 30);
		jcbWay.setBounds(270, 250, 70, 30);
		p1.add(lblWay);
		p1.add(jcbWay);
		lblRemarks.setBounds(180, 300, 70, 30);
		txtRemarks.setBounds(230, 300, 120, 30);
		p1.add(lblRemarks);
		p1.add(txtRemarks);
		btnRecord.setBounds(230, 350, 90, 30);
		p1.add(btnRecord);
		btnRecord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String flag = null;
				Enumeration<AbstractButton> radioBtns = group.getElements();
				while (radioBtns.hasMoreElements()) {// ���ѡ������
					AbstractButton btn = radioBtns.nextElement();
					if (btn.isSelected()) {
						flag = btn.getText();
						break;
					}
				}
				if (flag.equalsIgnoreCase("֧��")) {
					String sql = "insert into payment(username,payments,type,way,money,pdate,remarks) values(?,?,?,?,?,?,?)";
					String type = (String) jcbPType.getSelectedItem();
					String way = (String) jcbWay.getSelectedItem();
					double money = Double.valueOf(txtMoney.getText());
					String remarks = txtRemarks.getText();
					adao.save(sql, user, flag,type, way, money, currentDate, remarks);
					JOptionPane.showMessageDialog(null, "�ɹ�");
				}else if(flag.equalsIgnoreCase("����")) {
					String sql = "insert into payment(username,payments,type,way,money,pdate,remarks) values(?,?,?,?,?,?,?)";
					String type = (String) jcbIType.getSelectedItem();
					String way = (String) jcbWay.getSelectedItem();
					double money = Double.valueOf(txtMoney.getText());
					String remarks = txtRemarks.getText();
					adao.save(sql, user,flag, type, way, money, currentDate, remarks);
					JOptionPane.showMessageDialog(null, "�ɹ�");
				}
			}
			
		});
	}
}
