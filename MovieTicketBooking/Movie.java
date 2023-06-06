import java.util.*;
class Movie 
{
	
	Scanner sc = new Scanner(System.in);
	List<Theatre> theatre ;
	List<String> booked ;

	public String movieName;
	Movie(String name,List<Theatre> x)
	{
		this.movieName = name;
		this.theatre = x;
	}

	
	public List<String> BookTicket()
	{	
		List<String> ticketDetails = new ArrayList<>();
		System.out.println("\nYou selected "+movieName+"\nSelect the theatre no:");
		for(int i=1;i<=theatre.size();i++)
			{
				System.out.println(i+"."+(theatre.get(i-1).theatreName));
			}
		int tno =sc.nextInt();

		String seatno = theatre.get(tno-1).selectTickets();
		ticketDetails.add(theatre.get(tno-1).theatreName);
		ticketDetails.add(seatno);

		return ticketDetails;
	}
	
}