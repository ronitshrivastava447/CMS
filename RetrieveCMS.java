package hello;
import java.sql.*;
import java.util.Scanner;

public class RetrieveCMS 
{
	public static void main(String args[]) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","ronit005");
		Statement stmt=con.createStatement();
		
		while(true)
		{
			System.out.println("--------Welcome to CMS-------");
			System.out.println("     ");
			System.out.println("Press 1: To Show all customer information ");
			System.out.println("Press 2: To Search customer details");
			System.out.println("Press 3: To Show all vendor information ");
			System.out.println("Press 4: To Search vendor details ");
			System.out.println("Press 5: To Show all order details information ");
			System.out.println("Press 6: To Search order details  ");
			System.out.println("Press 7: To Show all Food Items information ");
			System.out.println("Press 8: To Search Food Items details ");
			System.out.println("Press 9: To Show all login information ");
			System.out.println("Press 10: To Search login details ");
			System.out.println("Press 11: To Exit ");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );
			System.out.println("     ");
			Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();
			
			switch(n) {
			
			case 1:
				
				 ResultSet rs1=stmt.executeQuery("Select * from customer");
				  
				  while(rs1.next()) 
				  {
				  System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getInt(3)+" "
				  +rs1.getString(4)+" | "+rs1.getString(5)+" | "+rs1.getFloat(6)); 
				  }
				  System.out.println("     ");
				 
				 break;
				 
			case 2:
				
				System.out.println("Enter the Customer ID to search");
				String cid=sc.next();
				ResultSet rs2=stmt.executeQuery("Select * from customer where customer_id='"+cid+"' ");
				  
				  while(rs2.next()) 
				  {
				  System.out.println(rs2.getString(1)+" | "+rs2.getString(2)+" | "+rs2.getInt(3)+" "
				  +rs2.getString(4)+" | "+rs2.getString(5)+" | "+rs2.getFloat(6)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 3:	  
				  
				 ResultSet rs3=stmt.executeQuery("Select * from vendor");
				  
				  while(rs3.next()) 
				  {
				System.out.println(rs3.getString(1)+" | "+rs3.getString(2)+" | "+rs3.getInt(3)+" | "
							  +rs3.getString(4)); 
				  }
				  System.out.println("     ");
				  break;
			
			case 4:
				

				System.out.println("Enter the Vendor ID to search");
				String vid=sc.next();
				ResultSet rs4=stmt.executeQuery("Select * from vendor where vendor_id='"+vid+"' ");
				while(rs4.next()) 
				  {
				System.out.println(rs4.getString(1)+" | "+rs4.getString(2)+" | "+rs4.getInt(3)+" | "
							  +rs4.getString(4)); 
				  }
				  System.out.println("     ");
				  break;
			
			case 5:
				
				ResultSet rs5=stmt.executeQuery("Select * from order_details");
				  
				  while(rs5.next()) 
				  {
				  System.out.println(rs5.getInt(1)+" | "+rs5.getString(2)+" | "+rs5.getString(3)+" | "
				  +rs5.getString(4)+" | "+rs5.getInt(5)+" | "+rs5.getString(6)+" | "+rs5.getString(7)+" | "+rs5.getFloat(8)+" | "+rs5.getString(9)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 6:
				

				System.out.println("Enter the order no to search");
				String ord_no=sc.next();
				ResultSet rs6=stmt.executeQuery("Select * from order_details where order_no='"+ord_no+"' ");
				
				while(rs6.next()) 
				  {
				  System.out.println(rs6.getInt(1)+" | "+rs6.getString(2)+" | "+rs6.getString(3)+" | "
				  +rs6.getString(4)+" | "+rs6.getInt(5)+" | "+rs6.getString(6)+" | "+rs6.getString(7)+" | "+rs6.getFloat(8)+" | "+rs6.getString(9)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 7:
				
				ResultSet rs7=stmt.executeQuery("Select * from fooditem");
				  
				  while(rs7.next()) 
				  {
				  System.out.println(rs7.getString(1)+" | "+rs7.getString(2)+" | "+rs7.getFloat(3)); 
				  }
				System.out.println("     ");
				break;
				
			case 8:
				
				System.out.println("Enter the Food ID to search");
				String fid=sc.next();
				ResultSet rs8=stmt.executeQuery("Select * from fooditem where food_id='"+fid+"'");
				while(rs8.next()) 
				  {
				  System.out.println(rs8.getString(1)+" | "+rs8.getString(2)+" | "+rs8.getFloat(3)); 
				  }
				System.out.println("     ");
				break;
				
			case 9:
				
				ResultSet rs9=stmt.executeQuery("Select * from login");
				  while(rs9.next()) 
				  {
				  System.out.println(rs9.getString(1)+" | "+rs9.getString(2)); 
				  }
				System.out.println("     ");
				break;
				
			case 10:
				
				System.out.println("Enter the Customer ID to search login details");
				String c_id=sc.next();
				ResultSet rs10=stmt.executeQuery("Select * from login where customer_id='"+c_id+"'");
				  while(rs10.next()) 
				  {
				  System.out.println(rs10.getString(1)+" | "+rs10.getString(2)); 
				  }
				System.out.println("     ");
				break;
				
			case 11:
				
				System.out.println("Thank you for using CMS...Have a nice day");
				System.exit(1);
			}
		}
	}
}
