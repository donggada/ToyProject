import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.tree.DefaultTreeCellEditor.DefaultTextField;

import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultText;
import com.sun.xml.internal.bind.v2.model.core.Adapter;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class ToyProject extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTextField textField_6;
	Timer t;
	 int k=0;
		int gg=1;
	 ToyDAO tdao=new ToyDAO();
	 int quizcount=tdao.getcount();
	 boolean check;
	 Set set=new TreeSet();
	 String[] Rn=null;

	 
	public  ToyProject() {
		showJFrame();
	}
	public void showJFrame() {
		
//		while(set.size()<20) {
//			int rnum=(int)(Math.random()*quizcount+1);
//			set.add(rnum);
//		}
		
	
		setBounds(250, 100, 1100, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(125, 42, 222, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(87, 41, 26, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(359, 43, 134, 28);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBounds(800, 43, 157, 40);
		getContentPane().add(btnNewButton);
		
	
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton.getText().equals("로그아웃!")) {textField.setText(""); passwordField.setText(""); btnNewButton.setText("로그인");}
				else{
				String id=textField.getText();
				String pass= new String(passwordField.getPassword());
				ToyDAO tdao=new ToyDAO();
				int num = tdao.Login(id, pass);
				if(num==1) {
					textField.setEditable(false);
					passwordField.setEditable(false);
					btnNewButton.setText("로그아웃");
					
				}else if (num==0) {
					JOptionPane.showMessageDialog(passwordField, "비밀번호가 틀렸습니다");
				}else if(num==-1){
					JOptionPane.showMessageDialog(passwordField, "아이디가 없습니다 회원가입후 로그인해주세요!");
				}
				
				
			}
			}
		});
		
		
		
		JLabel lblNewLabel_2 = new JLabel("랭킹");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(52, 185, 61, 48);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("1위");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(6, 247, 61, 16);
		getContentPane().add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 236, 130, 40);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("2위");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(6, 306, 61, 16);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("3위");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(6, 360, 61, 16);
		getContentPane().add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(52, 295, 130, 40);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(52, 349, 130, 40);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 339, 1, 16);
		getContentPane().add(textArea);
		
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(328, 204, 629, 189);
		getContentPane().add(textArea_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(566, 428, 209, 58);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
//		textField_4.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int key = e.getKeyCode(); 
//				if(key == KeyEvent.VK_ENTER) {
//					  String answer= textField_4.getText();
//					  System.out.println(answer);
//				}
//
//					
//			}
//			
//			
//		});
		
		
		JLabel lblNewLabel_6 = new JLabel("정답 ");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(493, 434, 61, 37);
		getContentPane().add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(724, 133, 116, 40);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
			

		
		
		JLabel lblNewLabel_7 = new JLabel("score");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(666, 136, 61, 28);
		getContentPane().add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("회원가입 버튼");
		btnNewButton_1.setBounds(800, 92, 157, 40);
		getContentPane().add(btnNewButton_1);
		
         btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id=textField.getText();
				String pass= new String(passwordField.getPassword());
				ToyDAO tdao=new ToyDAO();
				tdao.Membership(id, pass);
			
			}
			
			
		});
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(493, 42, 250, 40);
		getContentPane().add(passwordField);
		
		JButton btnNewButton_2 = new JButton("시작하기");
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_2.setBounds(317, 120, 176, 53);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(538, 145, 61, 16);
		getContentPane().add(lblNewLabel_8);


		
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0) {JOptionPane.showMessageDialog(textArea_1,"로그인해주세요");}else {

					while(set.size()<20) {
						int rnum=(int)(Math.random()*quizcount+1);
						set.add(rnum);
					}
					String[] Rn=set.toString().substring(1,set.toString().length()-1).split(",");

				t=new Timer(1000,new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
//						while(set.size()<20) {
//							int rnum=(int)(Math.random()*quizcount+1);
//							set.add(rnum);
//						}
						
					
						lblNewLabel_8.setText(String.valueOf(k));
						k++;
						if(lblNewLabel_8.getText().equals("30")) {
							JOptionPane.showMessageDialog(textArea_1, "Time Over");
							JOptionPane.showMessageDialog(textArea_1, textField.getText()+"님의 Score은"+textField_5.getText()+"입니다.");
							ToyDAO tdao=new ToyDAO();
							String id=textField.getText();
							String pass=new String(passwordField.getPassword());
							int score=Integer.parseInt(textField_5.getText());
							//if(score>tdao.) {
							tdao.Membership(id, pass, score);
							lblNewLabel_8.setText("");
							textArea_1.setText("");
							textField_4.setText("");
							textField_4.setEditable(false);
							
							k=0;
							t.stop();
							
						}
						
					}
				});
		
		
		t.start();
	
				
				
				 textField_5.setText("0");
				 textField_4.setEditable(true);
		
					tdao=new ToyDAO();
					String quiz= tdao.quiz(Integer.parseInt(Rn[gg].trim()),1);
					textArea_1.setText(quiz);
					
					
					
					textField_4.addKeyListener(new KeyAdapter() {

						@Override
						public void keyPressed(KeyEvent e) {
							int key = e.getKeyCode(); 
							if(key == KeyEvent.VK_ENTER) {
								  String answer="정답:"+textField_4.getText();
								
								if(answer.equals(tdao.quiz(Integer.parseInt(Rn[gg].trim()), 2).replaceAll(" ", ""))) {
									textField_5.setText(String.valueOf(Integer.parseInt(textField_5.getText())+1));
									gg++;
									String quiz= tdao.quiz(Integer.parseInt(Rn[gg].trim()),1);
									textArea_1.setText(quiz);
									textField_4.setText("");
									k=0;
																	}
							
														}

								
															}
						
						
																});
				

			
				 
			
			
			}
			
			}
			
		});

	textField_1.setText(tdao.quiz(2));
	textField_1.setEditable(false);
	textField_2.setText(tdao.quiz(1));
	textField_2.setEditable(false);
	textField_3.setText(tdao.quiz(0));
	textField_3.setEditable(false);
	
	
	

		
		setVisible(true);
	}
	


	

public static void main(String[] args) {
new ToyProject();
}
}

