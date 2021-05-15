//package parking;

import java.sql.Connection;
import java.sql.*;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

public class Park {
	
	public static void main(String[] args) {
			Input p=new Park().new Input();
			Exit q=new Park().new Exit();
			Display r=new Park().new Display();
			
			
			int a=p.getchoice();
			switch(a)
			{
			case 1: p.Basic_input();
					p.design();
					p.insertintogrid();
			break;
			case 2: q.remove();
					
					
			break;
			case 3:r.displaylog();
			break;
			case 4:System.exit(0);
			break;
			
			}
		
			}

	public char[][] mat= new char[32][32];
	public char[][] vehicles= new char[32][32];
    String vehNo;
    String cellNo;
    String name;
    double bill;
	int choice;
	char type=' ';
    public LocalTime  enttime;
    public LocalTime exttime;
    int i=2;
	int j=2;
	int k=1;
	int count=0;
	char type01=' ';
	String location="C:\\Users\\ASUS\\eclipse-workspace\\parking\\src\\parking\\grid.txt";
	File file=new File(location);
		

		
	class Input {
		 Scanner sc = new Scanner(System.in);
		 char[][] vehicles= new char[32][32];
		 char[][] mat= new char[32][32];
		
		int getchoice()
		{
			
			while(true)
			{
			
				 System.out.println("*********************************************************************************************");
				  System.out.println("\n\n\n\t\t\t\tWelcome To Parking Management System\n\n\n");
				  System.out.println("********************************************************************************************");

			System.out.println("The following are the choices:\n"
					+ "1. Enter new vehicle\n"
					+ "2. Remove a vehicle\n"
					+ "3. Display logs\n"
					+ "4. Exit\n"
					+ "Enter your choice: ");
			try
			{
			   choice=sc.nextInt();
			   if(choice<=4&&choice>=1)
				  break;
			   else
				  throw new InputMismatchException();
			 }
			catch(InputMismatchException e)
			{
				System.out.print("\n\nEnter valid choice: \n");
				choice=sc.nextInt();
				
			}
			}
			return choice;
		}
			
		
		
		 void Basic_input()
		 {
						ResultSet rs1 = null;
						 try {
						 Scanner sc = new Scanner(System.in);
						 Scanner scan=new Scanner(System.in);
						 LocalTime enttime= LocalTime.now();
						 LocalDate date=LocalDate.now();
							 
									boolean isempty=false;
									if(i>=30&&j==26)
									  {
								          for(int i=2; i<=30; i+=4) {
								        	  for(int j=2; j<=28; j+=2)
								        	  {
								        		  if(vehicles[i][j]==' ')
								        		  {
								        			  System.out.println("\nEnter the vehicle type...'#' for car and '$' for two-wheeler.");
								        		 
								        		  while(true){
								        			  type01=scan.next().charAt(0);
								        			  
								        			    try{
								        	      
								        				    if(type01!='#'&&type01!='$')
								        					    throw new InputMismatchException();
								        				    else
								        				      break;
								        		      }
								        				  catch(InputMismatchException e){
								        					System.out.println("\nEnter valid choice.");
								        				 }
								        			  } 
								        		 this.vehicles[i][j]=type01;
								        		  isempty=true;
								        		  System.out.print("Enter name: ");
													scan.nextLine();
													System.out.print("");
													String name=scan.nextLine();
													 String vehNo;
													while(true){
													System.out.print("Enter Vehicle number (Example: GJ01-HN-4561): ");
													System.out.print("");
													vehNo=scan.next();

													if(vehNo.charAt(0)>=65&&vehNo.charAt(0)<=90&&vehNo.charAt(1)>=65&&vehNo.charAt(1)<=90&&vehNo.charAt(2)>=48&&vehNo.charAt(2)<=90&&vehNo.charAt(3)>=48&&vehNo.charAt(3)<=57&&vehNo.charAt(5)>=65&&vehNo.charAt(5)<=90&&vehNo.charAt(6)>=65&&vehNo.charAt(6)<=90&&vehNo.charAt(8)>=48&&vehNo.charAt(8)<=57&&vehNo.charAt(9)>=48&&vehNo.charAt(9)<=57&&vehNo.charAt(10)>=48&&vehNo.charAt(10)<=57&&vehNo.charAt(11)>=48&&vehNo.charAt(11)<=57)
														break;
													else
													System.out.println("\n\n\t\t\t\tPlease enter a valid Indian Standard number plate as shown.\n\n");
												}
													String cellNo;
													while(true){
													System.out.print("Enter Cell Phone number: ");
													System.out.print("");
													cellNo=scan.next();
													if(cellNo.length()!=10)
															System.out.println("\n\n\t\t\t\tEnter a valid cell no.\n\n");
															else{
															System.out.println();
															break;
														}
													}
								
								 Class.forName("com.mysql.cj.jdbc.Driver");
								 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/park?user=root&password=1234");
								 Statement st = con.createStatement();
								 String query1 = " INSERT INTO `park`.`details1` (`vehiclenumber`,`name`,`phone_number`,`entry time`,`date`) VALUES ('" + vehNo + "','" + name+ "','" + cellNo + "','" +enttime + "','"+date+"');";
								 int userid=0;
								 int rowsinserted = st.executeUpdate(query1,Statement.RETURN_GENERATED_KEYS);
								 if(rowsinserted > 0)
								 {
								 rs1 = st.getGeneratedKeys();
								 if(rs1.next())
								 userid = rs1.getInt(1);
								 System.out.print(userid);
								 System.out.println("inserted 1 record into database");
								 }
								 else
								 {
								 System.out.println("No record is inserted");
								 }
								
								 con.close();
								 sc.close(); 
								        		  break;
								        			 
								        		  }
								        		  else 
								        			  break;
								        			  
								        	  }
								        	  
								          }
								          if(isempty==false)  
								    			System.out.print("Parking full\n");	 
									
									  }
									else {
									System.out.println("\nEnter the vehicle type...'#' for car and '$' for two-wheeler.");

										  
										  while(true){
										    try{
								  	  type=scan.next().charAt(0);
											    if(type!='#'&&type!='$')
												    throw new InputMismatchException();
											    else
											      break;
									      }
											  catch(InputMismatchException e){
												System.out.println("\nEnter valid choice.");
											 }
										  }
										  
										 
										this.vehicles[i][j]=type;
										  if(j==26)
										  {
											 j=2;
											 i+=4;
										  }
										  else
										  {
											  j+=4;
										  }
										
										  System.out.print("Enter name: ");
											scan.nextLine();
											System.out.print("");
											String name=scan.nextLine();
											 String vehNo;
											while(true){
											System.out.print("Enter Vehicle number (Example: GJ01-HN-4561): ");
											System.out.print("");
											vehNo=scan.next();

											if(vehNo.charAt(0)>=65&&vehNo.charAt(0)<=90&&vehNo.charAt(1)>=65&&vehNo.charAt(1)<=90&&vehNo.charAt(2)>=48&&vehNo.charAt(2)<=90&&vehNo.charAt(3)>=48&&vehNo.charAt(3)<=57&&vehNo.charAt(5)>=65&&vehNo.charAt(5)<=90&&vehNo.charAt(6)>=65&&vehNo.charAt(6)<=90&&vehNo.charAt(8)>=48&&vehNo.charAt(8)<=57&&vehNo.charAt(9)>=48&&vehNo.charAt(9)<=57&&vehNo.charAt(10)>=48&&vehNo.charAt(10)<=57&&vehNo.charAt(11)>=48&&vehNo.charAt(11)<=57)
												break;
											else
											System.out.println("\n\n\t\t\t\tPlease enter a valid Indian Standard number plate as shown.\n\n");
										}
											String cellNo;
											while(true){
											System.out.print("Enter Cell Phone number: ");
											System.out.print("");
											cellNo=scan.next();
											if(cellNo.length()!=10)
													System.out.println("\n\n\t\t\t\tEnter a valid cell no.\n\n");
													else{
													System.out.println();
													break;
												}
											}
						
						 Class.forName("com.mysql.cj.jdbc.Driver");
						 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/park?user=root&password=1234");
						 Statement st = con.createStatement();
						 String query1 = " INSERT INTO `park`.`details1` (`vehiclenumber`,`name`,`phone_number`,`entry time`,`date`) VALUES ('" + vehNo + "','" + name+ "','" + cellNo + "','" +enttime + "','"+date+"');";
						 int userid=0;
						 int rowsinserted = st.executeUpdate(query1,Statement.RETURN_GENERATED_KEYS);
						 if(rowsinserted > 0)
						 {
						 rs1 = st.getGeneratedKeys();
						 if(rs1.next())
						 userid = rs1.getInt(1);
						 System.out.print(userid);
						 System.out.println("inserted 1 record into database");
						 }
						 else
						 {
						 System.out.println("No record is inserted");
						 }
						
						 con.close();
						 sc.close();
						 }
						 }
						 catch (Exception ex) {
						 ex.printStackTrace();
						 }
				}
		 
		public void design()
		{
			for(int j=0;j<32;j++)
			     for(int k=0;k<32;k++){
			       mat[j][k]=' ';
			 }

			 for(int j=0;j<32;j++)
				for(int k=0;k<32;k++){
					if(j==0||(j==31&&(k!=31&&k!=30&&k!=29)))
						mat[j][k]='-';
					if(k==0||k==31)
						mat[j][k]='|';
				}

			  for(int j=2;j<31;j+=4)
				 for(int k=1;k<29;k+=2){
				   mat[j][k]=' ';
				}

			  for(int j=1;j<31;j+=2)
				 for(int k=1;k<29;k+=1){
				 	mat[j][k]='-';
				}

		    for(int j=2;j<31;j+=4)
				 for(int k=2;k<29;k+=2){
				mat[j][k]='|';}
		    
		}
		public void insertintogrid() {
			try {
				//FileWriter fw= new FileWriter(file, true);
				BufferedWriter bw= new BufferedWriter(new FileWriter(location));
				PrintWriter pw= new PrintWriter(bw);
				for (int i=0; i<32;i++) {
					for (int j=0; j<32;j++) {
						bw.append(mat[i][j]);
						bw.append(vehicles[i][j]);}
					bw.append("\n");
				}
				bw.close();
			}
			catch(IOException e){
				System.out.println("\t\t\t\t\t\t\tProblem in creating logs, enter logs manually.");
				
			}
		}

		
	}
	class Exit 
	{
		Time entry;
		Time exit; 
		public double amt;
	void remove()
	{
		try {
			Display d = new Display();
			d.displaylog();
			LocalTime	exttime= LocalTime.now();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1/park?user=root&password=1234");
			Statement st = con.createStatement();
			Scanner de = new Scanner(System.in);
			System.out.println("Enter vehicle number to Modify");
			String vehno = de.nextLine();
			
			String query2 = "UPDATE `details1` SET `exit time` = '"+exttime+"' WHERE `vehiclenumber` = '"+vehno+"';";
			int rowsinserted =st.executeUpdate(query2,Statement.RETURN_GENERATED_KEYS);
			//System.out.println("\nUPDATED");
			
			  System.out.print("Exit time: "+exttime+ "\n");
			  
			  
			  ResultSet rs = st.executeQuery("SELECT * FROM park.details1 where vehiclenumber='"+vehno+"';");
				while(rs.next())
				{
			
				 entry = rs.getTime("entry time");
				 exit = rs.getTime("exit time");
				
				}
				
				long difference = exit.getTime() -entry.getTime();
				double duration=difference/(1000);
				if(duration<=3600)
				{amt=20;
				}
				else 
				{
					amt=20+(5*((duration-3600)/3600));
				}
				String query3 = "UPDATE `details1` SET `amount` = '"+amt+"' WHERE `vehiclenumber` = '"+vehno+"';";
				int rowsinserted1 =st.executeUpdate(query3,Statement.RETURN_GENERATED_KEYS);
				System.out.println("\nUPDATED");
				System.out.print("Duration= "+ (duration/3600)+"\n");
				System.out.print("Amount to be paid= "+ amt);
				
				rs.close();

			de.close();
			con.close();
			}
			catch (Exception ex) {
			ex.printStackTrace();
			}

	}
	
	}
	
	class Display
	{
		

		void displaylog()
		{

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1/park?user=root&password=1234");
				Statement st = con.createStatement();
				//ResultSet rs = st.executeQuery(_query);
				System.out.print("Vehicle Number\t Name\t\t Phone Number\t  Entry Time\t  Exit Time\t  Date\t\t  Amount\n");
				System.out.print("--------------------------------------------------------------------------------------------------------\n");
				ResultSet rs = st.executeQuery("SELECT * FROM park.details1 ;");
				while(rs.next())
				{
				String vehiclenumber = rs.getString("vehiclenumber");
				String Name = rs.getString("name");
				String phoneNumber = rs.getString("phone_number");
				String entrytime = rs.getString("entry time");
				String exittime = rs.getString("exit time");
				String date = rs.getString("date");
				String Amount = rs.getString("amount");
				
				System.out.println(rightPadding(vehiclenumber,' ',15) +" "+rightPadding(Name,' ',17) +" "+rightPadding(phoneNumber,' ',15) +" "+rightPadding(entrytime,' ',15)+" "+rightPadding(exittime,' ',15) +" "+rightPadding(date,' ',15) +" "+rightPadding(Amount,' ',15)+ " " ) ;
				}
				rs.close();
				con.close();
				}
				catch (Exception ex) {
				ex.printStackTrace();
				}
		}

			private String rightPadding(String input, char ch, int L)
			{
			String result= String.format("%" + (-L) + "s", input).replace(' ', ch);
			return result;
			}

		}
	}
	
		
	
	

	
	