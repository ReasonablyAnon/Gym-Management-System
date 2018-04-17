
import java.sql.*;
public class Driver {

	public static void main(String[] args) 
	{
		try
		{
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gymmm","ashwat","passwordchahiye");
			Statement stat=conn.createStatement();
			ResultSet res=stat.executeQuery("select * from customer");
			while(res.next()) 
			{
				System.out.println(res.getInt("customer_id")+" "+res.getString("customer_name")+" "+res.getString("address")+" "+res.getInt("age"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
