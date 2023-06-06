import java.util.*;
class Movie 
{
	
	Scanner sc = new Scanner(System.in);
	List<Theatre> theatre ;
	ArrayList<String> booked = new ArrayList<>();

	public String movieName;
	Movie(String name,List<Theatre> x)
	{
		this.movieName = name;
		this.theatre = x;
	}

	
	public ArrayList<String> BookTicket()
	{	booked.add(movieName);
		System.out.println("\nYou selected "+movieName+"\nSelect the theatre no:");
		for(int i=1;i<=theatre.size();i++)
			{
				System.out.println(i+"."+(theatre.get(i-1).theatreName));
			}
		int tno =sc.nextInt();
		booked=theatre.get(tno-1).selectTickets(booked);
		
		return booked;
	}
	
}
