package 课程设计;
import java.awt.*;
import javax.swing.*;

import Dao.UserDao;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
// TODO: Auto-generated Javadoc

/**
 * The Class Login.
 *
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class Login {
	
	/** The driver name. */
	String driverName="com.mysql.jdbc.Driver";
	
	/** The uri. */
	String uri="jdbc:mysql://localhost:3306/jsu?user=root&password=123456&useSSL=true";
	
	/** The user DB. */
	UserDao userDB=new UserDao(driverName,uri); 
	
	/** The frame. */
	JFrame frame;
	
	/** The btnLog. */
	/** The btnRegister. */
	JButton btnLog, btnRegister;
	
	/** The lblTitle.*/
	/** The lblPwd.*/
	/** The lblTitle.*/
	JLabel lblUser, lblPwd,lblTitle;
	
	/** The txtPwd. */
	/** The txtUser.*/
	JTextField txtUser, txtPwd;
	
	/**
	 * Instantiates a new login.
	 */
	public Login() {
		frame = new JFrame("登录窗口");
		btnLog = new JButton("登录");
		btnRegister = new JButton("注册");
		lblUser = new JLabel("用户名：");
		txtUser = new JTextField(20);
		lblPwd = new JLabel("密码：");
		lblTitle=new JLabel("欢迎使用个人财务管理系统");
		lblTitle.setFont(new Font("微软雅黑",Font.ITALIC,30));
		txtPwd = new JPasswordField(20);
		txtPwd.setFont(new Font("",Font.BOLD,20));
		frame.setSize(500, 600);
		frame.setLocation(300, 300);
		frame.setLayout(null);
		frame.setResizable(false);
		lblTitle.setBounds(50, 50, 400, 100);
		lblUser.setBounds(100, 200, 60,30);
		txtUser.setBounds(160, 200, 200,30);
		lblPwd.setBounds(100, 240, 60,30);
		txtPwd.setBounds(160, 240, 200,30);
		btnLog.setBounds(170, 420, 60, 30);
		btnRegister.setBounds(270, 420, 60, 30);
		frame.add(lblTitle);
		frame.add(lblUser);
		frame.add(txtUser);
		frame.add(lblPwd);
		frame.add(txtPwd);
		frame.add(btnLog);
		frame.add(btnRegister);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnLog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user=txtUser.getText();
				String password=txtPwd.getText();
				String sql="select * from user where username='" + user + "'";
				ResultSet rs=userDB.queryUser(sql);
				try {
					if(rs.next()) {
						if(rs.getString(2).equals(password)) {
							//JOptionPane.showMessageDialog(null, "登录成功");
							new MainFrame(user);
							frame.dispose();
						}else {
							txtPwd.setText("");
							JOptionPane.showMessageDialog(null, "用户名或密码错误！");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "用户不存在！");
						txtUser.setText("");
						txtPwd.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (HeadlessException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Register();	
			}
		});
	}
	
	/**
	 * Close. 关闭数据库连接
	 */
	public void close(){
		userDB.closeAll();
	}
}
