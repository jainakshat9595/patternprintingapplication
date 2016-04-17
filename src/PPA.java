import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

class Frame0 extends JFrame implements ActionListener
{
	JLabel title = new JLabel("Pattern Printing Application 1.0");
	JButton next = new JButton("Next");
	JLabel text1 = new JLabel("                                              Developed By : Aksh@t Jain                                           ");
	JLabel text2 = new JLabel("                                    All Copyrights Reserved @ Akshat Jain(2014-2015)                       ");
	
	Container con;
	JPanel panel = new JPanel();
	
	public Frame0()
	{
		super("Pattern Printing Application 1.0 - Aksh@t Jain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con = getContentPane();
		con.add(panel);
		panel.add(title);
		title.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		panel.add(text1);
		panel.add(next);
		panel.add(text2);
		next.addActionListener(this);				
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == next) 
		{
			this.setVisible(false);
			Frame1 f1 = new Frame1();
			f1.setSize(445,180);
			f1.setVisible(true);
			f1.setResizable(false);
			f1.setBounds(250,250,445,180);
		}
	}
}

class Frame1 extends JFrame implements ActionListener
{
	int patNum;	
	String sym;
	int row;
	
	JLabel selectSymbol = new JLabel("Select the Symbol : ");
	
	JCheckBox star  = new JCheckBox(" Star(*)", true);
	JCheckBox power = new JCheckBox(" Power(^)", false);
	JCheckBox dot   = new JCheckBox(" Dot(.)", false);
	JCheckBox minus = new JCheckBox(" Minus(-)", false);
	
	JLabel selectPattern = new JLabel("Select the Pattern : ");
	String [] patterns = 
		{	"Half Pyramid : Left  Justified",
			"Half Pyramid : Right Justified",
			"Triangle",
			"Diamond",
		};
	JComboBox patBox = new JComboBox(patterns);
	
	JLabel enterRows = new JLabel("Enter the Number of Rows(<= 10) : ");

	JButton next = new JButton("Next");
	JButton exit = new JButton("Exit");
	
	JTextField rows = new JTextField("0",20);
        
	JLabel mess = new JLabel(" ");
	
	Container con;
	JPanel panel = new JPanel();
	
	public Frame1()
	{
		super("Pattern Printing Application 1.0 - Aksh@t Jain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con = getContentPane();
		con.add(panel);
		ButtonGroup symbolGroup = new ButtonGroup();
		symbolGroup.add(star);
		symbolGroup.add(power);
		symbolGroup.add(dot);
		symbolGroup.add(minus);
		panel.add(selectSymbol);
		panel.add(star);
		panel.add(power);
		panel.add(dot);
		panel.add(minus);
		panel.add(selectPattern);
		panel.add(patBox);
		panel.add(enterRows);
		panel.add(rows);
		panel.add(next);
		panel.add(exit);
		panel.add(mess);
		star.addActionListener(this);
		power.addActionListener(this);
		dot.addActionListener(this);
		minus.addActionListener(this);
		patBox.addActionListener(this);
		rows.addActionListener(this);
		next.addActionListener(this);
		exit.addActionListener(this);		
	}
	int getpatNum()
	{
		return patNum;
	}
	String getsym()
	{
		return sym;
	}
	void setpatNum(int a)
	{
		patNum=a;
	}
	int getrow()
	{
		return row;
	}
	void setrow(int a)
	{
		row=a;
	}
	void setsym(String a)
	{
		sym=a;
	}
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		
		if(star.isSelected()) 
		{
			this.setsym("*"); 
		}
		else if(power.isSelected()) 
		{
			this.setsym("^"); 
		}
		else if(dot.isSelected()) 
		{
			this.setsym("."); 
		}
		else if(minus.isSelected()) 
		{
			this.setsym("-"); 
		}
		if(source == next) 
		{
			this.setrow(Integer.parseInt(rows.getText()));
			if(this.getrow() > 10)
			{
				mess.setText("Number of Rows cannot be greater than 10. Try Again !!");
			}
                        else if(this.getrow() == 0)
                        {
                            mess.setText("                        Number of Rows cannot be 0. Try Again !!             ");
                        }
			else
			{
				this.setpatNum(patBox.getSelectedIndex()); 
				this.setVisible(true);
				Frame2 f2 = new Frame2();
				f2.setSize((this.getrow()*60),(this.getrow()*55));
				f2.setVisible(true);
				f2.setResizable(false);
				f2.setBounds(150,150,(this.getrow()*60),(this.getrow()*55));
				f2.draw(this.getsym(),this.getpatNum(),this.getrow());
			}
		}
		else if(source == exit)
		{
			this.setVisible(false);
			Frame3 f3 = new Frame3();
			f3.setSize(480,160);
			f3.setVisible(true);
			f3.setResizable(false);
			f3.setBounds(250,250,480,160);
		}
	}
}

class Frame2 extends JFrame 
{
	JCanvas canvas = new JCanvas();
	
	public Frame2()
	{
		super("Pattern Printing Application 1.0 - Aksh@t Jain");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		add(canvas);
	}
	
	void pat0(String s,int r) 
	{
		//
	}
	void pat1(String s,int r) 
	{
		//
	}
	void pat3(String s,int r) 
	{
		int midx,midy,x,y,i,j;
		midx = canvas.getHeight()/2; midy = canvas.getWidth()/2;
		canvas.setFont(new Font("Arial",Font.PLAIN,50));
		x=midx-(20*(r-1));y=midy-(20*r);
		for(i=0;i<=r;i++)
		{
			for(j=0;j<(r-i);j++)
			{
				canvas.drawString(" ",x,y);
				x=x+20;
			}
			for(j=0;j<i;j++)
			{
				canvas.drawString(s,x,y);
				x=x+40;
			}
			x=midx-(20*(r-1));
			y=y+20;
			
		}
		x=midx-(20*(r-1)); y=midy-(20*r)+(r*20); 
		for(i=0;i<=(r-1);i++)
		{
			for(j=0;j<i;j++)
			{
				canvas.drawString(" ",x,y);
				x=x+20;
			}
			for(j=0;j<(r-i);j++)
			{
				canvas.drawString(s,x,y);
				x=x+40;
			}
			x=midx-(20*(r-1));
			y=y+20;
			
		}

	}
	void pat2(String s,int r)
	{
		int midx,midy,x,y,i,j;
		midx = canvas.getHeight()/2; midy = canvas.getWidth()/2;
		canvas.setFont(new Font("Arial",Font.PLAIN,50));
		x=midx-(20*(r-1));y=midy-(20*r);
		for(i=0;i<=r;i++)
		{
			for(j=0;j<(r-i);j++)
			{
				canvas.drawString(" ",x,y);
				x=x+20;
			}
			for(j=0;j<i;j++)
			{
				canvas.drawString(s,x,y);
				x=x+40;
			}
			x=midx-(20*(r-1));
			y=y+20;
			
		}
	}
	
	void draw(String s,int p,int r)
	{
		switch(p)
		{
			case 0: this.pat0(s,r);
					break;
			case 1: this.pat1(s,r);
					break;
			case 2: this.pat2(s,r);
					break;
			case 3: this.pat3(s,r);
					break;
		}
	}
}
 
class Frame3 extends JFrame implements ActionListener
{
	JLabel title = new JLabel("       THANK YOU      ");
	JButton next = new JButton("Exit");
	JLabel text1 = new JLabel("                                              Developed By : Aksh@t Jain                                           ");
	JLabel text2 = new JLabel("                                                   Hope You Liked it .. :)                                                    ");
	
	Container con;
	JPanel panel = new JPanel();
	
	public Frame3()
	{
		super("Pattern Printing Application 1.0 - Aksh@t Jain");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con = getContentPane();
		con.add(panel);
		panel.add(title);
		title.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		panel.add(text1);
		panel.add(next);
		panel.add(text2);
		next.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source == next) 
			System.exit(0);
	}
}

public class PPA
{
	public static void main(String [] args)
	{
		Frame0 f0 = new Frame0();
		int w = 480;
		int h = 160;
		f0.setSize(w,h);
		f0.setVisible(true);
		f0.setResizable(false);
		f0.setBounds(250,250,w,h);
	}
	
}