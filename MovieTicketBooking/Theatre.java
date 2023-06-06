import java.util.*;

class Theatre 
{
	Scanner sc  = 	new Scanner(System.in);
	String theatreName;
	String location;
	String final_seats;
	boolean ac;
	Movie movie;
	int capacity=100;
	public static String[][] seats = new String[11][11];
	
	Theatre(String name)
	{
		
		this.theatreName=name;
		for(String[] i:seats)
		{
			Arrays.fill(i,"*");	
		}
		char v='a';int v2=1;
		for(char j = 1;j<11;j++)
		{
			seats[j][0]=Character.toString(v);
			seats[0][j]=Integer.toString(v2);
			v2++;
			v++;
		}
	}
	public  static void viewSeats()
	{	
		System.out.println("\n\n---Seating arrangements---");
		for(String[] i:seats)
			{
				for(String j : i)
				{
					System.out.print(j+" ");
				}
				System.out.println();
			}
	}
	public String selectTickets()
	{		
			System.out.println("\nYou selected "+theatreName);
			
			viewSeats();
			System.out.print("\nEnter the no of tickets: ");
			
			int tickets = sc.nextInt();
			final_seats="";
			if(capacity>=tickets)
			{
				capacity-=tickets;
				for(int i=1;i<=tickets;i++)
				{
					System.out.println("Enter the seat no: ");
					String s=sc.next();
					char r = s.charAt(0);int col=Character.getNumericValue(s.charAt(1)),row=(int)r-96;
					
					
					if(seats[row][col]=="*")
					{
						seats[row][col] = "x";
						final_seats+=s+" ";
						
					}
					else{
						System.out.println("Sorry! This seat was already booked.");
						i--;
					}

				}
			}
			else{
				System.out.println("Insufficient tickets. Available no of tickets: "+ capacity);
			}
			return final_seats;



	 }
	 public void details()
	 {
		System.out.println("Theatre Name: "+this.theatreName);
		System.out.println("Theatre Location: "+this.location);
		System.out.println("Ac : "+this.ac);
	//	System.out.println("No of screens : "+this.no_of_screens);

	}


}