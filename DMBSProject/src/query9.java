
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query9
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Staff ID","Average Age"};
		Object[][] data = new Object[10][2];
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select staff_id,avg(age) from customer group by staff_id;");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getInt("staff_id");
				data[i][1] = res.getDouble("avg(age)");
				i++;
				System.out.println(res.getInt("staff_id")+" "+res.getDouble("avg(age)"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display Staff IDs with average age of their customers - (COMPLEX) ");
	    lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
	    
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
