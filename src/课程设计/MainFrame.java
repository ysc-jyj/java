package 课程设计;

import java.awt.*;
import javax.swing.*;

import Dao.AccountsDao;
import Dao.DBConnection;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class MainFrame.
 *	主界面
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class MainFrame {
	
	/** The frame. */
	private JFrame frame=new JFrame("记账本");;
	
	/** The tab. */
	private JTabbedPane tab;
	
	/** The pLeft. */
	/** The pRight. */
	/** The p1. */
	/** The p2. */
	/** The p3. */
	/** The pP. */
	/** The pI. */
	/** The pT. */
	private JPanel pLeft, pRight, p1, p2, p3, pP, pI, pT;
	
	/** The sp. */
	private JSplitPane sp;
	

	/**The btnBK.*/
	/**The btnSheet.*/
	/**The btnPersonal.*/
	/**The btnCalculator.*/
	/**The btnExport.*/
	/**The btnExit. */
	private JButton btnBK, btnSheet, btnPersonal, btnCalculator, btnExport, btnExit;
	
	/** The card. */
	CardLayout card = new CardLayout();
	
	/**
	 * Instantiates a new main frame.
	 *
	 * @param user the user 用户名
	 */
	public MainFrame(String user) {
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pLeft = new JPanel();
		pRight = new JPanel();
		tab = new JTabbedPane();
		p1 = new JPanel();
		p2 = new JPanel();
		p2.add(tab);
		pP = new JPanel();
		pI = new JPanel();
		pT = new JPanel();
		tab.add("总支出", pP);
		tab.add("总收入", pI);
		tab.add("总结余", pT);
		p3 = new JPanel();
		pLeft.setLayout(null);
		pRight.setLayout(card);
		btnBK = new JButton("记账");
		btnSheet = new JButton("报表");
		btnPersonal = new JButton("我的");
		btnCalculator = new JButton("计算器");
		btnExport = new JButton("导出收支");
		btnExit = new JButton("退出");
		btnBK.setBounds(50, 50, 100, 25);
		btnSheet.setBounds(50, 90, 100, 25);
		btnPersonal.setBounds(50, 130, 100, 25);
		btnCalculator.setBounds(50, 180, 100, 25);
		btnExport.setBounds(50, 220, 100, 25);
		btnExit.setBounds(50, 400, 100, 25);
		frame.setSize(800, 550);
		frame.setLocation(300, 300);
		pLeft.add(btnBK);
		pLeft.add(btnSheet);
		pLeft.add(btnPersonal);
		pLeft.add(btnCalculator);
		pLeft.add(btnExport);
		pLeft.add(btnExit);
		sp.setDividerSize(10);
		sp.setLeftComponent(pLeft);
		sp.setRightComponent(pRight);
		frame.add(sp);
		new Record(p1, user);
		pRight.add(p1, "1");
		btnBK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Record(p1, user);
				pRight.add(p1, "1");
				card.show(pRight, "1");
			}
			
		});
		btnSheet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sheet(pP, pI, pT, user);
				pRight.add(p2, "2");
				card.show(pRight, "2");
			}
		});
		btnPersonal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Personal(p3, user);
				pRight.add(p3, "3");
				card.show(pRight, "3");
			}
		});
		btnCalculator.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Calculator();
			}
		});
		btnExport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Export(user);
				JOptionPane.showMessageDialog(null, "成功导出到E://课程有关//Java相关//课程设计-收支表.xls！");
			}
		});
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int r = JOptionPane.showConfirmDialog(btnExit, "确定退出登录？", "确认", JOptionPane.YES_NO_OPTION);
				if (r == JOptionPane.YES_OPTION) {
					frame.setVisible(false);
					new Login().close();
				}
			}
		});
		frame.setResizable(false);
		frame.setVisible(true);
		sp.setEnabled(false);
		sp.setDividerLocation(200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
