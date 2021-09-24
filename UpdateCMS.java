package hello;
import java.sql.*;
import java.util.Scanner;

public class UpdateCMS 
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
			System.out.println("Press 1: To Update customer information ");
			System.out.println("Press 2: To Update vendor information ");
			System.out.println("Press 3: To Update order information ");
			System.out.println("Press 4: To update Food Items information ");
			System.out.println("Press 5: To Update login information ");
			System.out.println("Press 6: To Exit ");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );
			//System.out.println("     ");
			Scanner sc= new Scanner(System.in);
			int n=sc.nextInt();
			
	switch(n) 
			{
		case 1:
			System.out.println("     "); 
			System.out.println("Press 1: To Update customer ID ");
			System.out.println("Press 2: To Update customer name ");
			System.out.println("Press 3: To Update customer phone ");
			System.out.println("Press 4: To update custoer email");
			System.out.println("Press 5: To Move back");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );

			int c1=sc.nextInt();
			
			switch(c1)
				{
			case 1:
				System.out.println("Enter Customer ID");
				String cid= sc.next();
				System.out.println("Enter New customer ID");
				String ncid= sc.next();
				
				 int a1=stmt.executeUpdate("update customer set customer_id='"+ncid+"' where customer_id='"+cid+"'");
				 System.out.println(a1+"Record updated...!!");
				 System.out.println("     ");
				  
				  ResultSet rs1=stmt.executeQuery("Select * from customer where customer_id='"+ncid+"'");
				  
				  while(rs1.next()) 
				  {
				  System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getInt(3)+" "
				  +rs1.getString(4)+" | "+rs1.getString(5)+" | "+rs1.getFloat(6)); 
				  }
				  System.out.println("     ");
				  
				  break;
				  
			 case 2:
				 
				    System.out.println("Enter Customer ID");
					String cid1= sc.next();
					System.out.println("Enter New customer name");
					String ncname= sc.next();
					
					 int a2=stmt.executeUpdate("update customer set customer_name='"+ncname+"' where customer_id='"+cid1+"'");
					 System.out.println(a2+"Record updated...!!");
					 System.out.println("     ");
					  
					  ResultSet rs2=stmt.executeQuery("Select * from customer where customer_id='"+cid1+"'");
					  
					  while(rs2.next()) 
					  {
					  System.out.println(rs2.getString(1)+" | "+rs2.getString(2)+" | "+rs2.getInt(3)+" "
					  +rs2.getString(4)+" | "+rs2.getString(5)+" | "+rs2.getFloat(6)); 
					  }
					  System.out.println("     ");
					  
					  break;
				 
			 case 3:
				   System.out.println("Enter Customer ID");
					String cid2= sc.next();
					System.out.println("Enter New customer phone no");
					int ncphn= sc.nextInt();
					
					 int a3=stmt.executeUpdate("update customer set customer_phone='"+ncphn+"' where customer_id='"+cid2+"'");
					 System.out.println(a3+"Record updated...!!");
					 System.out.println("     ");
					  
					  ResultSet rs3=stmt.executeQuery("Select * from customer where customer_id='"+cid2+"'");
					  
					  while(rs3.next()) 
					  {
					  System.out.println(rs3.getString(1)+" | "+rs3.getString(2)+" | "+rs3.getInt(3)+" "
					  +rs3.getString(4)+" | "+rs3.getString(5)+" | "+rs3.getFloat(6)); 
					  }
					  System.out.println("     ");
					  break;
					  
			 case 4:
				   System.out.println("Enter Customer ID");
					String cid3= sc.next();
					System.out.println("Enter New customer email");
					String ncemail= sc.next();
					
					 int a4=stmt.executeUpdate("update customer set customer_email='"+ncemail+"' where customer_id='"+cid3+"'");
					 System.out.println(a4+"Record updated...!!");
					 System.out.println("     ");
					  
					  ResultSet rs4=stmt.executeQuery("Select * from customer where customer_id='"+cid3+"'");
					  
					  while(rs4.next()) 
					  {
					  System.out.println(rs4.getString(1)+" | "+rs4.getString(2)+" | "+rs4.getInt(3)+" "
					  +rs4.getString(4)+" | "+rs4.getString(5)+" | "+rs4.getFloat(6)); 
					  }
					  System.out.println("     ");
					  
					  break;
					  
			  case 5:
				 	break;
				 }
			
			  break;
			  
			  // case 2 of main menu
			
		case 2:
			System.out.println("     "); 
			System.out.println("Press 1: To Update Vendor ID ");
			System.out.println("Press 2: To Update Vendor name ");
			System.out.println("Press 3: To Update Vendor phone ");
			System.out.println("Press 4: To update Vendor Speciality");
			System.out.println("Press 5: To Move back");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );

			int c2=sc.nextInt();
			
			switch(c2)
				{
			case 1:
				
				System.out.println("Enter Vendor ID");
				String vid= sc.next();
				System.out.println("Enter New Vendor ID");
				String nvid= sc.next();
				
				 int a1=stmt.executeUpdate("update vendor set vendor_id='"+nvid+"' where vendor_id='"+vid+"'");
				 System.out.println(a1+"Record updated...!!");
				 System.out.println("     ");
				  
				  ResultSet rs1=stmt.executeQuery("Select * from vendor where vendor_id='"+nvid+"'");
				  while(rs1.next()) 
				  {
				System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getInt(3)+" | "
							  +rs1.getString(4)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 2:
				 System.out.println("Enter Vendor ID");
					String vid1= sc.next();
					System.out.println("Enter New vendor name");
					String nvname= sc.next();
					
					 int a2=stmt.executeUpdate("update vendor set vendor_name='"+nvname+"' where vendor_id='"+vid1+"'");
					 System.out.println(a2+"Record updated...!!");
					 System.out.println("     ");
					  
					  ResultSet rs2=stmt.executeQuery("Select * from vendor where vendor_id='"+vid1+"'");
					  
					  while(rs2.next()) 
					  {
						  System.out.println(rs2.getString(1)+" | "+rs2.getString(2)+" | "+rs2.getInt(3)+" | "
								  +rs2.getString(4)); 
					  }
					  System.out.println("     ");
					  
					  break;
					  
			case 3:
				System.out.println("Enter Vendor ID");
				String vid2= sc.next();
				System.out.println("Enter New vendor phone");
				int nvphn= sc.nextInt();
				
				 int a3=stmt.executeUpdate("update vendor set vendor_phone='"+nvphn+"' where vendor_id='"+vid2+"'");
				 System.out.println(a3+"Record updated...!!");
				 System.out.println("     ");
				  
				  ResultSet rs3=stmt.executeQuery("Select * from vendor where vendor_id='"+vid2+"'");
				  
				  while(rs3.next()) 
				  {
					  System.out.println(rs3.getString(1)+" | "+rs3.getString(2)+" | "+rs3.getInt(3)+" | "
							  +rs3.getString(4)); 
				  }
				  System.out.println("     ");
				  	 break;
				  
			case 4:
				System.out.println("Enter Vendor ID");
				String vid3= sc.next();
				System.out.println("Enter New vendor speciality");
				String nvspecs= sc.next();
				
				 int a4=stmt.executeUpdate("update vendor set vendor_specs='"+nvspecs+"' where vendor_id='"+vid3+"'");
				 System.out.println(a4+"Record updated...!!");
				 System.out.println("     ");
				  
				  ResultSet rs4=stmt.executeQuery("Select * from vendor where vendor_id='"+vid3+"'");
				  
				  while(rs4.next()) 
				  {
					  System.out.println(rs4.getString(1)+" | "+rs4.getString(2)+" | "+rs4.getInt(3)+" | "
							  +rs4.getString(4)); 
				  }
				  System.out.println("     ");
				  	 break;
				  	 
			  case 5:
				  break;
			 		
			
				 }
			break;
			
			//case 3 of main menu
			
		case 3:
				
			System.out.println("     "); 
			System.out.println("Press 1: To Update quantity ");
			System.out.println("Press 2: To Update estimated time ");
			System.out.println("Press 3: To Update date and time ");
			System.out.println("Press 4: To update order price");
			System.out.println("Press 5: To update order status");
			System.out.println("Press 6: To Move back");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );

			int c3=sc.nextInt();
				
			switch(c3) 
				{
			case 1:
				System.out.println("Enter Order no");
				int ord_no= sc.nextInt();
				System.out.println("Enter New quantity");
				int nqty= sc.nextInt();
				
				 int a1=stmt.executeUpdate("update order_details set quantity='"+nqty+"' where order_no='"+ord_no+"'");
				 System.out.println(a1+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs1=stmt.executeQuery("Select * from order_details where order_no='"+ord_no+"'");
				  
				  while(rs1.next()) 
				  {
				  System.out.println(rs1.getInt(1)+" | "+rs1.getString(2)+" | "+rs1.getString(3)+" | "
				  +rs1.getString(4)+" | "+rs1.getInt(5)+" | "+rs1.getString(6)+" | "+rs1.getString(7)+" | "+rs1.getFloat(8)+" | "+rs1.getString(9)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 2:
				System.out.println("Enter Order no");
				int ord_no1= sc.nextInt();
				System.out.println("Enter New estimated time");
				String neta= sc.next();
				
				 int a2=stmt.executeUpdate("update order_details set eta='"+neta+"' where order_no='"+ord_no1+"'");
				 System.out.println(a2+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs2=stmt.executeQuery("Select * from order_details where order_no='"+ord_no1+"'");
				  
				  while(rs2.next()) 
				  {
				  System.out.println(rs2.getInt(1)+" | "+rs2.getString(2)+" | "+rs2.getString(3)+" | "
				  +rs2.getString(4)+" | "+rs2.getInt(5)+" | "+rs2.getString(6)+" | "+rs2.getString(7)+" | "+rs2.getFloat(8)+" | "+rs2.getString(9)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 3:
				System.out.println("Enter Order no");
				int ord_no2= sc.nextInt();
				System.out.println("Enter New date and time");
				String ndt= sc.next();
				
				 int a3=stmt.executeUpdate("update order_details set date_time='"+ndt+"' where order_no='"+ord_no2+"'");
				 System.out.println(a3+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs3=stmt.executeQuery("Select * from order_details where order_no='"+ord_no2+"'");
				  
				  while(rs3.next()) 
				  {
				  System.out.println(rs3.getInt(1)+" | "+rs3.getString(2)+" | "+rs3.getString(3)+" | "
				  +rs3.getString(4)+" | "+rs3.getInt(5)+" | "+rs3.getString(6)+" | "+rs3.getString(7)+" | "+rs3.getFloat(8)+" | "+rs3.getString(9)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 4:
				System.out.println("Enter Order no");
				int ord_no3= sc.nextInt();
				System.out.println("Enter New order price");
				float nprice= sc.nextFloat();
				
				 int a4=stmt.executeUpdate("update order_details set order_value='"+nprice+"' where order_no='"+ord_no3+"'");
				 System.out.println(a4+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs4=stmt.executeQuery("Select * from order_details where order_no='"+ord_no3+"'");
				  
				  while(rs4.next()) 
				  {
				  System.out.println(rs4.getInt(1)+" | "+rs4.getString(2)+" | "+rs4.getString(3)+" | "
				  +rs4.getString(4)+" | "+rs4.getInt(5)+" | "+rs4.getString(6)+" | "+rs4.getString(7)+" | "+rs4.getFloat(8)+" | "+rs4.getString(9)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 5:
				System.out.println("Enter Order no");
				int ord_no4= sc.nextInt();
				System.out.println("Enter New order status");
				String nstatus= sc.next();
				
				 int a5=stmt.executeUpdate("update order_details set order_status='"+nstatus+"' where order_no='"+ord_no4+"'");
				 System.out.println(a5+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs5=stmt.executeQuery("Select * from order_details where order_no='"+ord_no4+"'");
				  
				  while(rs5.next()) 
				  {
				  System.out.println(rs5.getInt(1)+" | "+rs5.getString(2)+" | "+rs5.getString(3)+" | "
				  +rs5.getString(4)+" | "+rs5.getInt(5)+" | "+rs5.getString(6)+" | "+rs5.getString(7)+" | "+rs5.getFloat(8)+" | "+rs5.getString(9)); 
				  }
				  System.out.println("     ");
				  break;
				  
			case 6:
					break;
				}
			break;
			
			//case 4 of main menu
		case 4:
			System.out.println("     "); 
			System.out.println("Press 1: To Update Food ID ");
			System.out.println("Press 2: To Update Food name ");
			System.out.println("Press 3: To Update Food price ");
			System.out.println("Press 4: To Update Vendor ID ");
			System.out.println("Press 5: To Move back ");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );

			int c4=sc.nextInt();
			
			switch(c4)
				{
			case 1:
				System.out.println("Enter Food ID");
				String fid= sc.next();
				System.out.println("Enter New Food ID");
				String nfid= sc.next();
				
				 int a1=stmt.executeUpdate("update fooditem set food_id='"+nfid+"' where food_id='"+fid+"'");
				 System.out.println(a1+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs1=stmt.executeQuery("Select * from fooditem where food_id='"+nfid+"'");
				  
				  while(rs1.next()) 
				  {
				  System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getFloat(3)); 
				  }
				System.out.println("     ");
				break;
				
			case 2:
				System.out.println("Enter Food ID");
				String fid1= sc.next();
				System.out.println("Enter New Food name");
				String nfname= sc.next();
				
				 int a2=stmt.executeUpdate("update fooditem set food_name='"+nfname+"' where food_id='"+fid1+"'");
				 System.out.println(a2+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs2=stmt.executeQuery("Select * from fooditem where food_id='"+fid1+"'");
				  
				  while(rs2.next()) 
				  {
				  System.out.println(rs2.getString(1)+" | "+rs2.getString(2)+" | "+rs2.getFloat(3)); 
				  }
				System.out.println("     ");
				break;
				
			case 3:
				System.out.println("Enter Food ID");
				String fid2= sc.next();
				System.out.println("Enter New Food price");
				float nfprice= sc.nextFloat();
				
				 int a3=stmt.executeUpdate("update fooditem set food_price='"+nfprice+"' where food_id='"+fid2+"'");
				 System.out.println(a3+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs3=stmt.executeQuery("Select * from fooditem where food_id='"+fid2+"'");
				  
				  while(rs3.next()) 
				  {
				  System.out.println(rs3.getString(1)+" | "+rs3.getString(2)+" | "+rs3.getFloat(3)); 
				  }
				System.out.println("     ");
					break;
			case 4:
				System.out.println("Enter Food ID");
				String fid4= sc.next();
				System.out.println("Enter new vendor ID");
				String nvid= sc.next();
				
				 int a5=stmt.executeUpdate("update fooditem set vendor_id='"+nvid+"' where food_id='"+fid4+"'");
				 System.out.println(a5+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs5=stmt.executeQuery("Select * from fooditem where food_id='"+fid4+"'");
				  
				  while(rs5.next()) 
				  {
				  System.out.println(rs5.getString(1)+" | "+rs5.getString(2)+" | "+rs5.getFloat(3)+" | "+rs5.getString(4)); 
				  }
				System.out.println("     ");
					break;
				
					
			case 5:
				break;
				
				}	
			break;
			
			//case 5 of main menu
			
		case 5:
			System.out.println("     "); 
			System.out.println("Press 1: To change password");
			System.out.println("Press 1: To move back");
			System.out.println("-----------------------------");
			System.out.println("Enter Your choice..." );

			int c5=sc.nextInt();
			
			switch(c5)
				{
			case 1:
				System.out.println("Enter Customer ID");
				String cid= sc.next();
				System.out.println("Enter New password");
				String npass= sc.next();
				
				 int a1=stmt.executeUpdate("update login set password='"+npass+"' where customer_id='"+cid+"'");
				 System.out.println(a1+"Record updated...!!");
				 System.out.println("     ");
				 ResultSet rs1=stmt.executeQuery("Select * from login where customer_id='"+cid+"'");
				  while(rs1.next()) 
				  {
				  System.out.println(rs1.getString(1)+" | "+rs1.getString(2)); 
				  }
				System.out.println("     ");
				break;
				
			case 2:
				break;
				
				}
			break;
			
			//case 6 of main menu
			
		case 6:
			System.out.println("Thank you for using CMS...Have a nice day");
			System.exit(1);
			
			}
		}	
	}
}
		
