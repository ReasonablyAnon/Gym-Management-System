
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query8
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Brand Name","Average Price"};
		Object[][] data = new Object[10][2];
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select brand_name,avg(price) from equipment group by brand_name");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getString("brand_name");
				data[i][1] = res.getDouble("avg(price)");
				i++;
				System.out.println(res.getString("brand_name")+" "+res.getDouble("avg(price)"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display Brand Names with average prices of their equipment - (COMPLEX) ");
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
