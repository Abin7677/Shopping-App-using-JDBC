package Shopping_App;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;






public class Shopping {

		
		private static Connection NULL;
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Connection3 c3=new Connection3();
			c3.getConnection();
			
			
		Scanner s=new Scanner(System.in);
		int op,op1 = 0,op2 = 0;
		do
		{
		System.out.println("Choose option\n1)Admin Login\n2)Agent Login\n3)Exit");
		 op=s.nextInt();
		switch(op)
		{
		case 1:
		{
			admin ad=new admin();
			ad.adminlogin();
		}
		case  2:
		{
			
			agent ag=new agent();
			ag.agentlogin();
		}
		
		case 3:
			System.out.println("Proccess will be complete");
			return;
			

		}
		}while(op!=3);

		
	}

}
