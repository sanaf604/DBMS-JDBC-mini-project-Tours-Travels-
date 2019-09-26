package TravelTour;

import java.util.Scanner;

import java.sql.*;
public class TravelMenu {
	public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		Statement myStmt = null;
		PreparedStatement stmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tnt?autoReconnect=true&useSSL=false", "sanaf" , "momin");
			
			System.out.println("Database connection successful!\n");
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
        Scanner sc = new Scanner(System.in);

     System.out.println("\t\t\tWelcome to HOLIDAY-INN.com");
       // System.out.println();

        //Creating Menu
        while(true){
   System.out.println("\t1.Register.");
   System.out.println("\t2.Sign In.");
   System.out.println("\t3.Admin Log In.");
	System.out.println("\t4.Exit.");
    System.out.println("\tEnter your choice::");
     int choice = sc.nextInt();
             switch(choice){
case 1: System.out.println("\t\t\tREGISTRATION");
                registration();
                break;
case 2: System.out.println("\t\t\tSIGN-IN");
                sign_in();
                break;
case 3: System.out.println("\t\t\tADMIN LOG-IN");
                admin_log_in();
                break;
                
case 4: System.out.println("\tThanks for bookig from our App. Visit again");
                System.exit(0);
                break;
default: System.out.println("\tIncorrect input!!! Please re-enter choice from our menu");
                }
        }

}
	
	
	//funtions .....

	private static void admin_log_in() throws SQLException {
		// TODO Auto-generated method stub
		
		Connection myConn = null;
		Statement myStmt = null;
		PreparedStatement stmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tnt?autoReconnect=true&useSSL=false", "sanaf" , "momin");
			
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		Scanner sc=new Scanner(System.in);
		String admin= "abc";
		System.out.println("Username ::");	
		String username=sc.next();
		System.out.println("Password ::");	
		String password=sc.next();
		if(username.equals(admin) && password.equals(admin))
		{
			//System.out.println("ok");
			while(true){
			System.out.println("1.FLIGHT.");
			System.out.println("2.TRAIN.");
			System.out.println("3.BUS.");
			System.out.println("4.HOTEL.");
			System.out.println("5.EXIT.");
			int op = sc.nextInt();
			switch(op)
			{
			case 1:
				
				System.out.println("1.Insert ");
				System.out.println("2. Update ");
				System.out.println("3. Delete");
				System.out.println("4. Show records ");
				System.out.println("Enter your choice::");
				int finput=sc.nextInt();
				if(finput==1) //Insert new data
				{
					String query="insert into flight values(NULL,?,?,?,?,?,?,?,?)";
					
					System.out.println("Departure Airport :: ");
					String fdeparture_airport=sc.next();
					System.out.println("Departure Time :: ");
					String fdeparture_time = sc.next();
					System.out.println("Arrival Airport :: ");
					String farrival_airport = sc.next();
					System.out.println("Arrival Time :: ");
					String farrival_time = sc.next();
					System.out.println("Economy Price :: ");
					int feconomy_price = sc.nextInt();
					System.out.println("Business Price :: ");
					int fbusiness_price = sc.nextInt();
					System.out.println("Class(B/E) :: ");
					String fcls = sc.next();
					System.out.println("Seat Type(window/isle) :: ");
					String flight_seat = sc.next();
					
				
					stmt = myConn.prepareStatement(query);
				
					stmt.setString(1,fdeparture_airport);
					stmt.setString(2,fdeparture_time);
					stmt.setString(3,farrival_airport);
					stmt.setString(4,farrival_time);
					stmt.setInt(5,feconomy_price);
					stmt.setInt(6,fbusiness_price);
					stmt.setString(7,fcls);
					stmt.setString(8,flight_seat);

					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA INSERTED SUCCESSFULLY!!!");
						
				}
				
				if(finput==2)//update
				{
					System.out.println("enter flight id :");
					int fid=sc.nextInt();
					System.out.println("enter updated departure time :");
					String fdeparture_time =sc.next();
					System.out.println("enter updated arrival time :");
					String farrival_time =sc.next();
					String query="update flight set  departure_time =? , arrival_time =? where flight_id = ?";
					
					stmt = myConn.prepareStatement(query);
					stmt.setInt(3,fid);
					stmt.setString(1,fdeparture_time);
					stmt.setString(2,farrival_time);
					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA UPDATED SUCCESSFULLY!!!");
						
				}
					
				
				if(finput==3)//Delete
				{

					System.out.println("enter flight id :");
					int fid=sc.nextInt();
					
					String query="delete from flight where flight_id = ?";
					
					stmt = myConn.prepareStatement(query);
					stmt.setInt(1,fid);
					
					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA DELETED SUCCESSFULLY!!!");
						
				}
 
				if(finput==4)//show records
				{
					myStmt = myConn.createStatement();
					
					myRs = myStmt.executeQuery("select * from flight");
					while (myRs.next()) 
					{
					System.out.println(myRs.getString("departure_airport") + "\t" + myRs.getInt("economy_price"));
					}
				}
				
				break;
			case 2: 
				
				
				System.out.println("1.Insert ");
				System.out.println("2. Update ");
				System.out.println("3. Delete");
				System.out.println("4. Show records ");
				System.out.println("Enter your choice::");
				int tinput=sc.nextInt();
				if(tinput==1) //Insert new data
				{
					String query="insert into train values(NULL,?,?,?,?,?,?,?,?,?)";
					
					
					
					System.out.println("Train Name ::");
					String train_name=sc.next();
					System.out.println("Departure Station :: ");
					String train_departure_station=sc.next();
					System.out.println("Departure Time :: ");
					String train_departure_time = sc.next();
					System.out.println("Arrival Station :: ");
					String train_arrival_station = sc.next();
					System.out.println("Arrival Time :: ");
					String train_arrival_time = sc.next();
					System.out.println("2-Tier Price :: ");
					int train_2tier_price = sc.nextInt();
					System.out.println("3-Tier Price :: ");
					int train_3tier_price = sc.nextInt();
					System.out.println("Coach Type(2-Tier/3-Tier) :: ");
					String train_coach = sc.next();
					System.out.println("Seat Type(window/isle) :: ");
					String train_seat = sc.next();
					
					stmt = myConn.prepareStatement(query);
					stmt.setString(1,train_name);
					stmt.setString(2,train_departure_station);
					stmt.setString(3,train_departure_time);
					stmt.setString(4,train_arrival_station);
					stmt.setString(5,train_arrival_time);
					stmt.setInt(6,train_2tier_price);
					stmt.setInt(7,train_3tier_price);
					stmt.setString(8,train_coach);
					stmt.setString(9,train_seat );

					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA INSERTED SUCCESSFULLY!!!");	
				}
				
				if(tinput==2)//update
				{
					System.out.println("enter train id :");
					int train_id=sc.nextInt();
					System.out.println("enter updated departure time :");
					String tdeparture_time =sc.next();
					System.out.println("enter updated arrival time :");
					String tarrival_time =sc.next();
					String query="update train set  train_departure_time =? , train_arrival_time =? where train_id = ?";
					
					stmt = myConn.prepareStatement(query);
					stmt.setInt(3,train_id);
					stmt.setString(1,tdeparture_time);
					stmt.setString(2,tarrival_time);
					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA UPDATED SUCCESSFULLY!!!");
				}
					
				
				if(tinput==3)//Delete
				{
					System.out.println("enter train id :");
					int train_id=sc.nextInt();
					
					String query="delete from train where train_id = ?";
					
					stmt = myConn.prepareStatement(query);
					stmt.setInt(1,train_id);
					
					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA DELETED SUCCESSFULLY!!!");
							
				}

				if(tinput==4)//show records
				{
				
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("select * from train");
					
					while (myRs.next()) 
					{
					System.out.println(myRs.getString("train_departure_station") + "\t" + myRs.getString("train_name"));
					}
				}
				break;
				
				
				
				
			case 3:
				
				System.out.println("1.Insert ");
				System.out.println("2. Update ");
				System.out.println("3. Delete");
				System.out.println("4. Show records ");
				System.out.println("Enter your choice::");
				int binput=sc.nextInt();
				if(binput==1) //Insert new data
				{
					
					String query="insert into bus values(NULL,?,?,?,?,?,?,?,?,?)";
					
				
					System.out.println("Bus Name ::");
					String bus_name=sc.next();
					System.out.println("Departure Bus Stop :: ");
					String bus_departure_stop=sc.next();
					System.out.println("Departure Time :: ");
					String bus_departure_time = sc.next();
					System.out.println("Arrival Bus Stop :: ");
					String bus_arrival_stop = sc.next();
					System.out.println("Arrival Time :: ");
					String bus_arrival_time = sc.next();
					System.out.println("AC Price :: ");
					int bus_ac_price = sc.nextInt();
					System.out.println("Normal Price :: ");
					int bus_normal_price = sc.nextInt();
					System.out.println("Type(AC/Normal) :: ");
					String bus_type = sc.next();
					System.out.println("Seat Type(window/isle) :: ");
					String bus_seat = sc.next();
					
					
					stmt = myConn.prepareStatement(query);
					stmt.setString(1,bus_name);
					stmt.setString(2,bus_departure_stop);
					stmt.setString(3,bus_departure_time);
					stmt.setString(4,bus_arrival_stop);
					stmt.setString(5,bus_arrival_time);
					stmt.setInt(6,bus_ac_price);
					stmt.setInt(7,bus_normal_price);
					stmt.setString(8,bus_type);
					stmt.setString(9,bus_seat );

					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA INSERTED SUCCESSFULLY!!!");	
					
				}
				
				if(binput==2)//update
				{
					System.out.println("enter bus id :");
					int bus_id=sc.nextInt();
					System.out.println("enter updated departure time :");
					String bus_departure_time =sc.next();
					System.out.println("enter updated arrival time :");
					String bus_arrival_time =sc.next();
					String query="update bus set  bus_departure_time =? , bus_arrival_time =? where bus_id = ?";
					
					stmt = myConn.prepareStatement(query);
					stmt.setInt(3,bus_id);
					stmt.setString(1,bus_departure_time);
					stmt.setString(2,bus_arrival_time);
					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA UPDATED SUCCESSFULLY!!!");
					
				}
					
				
				if(binput==3)//Delete
				{
					System.out.println("enter bus id :");
					int bus_id=sc.nextInt();
					
					String query="delete from bus where bus_id = ?";
					
					stmt = myConn.prepareStatement(query);
					stmt.setInt(1,bus_id);
					
					
					int a= stmt.executeUpdate();
					System.out.println("No. of rows affected:" + a);
					System.out.println("DATA DELETED SUCCESSFULLY!!!");
							
				}

				if(binput==4)//show records
				{
					myStmt = myConn.createStatement();
					myRs = myStmt.executeQuery("select * from bus");
					
					while (myRs.next()) 
					{
					System.out.println(myRs.getString("bus_departure_stop") + "\t" + myRs.getString("bus_name"));
					}
				}
				break;
				
			case 4:
				System.out.println("1.Insert ");
				System.out.println("2. Update ");
				System.out.println("3. Delete");
				System.out.println("4. Show records ");
				System.out.println("Enter your choice::");
				int hinput=sc.nextInt();
				if(hinput==1) //Insert new data
				{
					
				}
				
				if(hinput==2)//update
				{
					
				}
					
				
				if(hinput==3)//Delete
				{
					
				}

				if(hinput==4)//show records
				{
					
				}
				break;
	
			case 5:
				System.out.println("THANKS ADMIN!!!!");
				 System.exit(0);
				default:
					System.out.println("Please enter the correct choice!!");
					break;
			}
		}}
		else
		{
			System.out.println("not ok");
		}
	}

	private static void sign_in() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	System.out.println("Username ::");	
	String username=sc.next();
	System.out.println("Password ::");	
	String password=sc.next();
	
	}

	private static void registration() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	System.out.println("\n\n\t\tE-mail :: ");	
	
	String email = sc.nextLine();
	System.out.println("\n\n\t\tContact Number :: "); 
	float contact_no = sc.nextFloat();
	System.out.println("\n\n\t\tPassword :: ");	
	String password = sc.next();	
	
	}

}
