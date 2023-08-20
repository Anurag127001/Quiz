package quiz.app;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;


public class Login extends JFrame implements ActionListener{
	
	JButton rules,back;
	JTextField tfname;
	
	Login(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		
//		
//		JLabel heading = new JLabel("Quizenza");
//		heading.setBounds(200, 600, 300, 45);
//		heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 40));
//		heading.setForeground(new Color(30, 144, 254));  // for RGB color
////		heading.setForeground(Color.BLUE);
//		add(heading);
//		
		
		JLabel name = new JLabel("Enter your name");
		name.setBounds(260, 455, 300, 38);
		name.setFont(new Font("Adobe Hebrew", Font.BOLD, 24));
		name.setForeground(new Color(30, 144, 254));
		add(name);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 610, 520);
		add(image);
		
		tfname = new JTextField();
		tfname.setBounds(200, 510, 300, 35);
		tfname.setFont(new Font("Times New Romen", Font.BOLD, 20));
		add(tfname);
		
		
		rules = new JButton("Rules");
		rules.setBounds(200, 570, 120, 32);
		rules.setFont(new Font("", Font.PLAIN, 18));
		rules.setBackground(new Color (4, 181, 189));
		rules.setForeground(Color.WHITE);
		rules.addActionListener(this);
		add(rules);
	
		
		back = new JButton("Back");
		back.setBounds(380, 570, 120, 32);
		back.setFont(new Font("", Font.PLAIN, 18));
		back.setBackground(new Color (4, 181, 189));		
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		
		
		setSize(670,700);
		setLocation(450,100);
		setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == rules) {
			String name = tfname.getText();
			setVisible(false);
			new Rules(name);
		}
		else if (e.getSource()== back) {
			setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		new Login();
	}


	
}
