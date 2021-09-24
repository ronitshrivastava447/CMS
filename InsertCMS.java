package hello;
import java.sql.*;
import java.util.Scanner;
public class InsertCMS 
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
			System.out.println("Press 1: To add customer information ");
			System.out.println("Press 2: To add vendor information ");
			System.out.println("Press 3: To add order details information ");
			System.out.println("Press 4: To add Food Items information ");
			System.out.println("Press 5: To add login information ");
			System.out.println("Press 6: To Exit ");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );
			System.out.println("     ");
			Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();
			
			switch(n) 
			{
			
			case 1:
				
					System.out.println("Enter Customer ID");
					String cid= sc.next();
					System.out.println("Enter Customer Name");
					String cname= sc.next();
					System.out.println("Enter Customer Phone no.");
					int cphone= sc.nextInt();
					System.out.println("Enter Customer Email ID");
					String email= sc.next();
					System.out.println("Enter Customer Coupon");
					String coupon= sc.next();
					System.out.println("Enter Customer Wallet Amt");
					float wallet= sc.nextFloat();
					
					 int a=stmt.executeUpdate("insert into customer values('"+cid+"','"+cname+"','"+cphone+"','"+email+"','"+coupon+"','"+wallet+"')");
					 System.out.println(a+" Record inserted..");
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
					
				System.out.println("Enter Vendor ID");
				String vid= sc.next();
				System.out.println("Enter Vendor Name");
				String vname= sc.next();
				System.out.println("Enter Vendor Phone no.");
				int vphone= sc.nextInt();
				System.out.println("Enter vendor speciality");
				String specs= sc.next();
				
				int b=stmt.executeUpdate("insert into vendor values('"+vid+"','"+vname+"','"+vphone+"','"+specs+"')");
				System.out.println(b+" Record inserted..");
				
				ResultSet rs2=stmt.executeQuery("Select * from vendor");
				  
				  while(rs2.next()) 
				  {
				  System.out.println(rs2.getString(1)+" | "+rs2.getString(2)+" | "+rs2.getInt(3)+" | "
				  +rs2.getString(4)); 
				  }
				  System.out.println("     ");
					break;
			
			case 3:
				
				System.out.println("Enter Order no.");
				int ord_no= sc.nextInt();
				System.out.println("Enter Vendor ID");
				String vo_id= sc.next();
				System.out.println("Enter Customer ID");
				String co_id= sc.next();
				System.out.println("Enter Food ID");
				String fo_id= sc.next();
				System.out.println("Enter Quantity");
				int qty= sc.nextInt();
				System.out.println("Enter ETA");
				String eta= sc.next();
				System.out.println("Enter Date of order");
				String date= sc.next();
				System.out.println("Enter Order Value");
				float value= sc.nextFloat();
				System.out.println("Enter Order Status");
				String status= sc.next();
				
				
				 int c=stmt.executeUpdate("insert into order_details values('"+ord_no+"','"+vo_id+"','"+co_id+"','"+fo_id+"','"+qty+"','"+eta+"','"+date+"','"+value+"','"+status+"')");
				 System.out.println(c+" Record inserted....");
				 
				 ResultSet rs3=stmt.executeQuery("Select * from order_details");
				  
				  while(rs3.next()) 
				  {
				  System.out.println(rs3.getInt(1)+" | "+rs3.getString(2)+" | "+rs3.getString(3)+" | "
				  +rs3.getString(4)+" | "+rs3.getInt(5)+" | "+rs3.getString(6)+" | "+rs3.getString(7)+" | "+rs3.getFloat(8)+" | "+rs3.getString(9)); 
				  }
				  System.out.println("     ");
				  
				 	break;
				
			case 4:
				
				System.out.println("Enter Food ID");
				String fid= sc.next();
				System.out.println("Enter Food Name");
				String fname= sc.next();
				System.out.println("Enter Food price");
				float fprice= sc.nextFloat();
				System.out.println("Enter Vendor ID");
				String fvid= sc.next();
				
				int d=stmt.executeUpdate("insert into fooditem values('"+fid+"','"+fname+"','"+fprice+"','"+fvid+"')");
				System.out.println(d+" Record inserted..");
				
				ResultSet rs4=stmt.executeQuery("Select * from fooditem");
				  
				  while(rs4.next()) 
				  {
				  System.out.println(rs4.getString(1)+" | "+rs4.getString(2)+" | "+rs4.getFloat(3)+" | "+rs4.getString(4)); 
				  }
				System.out.println("     ");
				
					break;
			
			case 5:
				
				System.out.println("Enter Customer ID");
				String id= sc.next();
				System.out.println("Enter Password");
				String pass= sc.next();
				
				int e=stmt.executeUpdate("insert into login values('"+id+"','"+pass+"')");
				System.out.println(e+" Record inserted..");
				
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
