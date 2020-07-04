package �γ����;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class Calculator.
  *  �ṩ���㹦��
 * @date 2020-7-3
 * @author ���׭Z
 * @version  v1.0
 */
public class Calculator {
	
	/** The frame. */
	private JFrame frame = new JFrame("���׼�����");
	
	/** The txt. */
	private JTextField txt = new JTextField(15);
	
	/** The btnClear. */
	private JButton btnClear = new JButton("���");
	
	/** The panNorth. */
	private JPanel panNorth = new JPanel(new FlowLayout());
	
	/** The panSouth. */
	private JPanel panSouth = new JPanel(new GridLayout(4, 4));
	
	/** The jb. */
	JButton[] jb = new JButton[10]; // 0~9�ĸ�����
	
	/** The bot. */
	/** The add. */
	/** The sub. */
	/**	The mul. */
	/** The div. */
	/** The equ. */
	JButton bot, add, sub, mul, div, equ;// �Ӽ��˳���С����
	
	/**
	 * Instantiates a new calculator.
	 */
	public Calculator(){
		frame.setSize(400, 300);
		frame.setLocation(500, 500);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		frame.add(panNorth, BorderLayout.NORTH);
		frame.add(panSouth);
		panNorth.add(txt);
		panNorth.add(btnClear);
		bot = new JButton(".");
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		equ = new JButton("=");
		for (int i = 0; i < 10; i++) {// �ֱ�Ϊ������0~9�ŵİ�ť���ñ�ǩ
			String s = "" + i;
			jb[i] = new JButton(s);
		}
		panSouth.add(jb[7]);
		panSouth.add(jb[8]);
		panSouth.add(jb[9]);
		panSouth.add(div);
		// �ڶ���
		panSouth.add(jb[4]);
		panSouth.add(jb[5]);
		panSouth.add(jb[6]);
		panSouth.add(mul);
		// ������
		panSouth.add(jb[1]);
		panSouth.add(jb[2]);
		panSouth.add(jb[3]);
		panSouth.add(sub);
		// ������
		panSouth.add(bot);
		panSouth.add(jb[0]);
		panSouth.add(equ);
		panSouth.add(add);
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText("");

			}
		});
		buttonEvent(jb[0]);
		buttonEvent(jb[1]);
		buttonEvent(jb[2]);
		buttonEvent(jb[3]);
		buttonEvent(jb[4]);
		buttonEvent(jb[5]);
		buttonEvent(jb[6]);
		buttonEvent(jb[7]);
		buttonEvent(jb[8]);
		buttonEvent(jb[9]);
		buttonEvent(bot);
		buttonEvent(add);
		buttonEvent(sub);
		buttonEvent(mul);
		buttonEvent(div);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		equ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText(txt.getText() + equ.getText());
				if (txt.getText().contains("+")) {// �ӷ�����
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "+");// ����һ���������� str �� StringTokenizer���󣬲��ṩһ��ָ���ķָ�����
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//���شӵ�ǰλ�õ���һ���ָ������ַ�����
					while(s1.hasMoreTokens()) {//�����Ƿ��зָ���
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1+d2));
					}
				}else if(txt.getText().contains("-")) {//����
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "-");// ����һ���������� str �� StringTokenizer���󣬲��ṩһ��ָ���ķָ�����
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//���شӵ�ǰλ�õ���һ���ָ������ַ�����
					while(s1.hasMoreTokens()) {//�����Ƿ��зָ���
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1-d2));
					}
				}else if(txt.getText().contains("*")) {//�˷�
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "*");// ����һ���������� str �� StringTokenizer���󣬲��ṩһ��ָ���ķָ�����
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//���شӵ�ǰλ�õ���һ���ָ������ַ�����
					while(s1.hasMoreTokens()) {//�����Ƿ��зָ���
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1*d2));
					}
				}else if(txt.getText().contains("/")) {//����
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "/");// ����һ���������� str �� StringTokenizer���󣬲��ṩһ��ָ���ķָ�����
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//���شӵ�ǰλ�õ���һ���ָ������ַ�����
					while(s1.hasMoreTokens()) {//�����Ƿ��зָ���
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1/d2));
					}
				}
			}

		});
	}

	/**
	 * Button event. ���а�ť�����¼�
	 *
	 * @param btn the btn
	 */
	public void buttonEvent(JButton btn) {// ���а�ť�¼�
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = btn.getText();
				txt.setText(txt.getText() + s);
			}

		});

	}
	
}
