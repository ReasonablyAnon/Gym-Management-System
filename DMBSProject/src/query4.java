
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class query4
{
	public static void create()
	{
		JFrame frame = new JFrame();
		String[] columns = {"Name"};
		Object[][] data = new Object[10][1];
		
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/finalbase","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select staff_name from staff where salary>20000 and work_duration>3;");
			int i = 0;
			while(res.next()) 
			{
				String inp2 = res.getString("staff_name");;
				data[i][0] = inp2;
				i++;
				System.out.println(res.getString("staff_name"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	    
		JTable table = new JTable(data, columns);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	 
	    JLabel lblHeading = new JLabel("Staff Name with Salary > 20000 && Work Hours > 3 hours/week - (SIMPLE) ");
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
