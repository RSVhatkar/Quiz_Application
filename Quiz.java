import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
public class Quiz extends JFrame implements ActionListener{
	
	JLabel background,qno,question;
	JButton next,lifeline,submit;
	JRadioButton opt1,opt2,opt3,opt4;
	ButtonGroup optiongroup;
	
	public static int timer=15;
	public static int ans_given=0;
	public static int count=0;
	public static int score=0;
		
	String questions[][]=new String[10][5];//10 rows & 5 cols means 1col for que & 4 for options
	String answers[][]=new String[10][2];
	String useranswers[][]=new String[10][1];//1st para means 10 ques 2nd para means 1 ans
	
	String sname;
	
	Quiz(String sname)
	{
		this.sname=sname;
		
		setBounds(0,50,1440,850);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("icon/quiz.jpg");
		
		background=new JLabel("",img,JLabel.CENTER);
		background.setBounds(0,0,1440,392);
		add(background);
		
		qno=new JLabel();
		qno.setBounds(100,450,50,30);
		qno.setFont(new Font("Tahoma",Font.PLAIN,24));
		add(qno);
		
		question=new JLabel();
		question.setBounds(150,450,900,30);
		question.setFont(new Font("Tahoma",Font.PLAIN,24));
		add(question);
		
		questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        opt1=new JRadioButton();
        opt1.setBounds(170,520,700,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);
        
        opt2=new JRadioButton();
        opt2.setBounds(170,560,700,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);
        
        opt3=new JRadioButton();
        opt3.setBounds(170,600,700,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);
        
        opt4=new JRadioButton();
        opt4.setBounds(170,640,700,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);
        
        optiongroup=new ButtonGroup();
        optiongroup.add(opt1);
        optiongroup.add(opt2);
        optiongroup.add(opt3);
        optiongroup.add(opt4);
        
        next=new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.white);
		add(next);
		next.addActionListener(this);
		
		lifeline=new JButton("50 50 Lifeline");
		lifeline.setBounds(1100,630,200,40);
		lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
		lifeline.setBackground(new Color(30,144,255));
		lifeline.setForeground(Color.white);
		add(lifeline);
		lifeline.addActionListener(this);
		
		submit=new JButton("Submit");
		submit.setBounds(1100,710,200,40);
		submit.setFont(new Font("Tahoma",Font.PLAIN,22));
		submit.setBackground(new Color(30,144,255));
		submit.setForeground(Color.white);
		submit.setEnabled(false);//by default it should be disabled
		add(submit);
		submit.addActionListener(this);
		
		start(count);
        
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==next)
		{
			repaint();
			
			//to enable all options
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			
			ans_given=1;
			
			if(optiongroup.getSelection()==null)//it will check if ans is null?
			{
				useranswers[count][0]="";//if no option is slected empty string will be stored
			}
			else //means if ans is selected then it will track which ans is selected
			{
				//.getActionCommand() is used to getselected value
				useranswers[count][0]=optiongroup.getSelection().getActionCommand();//if option is selected then tha ans will be stored
			}
			
			if(count==8) //on 9th que next button should be dsbaled & submit button should be enabled
			{
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			
			count++;
			start(count);
		}
		else if(ae.getSource()==lifeline)
		{
			if(count==2 || count==4 || count==6 || count==8 || count==9)
			// que1st     que3rd       que 5th      que7th      que8th
			{
				opt2.setEnabled(false);
				opt3.setEnabled(false);
			}
			else
			{
				opt1.setEnabled(false);
				opt4.setEnabled(false);
			}
			
			lifeline.setEnabled(false);//to disbale lifeline button once used
		}
		else if(ae.getSource()==submit)
		{
			ans_given=1; //means ans is given
			
			if(optiongroup.getSelection()==null)//it will check if ans is null?
			{
				useranswers[count][0]="";//if no option is slected empty string will be stored
			}
			else //means if ans is selected then it will track which ans is selected
			{
				//.getActionCommand() is used to getselected value
				useranswers[count][0]=optiongroup.getSelection().getActionCommand();//if option is selected then tha ans will be stored
			}
			
			//to calculate score
			for(int i=0; i<useranswers.length;i++)
			{
				if(useranswers[i][0].equals(answers[i][1]))
				{
					score += 10;
				}
			}
			setVisible(false);
			new Score(sname,score);
		}
	}
	
	//for timer
	public void paint(Graphics g) //paint() called automatically only once when class obj is created
	{
		super.paint(g);
		
		String time="Time left - " + timer + " seconds";//15
		
		g.setColor(Color.red);//to change color of timer
		g.setFont(new Font("Tahoma",Font.BOLD,25));
		
		if(timer>0)
		{
			g.drawString(time, 1100, 500);//setbounds of timer
		}
		else
		{
			g.drawString("Times up!!", 1100, 500);
		}
		
		timer--; //decreament timer
		
		try
		{
			Thread.sleep(1000);//will wait for 1sec than call repaint()
			repaint();//calls paint()
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(ans_given == 1) //1 means ans is given,when ans is given then set ans_given to 0 for next que
		{
			ans_given=0;
			timer=15;//set timer to 15 for next question
		}
		else if(timer<0)//means ans is not given
		{
			timer=15;
			
			//to enable all options
			opt1.setEnabled(true);
			opt2.setEnabled(true);
			opt3.setEnabled(true);
			opt4.setEnabled(true);
			
			if(count==8) //on 9th que next button should be dsbaled & submit button should be enabled
			{
				next.setEnabled(false);
				submit.setEnabled(true);
			}
			
			//on 9th que if u will not click on submit button then it will automatically submit 
			if(count==9)//submit button case
			{
				if(optiongroup.getSelection()==null)//it will check if ans is null?
				{
					useranswers[count][0]="";//if no option is slected empty string will be stored
				}
				else //means if ans is selected then it will track which ans is selected
				{
					//.getActionCommand() is used to getselected value
					useranswers[count][0]=optiongroup.getSelection().getActionCommand();//if option is selected then tha ans will be stored
				}
				
				//to calculate score
				for(int i=0; i<useranswers.length;i++)
				{
					if(useranswers[i][0].equals(answers[i][1]))
					{
						score += 10;
					}
				}
				setVisible(false);
				new Score(sname,score);
			}
			else //next button case
			{
				if(optiongroup.getSelection()==null)//it will check if ans is null?
				{
					useranswers[count][0]="";//if no option is slected empty string will be stored
				}
				else //means if ans is selected then it will track which ans is selected
				{
					//.getActionCommand() is used to getselected value
					useranswers[count][0]=optiongroup.getSelection().getActionCommand();//if option is selected then tha ans will be stored
				}
				count++;
				
				start(count);//to call start() for next question
			}		
		}
	}
	
	public void start(int count)
	{
		qno.setText(""+(count+1)+".");//to dynamically set question no
		
		question.setText(questions[count][0]);//to dynamically set questions
		
		opt1.setText(questions[count][1]);//to dynamically set options
		opt1.setActionCommand(questions[count][1]);//to set option value
		
		opt2.setText(questions[count][2]);//to dynamically set options
		opt2.setActionCommand(questions[count][2]);//to set option value
		
		opt3.setText(questions[count][3]);//to dynamically set options
		opt3.setActionCommand(questions[count][3]);//to set option value
		
		opt4.setText(questions[count][4]);//to dynamically set options
		opt4.setActionCommand(questions[count][4]);//to set option value
		
		optiongroup.clearSelection();//to clear previously selected answer
	}

	public static void main(String[] args) {
		new Quiz("User");

	}

}
