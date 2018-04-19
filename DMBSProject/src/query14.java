
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class query14 
{
	static JFrame mainbox;
	static JTextField nameinp;
	static JTextField ageinp;

	static int staffid = 0;
	static int salary = 0;
	
	public static void create()
	{
		mainbox = new JFrame();
		mainbox.setSize(620,500);
		
		nameinp = new JTextField();
		ageinp = new JTextField();

		JLabel main = new JLabel("Update Staff's Salary");
		main.setBounds(207, 5, 250, 25);
		main.setFont(new Font("Arial",Font.TRUETYPE_FONT,25));
		
		JLabel name = new JLabel("Enter Staff's ID");
		name.setBounds(120, 35, 400,20);
		nameinp.setBounds(120, 55, 370,30);
		
		JLabel age = new JLabel("Enter Staff's Updated Salary");
		age.setBounds(120, 100, 400,20);
		ageinp.setBounds(120, 120 , 370,30);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(220, 310, 160,35);
		submit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if( nameinp.getText().isEmpty() || (ageinp.getText().isEmpty()) )
				{
						JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					staffid = Integer.parseInt(nameinp.getText());
					salary = Integer.parseInt(ageinp.getText());

					JOptionPane.showMessageDialog(null, "Data Submitted");
					nameinp.setText("");
					ageinp.setText("");
					try
					{
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
						Statement stat=conn.createStatement();
						//ResultSet res=stat.executeQuery("insert into customer values(customerno,'dname',dage,'daddress','7');");
						//update brand set total_products=2 where brand_name = 'Decathlon';
						stat.execute("update staff set salary="+salary+" where staff_id = "+staffid);
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