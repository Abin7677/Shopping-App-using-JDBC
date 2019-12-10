package Shopping_App;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;




public class agent {

	public void agentlogin() throws ClassNotFoundException, SQLException {
		
		Scanner s=new Scanner(System.in);
		Connection3 c3=new Connection3();
		c3.getConnection();
		int op = 0;
		  System.out.println("enter username");
		  String user=s.next();
	      System.out.println("enter password");
	   	  String pass=s.next();
	       
	        boolean cu = false;
	        String query = "SELECT * FROM agentlogin WHERE username =?";
	            PreparedStatement    ps = (PreparedStatement) c3.getConnection().prepareStatement(query);
	            ps.setString(1,user);
	            
	            ResultSet   rs = ps.executeQuery();
	            
	            if(rs.next())
	            {
	                cu = true;
	            }
	        
	         if(cu==true)
	        	 System.out.println("Successfully logged in");
	         else
	        	 System.out.println("User name or password does't exist");
		
		
	     do {
		System.out.println("Choose option\n1.)BuySell\n2.)View Product\n3.)Home Page");
		op=s.nextInt();
		switch(op)
		{
		case 1:
			Statement st1=(Statement) c3.getConnection().createStatement();
			ResultSet r=st1.executeQuery("select * from addproduct");
			System.out.println("********************");
			System.out.println("Enter the id");
			int a=s.nextInt();
			System.out.println("Enter the quantity");
			int n=s.nextInt();
			int q=0;
			int qu=0;
			int cost=0;
			while(r.next())
			{
				if(a==r.getInt(1))
				{
					cost=r.getInt(4);
					q=r.getInt(3);
				}
			}
			cost=cost*n;
			System.out.println(" Cost ="+cost);
			System.out.println("Enter 1 to confirm booking");
			int a1=s.nextInt();
			if(a1==1)
			{
				System.out.println("Your booking is confirmed");
				System.out.println("Thank you");
			}
			qu=q-n;
			PreparedStatement st2=(PreparedStatement) c3.getConnection().prepareStatement("update addproduct set quantity=? where id=?");
			st2.setInt(1,qu);
			st2.setInt(2,a);
			st2.executeUpdate();
			
			break;

		case 2:
			Statement st=(Statement) c3.getConnection().createStatement();
			ResultSet r1=st.executeQuery("select * from addproduct");
			System.out.println("********************");
			while(r1.next())
			{
				System.out.println(r1.getInt(1)+" "+r1.getString(2)+" "+r1.getInt(3)+" "+r1.getString(4));
			}
			System.out.println("********************");
			//c.getConnection().close();
			break;
		case 3:
			Shopping sh=new Shopping();
			sh.main(null);
			System.out.println("Agent Acoount Logout");
		}
	      
	         }while(op!=3);
		
	}

	
	
}