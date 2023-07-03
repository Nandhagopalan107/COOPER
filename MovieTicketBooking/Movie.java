import java.util.*;
class Movie 
{
	
	Scanner sc = new Scanner(System.in);
	String[] names = new String[]{"ROLEX","GPN","PVR"};
	
	int timingl = 4,showtime;
	List<Theatre> theatre = new ArrayList() ;
	String[] Btimings = new String[]{"10.00 am","2.00 pm","6.30 pm","10.00pm"};
	String[] Stimings = new String[4];
	public String movieName;
	Movie(String name,int x)
	{
		this.movieName = name;
		for(int i=0;i<x;i++)
		{
		this.theatre.add(new Theatre(names[i]));
		for(int j=0;j<x && j<this.timingl;j++)
		{
				this.Stimings[j]=this.Btimings[j];

				
		}
		
		for(int k=0,j=x+1;j<this.timingl && k<timingl-x;j++,k++)
		{
			this.Btimings[k]=this.Btimings[j];
		}
		
		
		}
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
		System.out.println("\nYou selected "+theatre.get(tno-1).theatreName);
		
		System.out.println("\nselect ShowTimeno");
			for(int i=0;i<this.Stimings.length;i++)
			{
					System.out.println(i+1+"-"+this.Stimings[i]);
			}

			 this.showtime = sc.nextInt();

		String seatno = theatre.get(tno-1).selectTickets(movieName,Stimings[showtime-1]);
		ticketDetails.add(theatre.get(tno-1).theatreName);
		ticketDetails.add(seatno);
		ticketDetails.add(Stimings[showtime-1]);
		return ticketDetails;
	}
	
}
