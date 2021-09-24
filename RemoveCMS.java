package hello;
import java.sql.*;
import java.util.Scanner;

public class RemoveCMS {
	

	public static void main(String args[]) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","ronit005");
		Statement stmt=con.createStatement();
		
		while(true)
		{
			System.out.println("--------Welcome to CMS-------");
			System.out.println("     ");
			System.out.println("Press 1: To Remove customer information ");
			System.out.println("Press 2: To Remove vendor information ");
			System.out.println("Press 3: To Remove order details information ");
			System.out.println("Press 4: To Remove Food Items information ");
			System.out.println("Press 5: To Remove login information ");
			System.out.println("Press 6: To Exit ");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );
			//System.out.println("     ");
			Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();
			
			switch(n) {
			
			case 1:
				
				 System.out.println("Enter the Customer ID to remove details");
				 String cid=sc.next();
				 int a=stmt.executeUpdate("delete from customer where customer_id='"+cid+"'");
				 System.out.println(a+" "+"Record deleted.....");
				  System.out.println("     ");
				  
				  ResultSet rs1=stmt.executeQuery("Select * from customer");
				  
				  while(rs1.next()) 
				  {
				  System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getInt(3)+" "
				  +rs1.getString(4)+" | "+rs1.getString(5)+" | "+rs1.getFloat(6)); 
				  }
				  System.out.println("     ");
				  
				  break;
				  
			case 2: 
			
			   System.out.println("Enter the vendor ID to remove details");
			   String vid=sc.next();
			   int b=stmt.executeUpdate("delete from vendor where vendor_id='"+vid+"'");
			   System.out.println(b+""+"Record deleted.....");
			   System.out.println("     ");
			   
			   ResultSet rs2=stmt.executeQuery("Select * from vendor");
				  
				  while(rs2.next()) 
				  {
					  System.out.println(rs2.getString(1)+" | "+rs2.getString(2)+" | "+rs2.getInt(3)+" | "
							  +rs2.getString(4)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 3:
				
				 System.out.println("Enter order no. to remove");
				   int ord_no=sc.nextInt();
				   int c=stmt.executeUpdate("delete from order_details where order_no='"+ord_no+"'");
				   System.out.println(c+""+"Record deleted.....");
				   System.out.println("     ");
				   
				   ResultSet rs3=stmt.executeQuery("Select * from order_details");
					  
					  while(rs3.next()) 
					  {
						  System.out.println(rs3.getInt(1)+" | "+rs3.getString(2)+" | "+rs3.getString(3)+" | "
								  +rs3.getString(4)+" | "+rs3.getInt(5)+" | "+rs3.getString(6)+" | "+rs3.getString(7)+" | "+rs3.getFloat(8)+" | "+rs3.getString(9));
					  }
					  System.out.println("     ");
					  break;
			case 4:
				
				System.out.println("Enter the Food ID to remove details");
				 String fid=sc.next();
				 int d=stmt.executeUpdate("delete from fooditem where food_id='"+fid+"'");
				 System.out.println(d+""+"Record deleted.....");
				  System.out.println("     ");
				  
				  ResultSet rs4=stmt.executeQuery("Select * from fooditem");
				  
				  while(rs4.next()) 
				  {
					  System.out.println(rs4.getString(1)+" | "+rs4.getString(2)+" | "+rs4.getFloat(3)); 
				  }
				  System.out.println("     ");
				  
				  break;
				  
			case 5:
				
				  System.out.println("Enter the Customer ID to remove details");
				  String c_id=sc.next();
				  int e=stmt.executeUpdate("delete from login where customer_id='"+c_id+"'");
				  System.out.println(e+""+"Record deleted.....");
				  System.out.println("     ");
				  
				  ResultSet rs5=stmt.executeQuery("Select * from login");
				  while(rs5.next()) 
				  {
				  System.out.println(rs5.getString(1)+" | "+rs5.getString(2)); 
				  }
				System.out.println("     ");
				break;
				
			case 6:
				System.out.println("Thank you for using CMS...Have a nice day");
				System.exit(1);
				  
			}

		}
	}
}