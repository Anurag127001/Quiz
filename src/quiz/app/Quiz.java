package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno;
    JTextArea question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    public static String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(220, 0, 1090, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(120, 0, 870, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(60, 450, 50, 25);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(qno);
        
        question = new JTextArea();
        question.setBounds(88, 450, 950, 45);
        question.setFont(new Font("Tahoma", Font.PLAIN, 20));
        question.setLineWrap(true);
        add(question);
        
        questions[0][0] = "Which keyword is used to define a subclass in Java?";
        questions[0][1] = "subclass";
        questions[0][2] = "extends";
        questions[0][3] = "inherit";
        questions[0][4] = "subclassOf";

        questions[1][0] = "What is the purpose of the static keyword in Java?";
        questions[1][1] = "It indicates that a variable or method belongs to the instance of a class.";
        questions[1][2] = "It is used to create objects of a class.";
        questions[1][3] = "It is used to define a class that cannot be instantiated.";
        questions[1][4] = "It indicates that a variable or method belongs to the class itself, rather than to instances of the class.";

        questions[2][0] = "Which of the following is true about the NullPointerException in Java?";
        questions[2][1] = "It occurs when a variable is not declared.";
        questions[2][2] = "It occurs when an array index is out of bounds.";
        questions[2][3] = "It occurs when an object is accessed using a reference variable that points to null.";
        questions[2][4] = "It occurs when a loop condition is never satisfied.";

        questions[3][0] = "What is the purpose of the break statement in a loop?";
        questions[3][1] = "It terminates the current iteration of the loop and continues with the next iteration.";
        questions[3][2] = "It terminates the loop and the program execution continues with the next statement after the loop.";
        questions[3][3] = "It is used to skip the current iteration of the loop and continue with the next iteration.";
        questions[3][4] = "It restarts the loop from the beginning.";

        questions[4][0] = "Which data structure in Java stores elements in a sorted order?";
        questions[4][1] = "ArrayList";
        questions[4][2] = "LinkedList";
        questions[4][3] = "HashSet";
        questions[4][4] = "TreeSet";

        questions[5][0] = "In Java, which access modifier provides the highest level of visibility?";
        questions[5][1] = "private";
        questions[5][2] = "protected";
        questions[5][3] = "default";
        questions[5][4] = "public";

        questions[6][0] = "Which Java keyword is used to explicitly throw an exception?";
        questions[6][1] = "raise";
        questions[6][2] = "throw";
        questions[6][3] = "exception";
        questions[6][4] = "emit";

        questions[7][0] = "Which Java interface should a class implement to define natural ordering for its objects?";
        questions[7][1] = "Sortable";
        questions[7][2] = "Ordered";
        questions[7][3] = "Comparable";
        questions[7][4] = "Comparator";

        questions[8][0] = "What is the purpose of the equals() method in Java?";
        questions[8][1] = "It is used to compare two primitive data types.";
        questions[8][2] = "It is used to compare the references of two objects.";
        questions[8][3] = "It is used to compare the values of two objects for equality.";
        questions[8][4] = "It is used to check if an object is null.";

        questions[9][0] = "Which Java loop is guaranteed to execute at least once?";
        questions[9][1] = "'for' loop";
        questions[9][2] = "'while' loop";
        questions[9][3] = "'do-while' loop";
        questions[9][4] = "'for-each' loop";
        
        answers[0][1] = "extends";
        answers[1][1] = "It indicates that a variable or method belongs to the class itself, rather than to instances of the class.";
        answers[2][1] = "It occurs when an object is accessed using a reference variable that points to null.";
        answers[3][1] = "It terminates the loop and the program execution continues with the next statement after the loop.";
        answers[4][1] = "TreeSet";
        answers[5][1] = "public";
        answers[6][1] = "throw";
        answers[7][1] = "Comparable";
        answers[8][1] = "It is used to compare the references of two objects.";
        answers[9][1] = "'do-while' loop";
        
        opt1 = new JRadioButton();
        opt1.setBounds(105, 500, 1500, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(105, 540,1500, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(105, 580, 1500, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(105, 620, 1500, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(200, 710, 200, 40);
        next.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 26));
        next.setBackground(new Color (4, 181, 189));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(450, 710, 200, 40);
        lifeline.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 26));
        lifeline.setBackground(new Color (4, 181, 189));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(700, 710, 200, 40);
        submit.setFont(new Font("Bahnschrift SemiBold", Font.PLAIN, 26));
        submit.setBackground(new Color (4, 181, 189));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left " + timer ;//+ "sec "; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Dialog", Font.BOLD, 38));
        
        if (timer > 0) { 
            g.drawString(time, 670, 400);
        } else {
            g.drawString("Times up!!", 670, 400);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz(name);
    }
}