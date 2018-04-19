
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class query13add 
{
	static JFrame mainbox;
	static JTextField nameinp;
	static JTextField ageinp;
	static JTextField addressinp;
	static JTextField planinp;
	
	static int customerno = 9;
	static String dname = "";
	static int dage = 0;
	static String daddress = "";
	static int trainerid = 0;
	static String dplan = "";
	
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(620,500);
		
		nameinp = new JTextField();
		ageinp = new JTextField();
		addressinp = new JTextField();
		planinp = new JTextField();
		
		JLabel main = new JLabel("Add Customer");
		main.setBounds(207, 5, 250, 25);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,35));
		
		JLabel name = new JLabel("Enter Your Name");
		name.setBounds(120, 35, 400,20);
		nameinp.setBounds(120, 55, 370,30);
		
		JLabel age = new JLabel("Enter Your Age");
		age.setBounds(120, 100, 400,20);
		ageinp.setBounds(120, 120 , 370,30);
		
		JLabel address = new JLabel("Enter Your Address");
		address.setBounds(120, 165, 400,20);
		addressinp.setBounds(120, 185 , 370,30);
		
		JLabel plan = new JLabel("Enter Your Plan ( Regular/VIP ) ");
		plan.setBounds(120, 230, 400,20);
		planinp.setBounds(120, 250 , 370,30);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(220, 310, 160,35);
		submit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty() || (ageinp.getText().isEmpty()) 
						|| (addressinp.getText().isEmpty()) || (planinp.getText().isEmpty()) )
				{
						JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					dname = nameinp.getText();
					dage = Integer.parseInt(ageinp.getText());
					daddress = addressinp.getText();
					dplan = planinp.getText();
					JOptionPane.showMessageDialog(null, "Data Submitted");
					nameinp.setText("");
					ageinp.setText("");
					addressinp.setText("");
					planinp.setText("");
					try
					{
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
						Statement stat=conn.createStatement();
						//ResultSet res=stat.executeQuery("insert into customer values(customerno,'dname',dage,'daddress','7');");
						//ResultSet res2 = stat.executeQuery("insert into membershipplan values('dplan',10,customerno);");
						//stat.execute("insert into customer values(9,'vipul',20,'Nehru Place',7)");
						customerno++;
						System.out.println(customerno);
						System.out.println(dname+"  "+dage+"  "+daddress+"  "+dplan);
						stat.execute("insert into customer values("+customerno+","+"'"+dname+"'"+","+dage+","+"'"+daddress+"'"+","+trainerid+");");
						stat.execute("insert into membershipplan values('"+dplan+"'"+","+10+","+customerno+");");
						//boolean res=stat.execute("insert into customer values("+customerno+","+"'"+dname+"'"+","+dage+","+"'"+daddress+"'"+","+trainerid+");\"");
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
		});
	
		mainbox.add(main);
		mainbox.add(name);
		mainbox.add(nameinp);
		mainbox.add(age);
		mainbox.add(ageinp);
		mainbox.add(address);
		mainbox.add(addressinp);
		mainbox.add(plan);
		mainbox.add(planinp);
		mainbox.add(submit);
		
		mainbox.setLayout(null);
		mainbox.setVisible(true);
	}

/*	public static void main( String[] args )
	{
		create();
	}*/
}

//REFERENCES:_
//https://examples.javacodegeeks.com/desktop-java/swing/java-swing-form-example/