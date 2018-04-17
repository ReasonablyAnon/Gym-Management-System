import java.sql.*;
public class assignment4 {

	public static void main(String[] args) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","utkarsh","passMe");
//			Statement stat=conn.createStatement();
//			ResultSet res=stat.executeQuery("select * from customer");
//			while(res.next()) {
//				System.out.println(res.getInt("customer_id")+" "+res.getString("customer_name")+" "+res.getString("address")+" "+res.getInt("age"));
//			}
			ComplexAverageageperTrainer(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void allCustomers(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select * from customer");
		while(res.next()) {
			System.out.println(res.getInt("customer_id")+" "+res.getString("customer_name"));
		}
	}
	public static void CustomerswithSId(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select customer_name from customer where staff_id=7");
		while(res.next()) {
			System.out.println(res.getString("customer_name"));
		}
	}
	public static void allStaffWithtype(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select * from staff");
		while(res.next()) {
			System.out.println(res.getInt("staff_id")+" "+res.getString("staff_name"));
		}
	}
	public static void StaffwithSalaryDuration(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select staff_name from staff where salary>20000 and work_duration>3;");
		while(res.next()) {
			System.out.println(res.getString("staff_name"));
		}
	}
	public static void MembershipRegulrCId(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select customer_id from membershipPLan where mem_type='Regular'");
		while(res.next()) {
			System.out.println(res.getString("customer_id"));
		}
	}
	public static void brandPartsgreater(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select brand_name from brand where total_products>=3;");
		while(res.next()) {
			System.out.println(res.getString("brand_name"));
		}
	}
	public static void EquipmentPriceandClr(Connection conn) throws SQLException{
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select equipment_id from equipment where weight>30 and colour='red'");
		while(res.next()) {
			System.out.println(res.getInt("equipment_id"));
		}
	}
	public static void ComplexCustomerNameSuchthatMembershipIsVIP(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select distinct customer_name from customer INNER JOIN membershipplan ON customer.customer_id=membershipplan.customer_id where mem_type='VIP'");
		while(res.next()) {
			System.out.println(res.getString("customer_name"));
		}
	}
	public static void ComplexCustomerNameSuchthatStaffMemberSalary(Connection conn) throws SQLException {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select customer_name from customer INNER JOIN staff ON customer.staff_id=staff.staff_id where staff.salary>40000");
		while(res.next()) {
			System.out.println(res.getString("customer_name"));
		}
	}
	public static void ComplexAveragePriceperBrand(Connection conn) throws SQLException  {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select brand_name,avg(Price) from equipment group by brand_name");
		while(res.next()) {
			System.out.println(res.getString("brand_name")+" "+res.getDouble("avg(Price)"));
		}
	}
	public static void ComplexAverageageperTrainer(Connection conn) throws SQLException  {
		Statement st=conn.createStatement();
		ResultSet res=st.executeQuery("select staff_id,avg(age) from customer group by staff_id;");
		while(res.next()) {
			System.out.println(res.getInt("staff_id")+" "+res.getDouble("avg(age)"));
		}
	}
}	
