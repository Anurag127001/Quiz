package quiz.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rules extends JFrame implements ActionListener{
	JButton back,start;
	String name;
	Rules(String name){
		this.name = name;
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("Welcome " + name + " to Quizenza");
		heading.setBounds(200, 20, 700, 45);
		heading.setFont(new Font("Adobe Hebrew", Font.BOLD, 32));
		heading.setForeground(Color.BLACK);  // for RGB color
		add(heading);
		
		JLabel rules = new JLabel();
		rules.setBounds(50, 50, 700, 500);
		rules.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rules.setText(
				"<html>"+ 
		                "1. By participating in <b>Quizenza</b>, you agree to abide by these rules and guidelines" + "<br><br>" +
		                "2. Participants are required to submit their answers through the provided online platform." + "<br><br>" +
		                "3. Incorrect answers will not result in negative marking." + "<br><br>" +
		                "4. The total score will be calculated based on the cumulative points earned." + "<br><br>" +
		                "5. Participants are strictly prohibited from using external resources, notes, or aids during the quiz." + "<br><br>" +
		                "6. Cheating or plagiarism will result in immediate disqualification." + "<br><br>" +
		                "7. All quiz content, questions, and materials are protected by copyright. Reproduction or distribution is prohibited without permission." + "<br><br>" +
		                "8. In case of technical difficulties, please contact our support team at [+91 9637139650]." + "<br><br>" +
		                "9. The quiz organizers reserve the right to make changes to the rules, schedule, or any other aspect of the quiz if necessary.\n" + "<br><br>" +
		                
		                "Thank you for joining us and we wish you the best of luck!" + "<br><br>" +

				"<html>");
		add(rules);
		
		
		back = new JButton("Back");
		back.setBounds(250, 530, 100, 30);
		back.setFont(new Font("", Font.PLAIN, 18));
		back.setBackground(new Color (4, 181, 189));
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		start = new JButton("Start");
		start.setBounds(400, 530, 100, 30);
		start.setFont(new Font("", Font.PLAIN, 18));
		start.setBackground(new Color (4, 181, 189));
		start.setForeground(Color.WHITE);
		start.addActionListener(this);
		add(start);
	
		
		
		
		
		
		
		
		
		setSize(800, 650);
		setLocation(450, 100);
		setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == start) {
			setVisible(false);
			new Quiz(name);
		}else {
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String args[]) {
		new Rules("User");
	}

	
}
