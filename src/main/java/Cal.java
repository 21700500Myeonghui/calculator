import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Cal extends JFrame implements ActionListener{

	JPanel panel;
	JTextField tField;
	JButton[] buttons;
	String[] labels= {"1","2","3","+","4","5","6","-","7","8","9","*","CE","0","=","/","."};
	static String totalNumber="0";
	static String op1;
	static String operation2;
	static String op2;
	static int count=0;
	static String result="";
	static int count2=0;
			
	public Cal() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300,200);
		
		tField =new JTextField();
		panel=new JPanel();
		tField.setText("0");
		
		panel.setLayout(new GridLayout(5,4));
		buttons =new JButton[17];
		
		int index=0;
		
		for(int i =0; i<17; i++)
		{
				buttons[index]=new JButton(labels[index]);
				buttons[index].addActionListener(this);
				
			    panel.add(buttons[index]);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
				index++;
				
		}
		add(tField, BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new Cal();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String number;
		String input =e.getActionCommand();
		
		if(input.equals("CE")==false &&input.equals("+")==false&&input.equals("-")==false&&input.equals("*")==false&&input.equals("/")==false&&input.equals("=")==false&&input.equals(".")==false)
		{  
			
			number=setNumber(input);
		    tField.setText(number);
		}
		
		if(input.equals("."))
		{
			count=0;
			tField.setText(totalNumber+".");
			totalNumber=Double.toString(Double.parseDouble(totalNumber));
			count2++;
		}
		if(input.equals("CE"))
		{
			tField.setText("0");
			op1="";
			operation2="";
			op2="";
			result="";
			count=0;
			totalNumber="0";
			count2=0;
		}
		if(input.equals("+"))
		{
			setOperation(input);
			tField.setText(result);
		}
		if(input.equals("-"))
		{
			setOperation(input);
			tField.setText(result);
		}
		if(input.equals("*"))
		{
			setOperation(input);
			tField.setText(result);
		}
		if(input.equals("/"))
		{
			setOperation(input);
			tField.setText(result);
		}
		if(input.equals("="))
		{
			count=2;
			setOperation(input);
			tField.setText(result);
			op1=result;
			count2=0;
		}
		
	}
	
	String setNumber(String number)
	{

		if(count2==0)
		{
			totalNumber=Integer.toString(Integer.parseInt(totalNumber)*10+Integer.parseInt(number));
		}
		else
			{
			totalNumber=Double.toString(Double.parseDouble(totalNumber)+(Double.parseDouble(number)*Math.pow(0.1, count2)));
			count2++;
			}
		
		return totalNumber;
	}
	
   void setOperation(String operation)
   {
		
		if(count!=2)
		{
		op1=totalNumber;
		count++;
		totalNumber="0";
		count2=0;
		count++;
		}
		
		else if(count==2)
		{
			op2=totalNumber;
			if(operation2.equals("*"))
			  {
			   result=Double.toString(Double.parseDouble(op1)*Double.parseDouble(op2));	
			   op1=result;
			  }
			else if(operation2.equals("+"))
			   {
			   result=Double.toString(Double.parseDouble(op1)+Double.parseDouble(op2));
			   op1=result;
				}
			else if(operation2.equals("/"))
				{
			   result=Double.toString(Double.parseDouble(op1)/Double.parseDouble(op2));
			   op1=result;
			   }
			else if(operation2.equals("-"))
		     { 
			   result=Double.toString(Double.parseDouble(op1)-Double.parseDouble(op2));
			   op1=result;
			}
			totalNumber="0";
			
		}
		operation2=operation;
	}
	

}
