
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query1 
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Customer ID", "Name", "Address", "Age","Trainer ID"};
		Object[][] data = new Object[10][5];
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from customer");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getInt("customer_id");
				data[i][1] = res.getString("customer_name");
				data[i][2] = res.getString("address");
				data[i][3] = res.getInt("age");
				data[i][4] = res.getInt("staff_id");
				i++;
				System.out.println(res.getInt("customer_id")+" "+res.getString("customer_name")+" "+res.getString("address")+" "+res.getInt("age")+" "+res.getInt("staff_id"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display All Customer Info - (SIMPLE)");
	    lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,30));
	    
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
	    frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
	    frame.setSize(600, 300);
	    frame.setVisible(true);
	}
	
/*	public static void main( String[] args )
	{
		create();
	}*/
}


/*
 * REFERECNES :-
 * http://www.zentut.com/java-swing/how-to-use-jtable-to-display-data/
 * 
 *
 */
