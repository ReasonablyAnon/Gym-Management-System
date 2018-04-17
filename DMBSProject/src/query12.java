
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query12
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Brand Name"};
		Object[][] data = new Object[10][1];
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select distinct brand.brand_name from brand INNER JOIN equipment ON brand.brand_name=equipment.brand_name where equipment.colour='red' and brand.total_products>3;");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getString("brand_name");
				i++;
				System.out.println(res.getString("brand_name"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display Brand Names whose equipment's color = 'RED' and has total products > 3 - (COMPLEX) ");
	    lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,18));
	    
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
