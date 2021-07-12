package �γ����;
import java.awt.*;
import javax.swing.*;

import Dao.UserDao;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
// TODO: Auto-generated Javadoc

/**
 * The Class Login.
 * ��¼����
 * @date 2020-7-3
 * @author ���׭Z
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
		frame = new JFrame("��¼����");
		btnLog = new JButton("��¼");
		btnRegister = new JButton("ע��");
		lblUser = new JLabel("�û�����");
		txtUser = new JTextField(20);
		lblPwd = new JLabel("���룺");
		lblTitle=new JLabel("��ӭʹ�ø��˲������ϵͳ");
		lblTitle.setFont(new Font("�����ֱ��п�",Font.ITALIC,30));
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
							//JOptionPane.showMessageDialog(null, "��¼�ɹ�");
							new MainFrame(user);
							frame.dispose();
						}else {
							txtPwd.setText("");
							JOptionPane.showMessageDialog(null, "�û������������");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "�û������ڣ�");
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
	 * Close. �ر����ݿ�����
	 */
	public void close(){
		userDB.closeAll();
	}
}
