import java.util.*;

class Theatre 
{
	Scanner sc  = 	new Scanner(System.in);
	String theatreName;
	String location;
	boolean ac;
	Movie movie;
	int capacity=100;
	public static String[][] seats = new String[11][11];
	String s="";
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
	public ArrayList<String> selectTickets(ArrayList<String> book)
	{		
			System.out.println("\nYou selected "+theatreName);
			book.add(theatreName);
			viewSeats();
			System.out.print("\nEnter the no of tickets: ");
			int tickets = sc.nextInt();
			if(capacity>=tickets)
			{
				capacity-=tickets;
				for(int i=1;i<=tickets;i++)
				{
					System.out.print("Enter the seat no: ");
					char r = sc.next().charAt(0);int col=sc.nextInt(),row=(int)r-96;
					
					
					if(seats[row][col]=="*")
					{
						seats[row][col] = "x";
						s+=Character.toString(r)+Integer.toString(col)+" ";
						
						book.add(s);
						s="";

						
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
			return book;



	 }
	 public void details()
	 {
		System.out.println("Theatre Name: "+this.theatreName);
		System.out.println("Theatre Location: "+this.location);
		System.out.println("Ac : "+this.ac);
	//	System.out.println("No of screens : "+this.no_of_screens);

	}


}
