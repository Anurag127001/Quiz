package quiz.app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score) {
        setBounds(450, 100, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
//        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
//        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0, 200, 300, 250);
//        add(image);
        
        JLabel heading = new JLabel("Thank you " + name + " for playing Quizenza");
        heading.setBounds(60, 30, 700, 50);
        heading.setFont(new Font("Adobe Arabic", Font.PLAIN, 55));
        add(heading);
        
        JLabel lbl = new JLabel("Your score is");
        lbl.setBounds(160, 100, 500, 120);
        lbl.setFont(new Font("Adobe Arabic", Font.PLAIN, 100));
        add(lbl);
        
        JLabel lblscore = new JLabel(""+score);
        lblscore.setBounds(350, 200, 500, 120);
        lblscore.setFont(new Font("Adobe Arabic", Font.PLAIN, 130));
        add(lblscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(310, 400, 130, 30);
        submit.setFont(new Font ("", Font.PLAIN,18));
        submit.setBackground(new Color (4, 181, 189));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}