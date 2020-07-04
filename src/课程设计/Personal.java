package 课程设计;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import Dao.AssetsDao;
import Dao.DBConnection;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * The Class Personal.个人界面
 *   
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class Personal {
	
	/** The driver name. */
	String driverName = "com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri = "jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The conn. */
	Connection conn = DBConnection.getConnection(driverName, uri);
	
	/** The adao. */
	AssetsDao adao=new AssetsDao(driverName,uri);
	
	/** The pan.*/
	/** The pC.*/
	/** The pW.*/
	/** The pA.*/
	/** The pO. */
	
	private JPanel pan,pC,pW,pA,pO;
	

	/**  The lblUserName.*/
	/**  The lblCard.*/
	/**  The lblWechat.*/
	/**  The lblAlipay.*/
	/**  The lblOther.*/

	private JLabel lblUserName,lblCard,lblWechat,lblAlipay,lblOther;
	
	/**The cMoney.*/
	/**The wMoney.*/
	/**The aMoney.*/
	/**The oMoney.*/
	private JLabel cMoney,wMoney,aMoney,oMoney;
	
	/** The font. */
	Font font=new Font("微软雅黑",Font.BOLD,20);
	
	/**
	 * Instantiates a new personal.
	 *
	 * @param p3 the p3 卡片布局管理第三个界面
	 * @param user the user 用户名
	 */
	public Personal(JPanel p3,String user) {
		p3.setLayout(null);
		pan=new JPanel(null);
		pC=new JPanel(null);
		pW=new JPanel(null);
		pA=new JPanel(null);
		pO=new JPanel(null);
		lblUserName=new JLabel("用户："+user);
		lblCard=new JLabel("银行卡");
		lblCard.setFont(font);
		lblWechat=new JLabel("微信");
		lblWechat.setFont(font);
		lblAlipay=new JLabel("支付宝");
		lblAlipay.setFont(font);
		lblOther=new JLabel("其他");
		lblOther.setFont(font);
		pan.setBounds(45, 20, 480, 80);
		pan.setBackground(Color.WHITE);
		lblUserName.setBounds(25, 15, 250, 50);
		lblUserName.setFont(new Font("罗西钢笔行楷",Font.PLAIN,20));
		pan.add(lblUserName);
		pC.setBounds(50, 120, 220, 150);
		pC.add(lblCard);
		pC.setBackground(Color.white);
		lblCard.setBounds(20, 20, 80, 50);
		pW.setBounds(300, 120, 220, 150);
		pW.add(lblWechat);
		pW.setBackground(Color.WHITE);
		lblWechat.setBounds(20, 20, 80, 50);
		pA.setBounds(50, 280, 220, 150);
		pA.add(lblAlipay);
		pA.setBackground(Color.white);
		lblAlipay.setBounds(20, 20, 80, 50);
		pO.setBounds(300, 280, 220, 150);
		pO.add(lblOther);
		pO.setBackground(Color.white);
		lblOther.setBounds(20, 20, 80, 50);
		p3.removeAll();
		p3.add(pC);
		p3.add(pW);
		p3.add(pA);
		p3.add(pO);
		p3.add(pan);
		p3.validate();
		showAssets(user);	
	}
	
	/**
	 * Show assets.展示用户资产情况
	 *
	 * @param user the user 用户名
	 */
	public void showAssets(String user) {
		String sql="select card,weChat,alipay,other from assets where username='"+user+"'";
		ResultSet rs=adao.query(sql);
		try {
			cMoney=new JLabel ();
			cMoney.setBounds(50,80,100,50);
			cMoney.setFont(font);
			pC.add(cMoney);
			wMoney=new JLabel ();
			wMoney.setBounds(50,80,100,50);
			wMoney.setFont(font);
			pW.add(wMoney);
			aMoney=new JLabel ();
			aMoney.setBounds(50,80,100,50);
			aMoney.setFont(font);
			pA.add(aMoney);
			oMoney=new JLabel ();
			oMoney.setBounds(50,80,100,50);
			oMoney.setFont(font);
			pO.add(oMoney);
			while(rs.next()) {
			cMoney.setText(String.valueOf(rs.getString(1)));
			wMoney.setText(String.valueOf(rs.getString(2)));
			aMoney.setText(String.valueOf(rs.getString(3)));
			oMoney.setText(String.valueOf(rs.getString(4)));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
