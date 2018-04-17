
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query6
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Customer Name"};
		Object[][] data = new Object[10][1];
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select distinct customer_name from customer INNER JOIN membershipplan ON customer.customer_id=membershipplan.customer_id where mem_type='VIP';");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getString("customer_name");
				i++;
				System.out.println(res.getString("customer_name"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display Customer Names whose Membership Plan is 'VIP' - (COMPLEX) ");
	    lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
	    
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
	    frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
	    frame.setSize(800, 300);
	    frame.setVisible(true);
	}
	
/*
	public static void main( String[] args )
	{
		create();
	}
*/
	
}


/*
 * REFERECNES :-
 * http://www.zentut.com/java-swing/how-to-use-jtable-to-display-data/
 * 
 *
 */
