import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import java.awt.event.*;
public class Score extends JFrame implements ActionListener{
	
	JLabel background,heading,lblscore;
	JButton submit;
	
	Score(String sname,int score)
	{
		setBounds(400,150,750,550);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("icon/score.png");
		Image i=img.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(0,200,300,250);
		add(background);
		
		heading=new JLabel("Thankyou "+ sname +" for playing simple minds");
		heading.setBounds(45,30,700,30);
		heading.setFont(new Font("Tahoma",Font.PLAIN,26));
		add(heading);
		
		lblscore=new JLabel("Your score is "+ score);
		lblscore.setBounds(350,200,300,30);
		lblscore.setFont(new Font("Tahoma",Font.PLAIN,26));
		add(lblscore);
		
		submit=new JButton("Play Again");
		submit.setBounds(380,270,120,30);
		submit.setBackground(new Color(30,144,255));
		submit.setForeground(Color.white);
		add(submit);
		submit.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) {
		new Score("User",0);

	}

}
