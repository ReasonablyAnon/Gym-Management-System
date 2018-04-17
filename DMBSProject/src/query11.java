
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query11
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Customer ID","Duration Left"};
		Object[][] data = new Object[10][2];
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select customer_id,duration_left from membershipPLan where mem_type='Regular';");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getInt("customer_id");
				data[i][1] = res.getInt("duration_left");
				System.out.println(res.getInt("customer_id")+" "+res.getInt("duration_left"));
				i++;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display Customer IDs whose Membership Plan is 'Regular' with Duration Left(in months) - (SIMPLE) ");
	    lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,17));
	    
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
	    frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
	    frame.setSize(800, 300);
	    frame.setVisible(true);
	}
	
	public static void main( String[] args )
	{
		create();
	}
	
}


/*
 * REFERECNES :-
 * http://www.zentut.com/java-swing/how-to-use-jtable-to-display-data/
 * 
 *
 */
