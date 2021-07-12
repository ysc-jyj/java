package 课程设计;

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
  * 计算器
 * @date 2020-7-3
 * @author 焦易璟
 * @version  v1.0
 */
public class Calculator {
	
	/** The frame. */
	private JFrame frame = new JFrame("简易计算器");
	
	/** The txt. */
	private JTextField txt = new JTextField(15);
	
	/** The btnClear. */
	private JButton btnClear = new JButton("清除");
	
	/** The panNorth. */
	private JPanel panNorth = new JPanel(new FlowLayout());
	
	/** The panSouth. */
	private JPanel panSouth = new JPanel(new GridLayout(4, 4));
	
	/** The jb. */
	JButton[] jb = new JButton[10]; // 0~9四个数字
	
	/** The bot. */
	/** The add. */
	/** The sub. */
	/**	The mul. */
	/** The div. */
	/** The equ. */
	JButton bot, add, sub, mul, div, equ;// 加减乘除加小数点
	
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
		for (int i = 0; i < 10; i++) {// 分别为数组中0~9号的按钮设置标签
			String s = "" + i;
			jb[i] = new JButton(s);
		}
		panSouth.add(jb[7]);
		panSouth.add(jb[8]);
		panSouth.add(jb[9]);
		panSouth.add(div);
		// 第二行
		panSouth.add(jb[4]);
		panSouth.add(jb[5]);
		panSouth.add(jb[6]);
		panSouth.add(mul);
		// 第三行
		panSouth.add(jb[1]);
		panSouth.add(jb[2]);
		panSouth.add(jb[3]);
		panSouth.add(sub);
		// 第四行
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
				if (txt.getText().contains("+")) {// 加法运算
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "+");// 构造一个用来解析 str 的 StringTokenizer对象，并提供一个指定的分隔符。
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//返回从当前位置到下一个分隔符的字符串。
					while(s1.hasMoreTokens()) {//返回是否还有分隔符
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1+d2));
					}
				}else if(txt.getText().contains("-")) {//减法
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "-");// 构造一个用来解析 str 的 StringTokenizer对象，并提供一个指定的分隔符。
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//返回从当前位置到下一个分隔符的字符串。
					while(s1.hasMoreTokens()) {//返回是否还有分隔符
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1-d2));
					}
				}else if(txt.getText().contains("*")) {//乘法
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "*");// 构造一个用来解析 str 的 StringTokenizer对象，并提供一个指定的分隔符。
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//返回从当前位置到下一个分隔符的字符串。
					while(s1.hasMoreTokens()) {//返回是否还有分隔符
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1*d2));
					}
				}else if(txt.getText().contains("/")) {//除法
					StringTokenizer s1 = new StringTokenizer(txt.getText(), "/");// 构造一个用来解析 str 的 StringTokenizer对象，并提供一个指定的分隔符。
					double d1,d2=0;
					d1=Double.parseDouble(s1.nextToken());//返回从当前位置到下一个分隔符的字符串。
					while(s1.hasMoreTokens()) {//返回是否还有分隔符
						StringTokenizer s2=new StringTokenizer(s1.nextToken(),"=");
						d2=Double.parseDouble(s2.nextToken());
						txt.setText(" "+(d1/d2));
					}
				}
			}

		});
	}

	/**
	 * Button event. 所有按钮操作事件
	 *
	 * @param btn the btn 按钮
	 */
	public void buttonEvent(JButton btn) {// 所有按钮事件
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = btn.getText();
				txt.setText(txt.getText() + s);
			}

		});

	}
	
}
