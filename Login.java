import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
	
	JLabel background,heading,name;
	JTextField nametext;
	JButton rules,back;
	
	Login()
	{
		setSize(1200,500);
		setLocation(200,150);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("icon/login.jpeg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,600,500);
		add(background);
		
		heading=new JLabel("Simple Minds");
		heading.setBounds(750,60,300,45);
		heading.setFont(new Font("Viner Hand ITC",Font.BOLD,40));
		heading.setForeground(new Color(30,144,254));
		add(heading);
		
		name=new JLabel("Enter your name");
		name.setBounds(810,150,300,20);
		name.setFont(new Font("Mongolian Baiti",Font.BOLD,18));
		name.setForeground(new Color(30,144,254));
		add(name);
		
		nametext=new JTextField();
		nametext.setBounds(735,200,300,25);
		nametext.setFont(new Font("Times New Roman",Font.BOLD,20));
		add(nametext);
		
		rules=new JButton("Rules");
		rules.setBounds(735,270,120,25);
		rules.setBackground(new Color(30,144,254));
		rules.setForeground(Color.white);
		add(rules);
		rules.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(915,270,120,25);
		back.setBackground(new Color(30,144,254));
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==rules)
		{
			String sname=nametext.getText();
			setVisible(false);
			new Rules(sname);
		}
		else
		{
			setVisible(false);
		}
	}

	public static void main(String[] args) {
			new Login();

	}

}
