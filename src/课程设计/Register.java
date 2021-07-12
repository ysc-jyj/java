package 课程设计;
import java.awt.*;
import javax.swing.*;

import Dao.AssetsDao;
import Dao.UserDao;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
// TODO: Auto-generated Javadoc

/**
 * The Class Register.
 *	完成注册
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class Register {
	
	/** The driver name. */
	String driverName="com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri="jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The user DB. */
	UserDao userDB=new UserDao(driverName,uri); 
	
	/** The adao. */
	AssetsDao adao=new AssetsDao(driverName,uri);
	
	/** The frame. */
	JFrame frame;
	
	/** The btn clear. */
	/** The btn clear. */
	JButton btnOK, btnClear;
	
	/** The lbl A pwd. */
	JLabel lbl,lblUser, lblPwd, lblAPwd;
	
	/** The txt A pwd. */
	JTextField txtUser, txtPwd,txtAPwd;
	
	/** The pan south. */
	JPanel panCenter,panSouth;
	
	/**
	 * Instantiates a new register.
	 */
	public Register(){
		frame=new JFrame("注册");
		lbl=new JLabel("请输入信息：");
		lbl.setFont(new Font("罗西钢笔行楷",Font.BOLD,40));
		lblUser=new JLabel("用户名：");
		txtUser=new JTextField(20);
		lblPwd=new JLabel("密码：");
		txtPwd=new JPasswordField(20);
		txtPwd.setFont(new Font("",Font.BOLD,20));
		lblAPwd=new JLabel("重新输入密码：");
		txtAPwd=new JPasswordField(20);
		txtAPwd.setFont(new Font("",Font.BOLD,20));
		btnOK=new JButton("确定");
		btnClear=new JButton("清除");
		frame.setSize(400,300);
		frame.setLocation(300, 300);
		panCenter=new JPanel(new GridLayout(3,2));
		frame.add(panCenter,BorderLayout.CENTER);
		panSouth=new JPanel(new FlowLayout());
		frame.add(panSouth,BorderLayout.SOUTH);
		frame.add(lbl,BorderLayout.NORTH);
		panCenter.add(lblUser);
		panCenter.add(txtUser);
		panCenter.add(lblPwd);
		panCenter.add(txtPwd);
		panCenter.add(lblAPwd);
		panCenter.add(txtAPwd);
		panSouth.add(btnOK);
		panSouth.add(btnClear);
		frame.setVisible(true);
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username=txtUser.getText();
				String sql="select * from user where username='" + username + "'";
				ResultSet rs=userDB.queryUser(sql);
				try {
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "用户名重复，请重新输入");
						txtUser.setText("");
						txtPwd.setText("");
						txtAPwd.setText("");
					}else if(!(txtPwd.getText().equals(txtAPwd.getText()))) {
						JOptionPane.showMessageDialog(null, "密码不一致，请重新输入密码");
						txtPwd.setText("");
						txtAPwd.setText("");
					}else {
						String sql2="insert into user(username,password) values(?,?)";
						String user=txtUser.getText();
						String password=txtPwd.getText();
						userDB.saveUser(sql2, user, password);
						double card=0;
						double weChat=0;
						double alipay=0;
						double other=0;
						String sql3="insert into assets(username,card,weChat,alipay,other) values(?,?,?,?,?)";
						adao.saveAssets(sql3, user, card, weChat, alipay, other);
						JOptionPane.showMessageDialog(null, "注册成功！");
						frame.dispose();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUser.setText("");
				txtPwd.setText("");
				txtAPwd.setText("");
			}
		});
	}
}
