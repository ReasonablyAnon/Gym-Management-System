
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query3 
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Staff ID", "Name", "Salary", "Work Duration","Staff Type"};
		Object[][] data = new Object[10][5];
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from staff");
			int i = 0;
			while(res.next()) 
			{
				data[i][0] = res.getInt("staff_id");
				data[i][1] = res.getString("staff_name");
				data[i][2] = res.getInt("salary");
				data[i][3] = res.getInt("work_duration");
				data[i][4] = res.getString("staff_type");
				i++;
				System.out.println(res.getInt("staff_id")+" "+res.getString("staff_name")+" "+res.getInt("salary")+" "+res.getInt("work_duration")+" "+res.getString("staff_type"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Display All Staff Info - (SIMPLE) ");
	    lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,20));
	    
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
	    frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
	    frame.setSize(600, 300);
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
