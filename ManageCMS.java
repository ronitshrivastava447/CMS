package hello;
import java.sql.*;
import java.util.Random;   
import java.util.Scanner;
import java.lang.Math;   

public class ManageCMS 
{
	 static float wallet=0;
	 static float value=0;
	public static int menu(String s1,float w) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","ronit005");
		Statement stmt=con.createStatement();
		 
		while(true)
		{
		
		System.out.println("--------Welcome to Canteen Managemnet System-------");
		System.out.println("     ");
		System.out.println("CUSTOMER ID:"+" "+ s1);
		System.out.println("     ");
		System.out.println("Press 1: To Show Menu ");
		System.out.println("Press 2: To place order ");
		System.out.println("Press 3: To order history ");
		System.out.println("Press 4: To check wallet balance ");
		System.out.println("Press 5: To add wallet balance ");
		System.out.println("Press 6: To Rate the order ");
		
		System.out.println("Press 7: To Exit ");
		System.out.println("-----------------------------");
		System.out.println("Enter Your choice..." );
		System.out.println("     ");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		switch (n) {
		
		case 1:
			System.out.println("------Menu Card--------");
			ResultSet rs1=stmt.executeQuery("Select * from fooditem");
			  
			  while(rs1.next()) 
			  {
			  System.out.println(rs1.getString(1)+" | "+rs1.getString(2)+" | "+rs1.getFloat(3)+" | "+rs1.getString(4)); 
			  }
			System.out.println("     ");
			break;
			
		case 2:
			
			System.out.println("------Menu Card--------");
			ResultSet rs3=stmt.executeQuery("Select * from fooditem");
			  
			  while(rs3.next()) 
			  {
			  System.out.println(rs3.getString(1)+" | "+rs3.getString(2)+" | "+rs3.getFloat(3)+" | "+rs3.getString(4)); 
			  }
			System.out.println("     ");
			
			int min = 402;  
			int max = 499;  
			//Random random = new Random();   
			//System.out.println("Enter Order no.");
			int ord_no= (int)Math.random()*(max-min+1)+min; 
			System.out.println("Enter Vendor ID");
			String vo_id= sc.next();
			System.out.println("Enter Customer ID");
			String co_id= sc.next();
			System.out.println("Enter Food ID");
			String fo_id= sc.next();
			System.out.println("Enter Quantity");
			int qty= sc.nextInt();
			//.out.println("Enter ETA");
			String eta= "11:22 IST";
			//System.out.println("Enter Date of order");
			String date= "21-Aug-2021";
			//System.out.println("Enter Order Value");
			String c1="food101";
			String c2="food102";
			String c3="food103";
			String c4="food104";
			String c5="food105";
			//float value=0;
			if(fo_id.equals(c1)  )
				value= 270f * qty;
			if(fo_id.equals(c2)  )
				value= 278f *qty;
			if(fo_id.equals(c3)  )
				value= 170f *qty;
			if(fo_id.equals(c4)  )
				value= 210f *qty;
			if(fo_id.equals(c5)  )
				value= 250f *qty;
			
			//System.out.println("Enter Order Status");
			String status= "Successful";
			
			
			 int c=stmt.executeUpdate("insert into order_details values('"+ord_no+"','"+vo_id+"','"+co_id+"','"+fo_id+"','"+qty+"','"+eta+"','"+date+"','"+value+"','"+status+"')");
			 System.out.println(c+" Record inserted....");
			 System.out.println("        ");
			 System.out.println(" Order Placed successfully....Enjoy your meal!!!!");
			 System.out.println("        ");
			 break;
			 
				
		case 3:
			System.out.println("CUSTOMER ID:"+" "+ s1);
			 ResultSet rs2=stmt.executeQuery("Select * from order_details where customer_id='"+s1+"'");
			  
			  while(rs2.next()) 
			  {
			  System.out.println(rs2.getInt(1)+" | "+rs2.getString(2)+" | "+rs2.getString(3)+" | "
			  +rs2.getString(4)+" | "+rs2.getInt(5)+" | "+rs2.getString(6)+" | "+rs2.getString(7)+" | "+rs2.getFloat(8)+" | "+rs2.getString(9)); 
			  }
			  System.out.println("     ");
			  
			 	break;
		case 4:
			System.out.println("CUSTOMER ID:"+" "+ s1);
			 System.out.println( "Wallet Balance is.. "+" "+(w-value));
//			 ResultSet rs4=stmt.executeQuery("Select customer_wallet from customer where customer_id='"+s1+"'");
//			 while(rs4.next()) 
//			  {
//			  System.out.println( "Wallet Balance is.. "+" "+rs4.getFloat(1)); 
//			  }
			 break;
			 
		case 5:
			System.out.println("Enter Customer ID");
			String cid= sc.next();
			System.out.println("Enter wallet Amount");
			float wall= sc.nextFloat();
			//wall+=(w-value);
			 int a1=stmt.executeUpdate("update customer set customer_wallet='"+wall+"' where customer_id='"+cid+"'");
			 System.out.println(a1+"Record updated...!!");
			 System.out.println("Wallet updated.....");
			 ResultSet rs4=stmt.executeQuery("Select customer_wallet from customer where customer_id='"+s1+"'");
			 while(rs4.next()) 
			  {
			  System.out.println( "Wallet Balance is.. "+" "+rs4.getFloat(1)); 
			  }
			 break;
			 
		case 6:
			System.out.println("Enter Customer ID");
			String cid1= sc.next();
			System.out.println("Enter Food Id");
			String fid= sc.next();
			System.out.println("Enter Rating in (*)");
			String rate= sc.next();

			int b=stmt.executeUpdate("insert into rating values('"+cid1+"','"+fid+"','"+rate+"')");
			System.out.println(b+" Record inserted..");  
			
			ResultSet rs5=stmt.executeQuery("Select * from rating where customer_id='"+cid1+"'");
			while(rs5.next())
			{
			 System.out.println(rs5.getString(1)+" | "+rs5.getString(2)+" | "+rs5.getString(3));
			}
			 break;
			 
		case 7:
			System.out.println("Thank you for using CMS...Have a nice day");
			System.exit(1);
			
			}
		}
	}

	public static void main(String args[]) throws Exception
	{

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","ronit005");
		Statement stmt=con.createStatement();
	

	while(true)
	{
	
		Scanner sc =new Scanner(System.in);
		System.out.println("--------Welcome to Canteen Managemnet System-------");
		System.out.println("     ");
		System.out.println("Press 1: To Login ");
		System.out.println("Press 2: To Register ");
		System.out.println("Press 3: To exit ");
		System.out.println("-----------------------------");
		System.out.println("Enter Your choice..." );
		System.out.println("     ");
		//Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		switch(n)
		{
		case 1:
		System.out.println("Enter your Login ID..");
		String s1=sc.next();
		System.out.println("Enter your Login password..");
		String s2=sc.next();
		String s3="cus101";
		String s4="cus102";
		String s5="cus103";
		String s6="cus104";
		String s7="cus105";
		
		if(s1.equals(s3) || s1.equals(s4) || s1.equals(s5) || s1.equals(s6) || s1.equals(s7))
			{
				System.out.println("Login Successfull...");
				System.out.println("     ");
				menu(s1,wallet);
				
			}
		else
			{
			System.out.println("Login Unsuccessfull...Please try again");
			System.out.println("     ");
			break;
			}
		case 2:
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
			 wallet= sc.nextFloat();
			
			 int a=stmt.executeUpdate("insert into customer values('"+cid+"','"+cname+"','"+cphone+"','"+email+"','"+coupon+"','"+wallet+"')");
			 System.out.println(a+" Record inserted..");
			 System.out.println(a+" Registered Successfully..");
			  System.out.println("     ");
			  break;
			
		case 3:
			System.out.println("Thank you for visiting...");
			System.exit(1);
		
		}
	}
}
}