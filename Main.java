import java.util.*;
public class Main 
{
	public static void printticket(ArrayList<String> a,String name)
	{	System.out.println("Your Ticket details");
		System.out.println("Name : "+name);
		System.out.println("MovieName: "+a.get(0));
		System.out.println("TheatreName: "+a.get(1));
		System.out.println("Seat no:\n");
		System.out.println(a.get(2));


	}
	public static void main(String[] args)
	 {
		Scanner sc = new Scanner(System.in);
		//String name = sc.nextLine(),pass=sc.nextLine();
		System.out.print("\tMovieTicketBooking\n");
		ArrayList<User> user = new ArrayList<>();
		user.add(new User("NANDHU","password"));
		user.add(new User("AKASH","akash"));

		List<Theatre> theatre = new ArrayList<>();
		theatre.add(new Theatre("INOX"));
		theatre.add(new Theatre("PVR"));

		List<Movie> movie = new ArrayList<>();
		movie.add(new Movie("Thunivu",theatre.subList(1,2)));
		movie.add(new Movie("Varisu",theatre));
		movie.add(new Movie("Avengers",theatre));

		User currUser = user.get(0);
		ArrayList<String> details;
		int f ;
		while(true)
		{
			System.out.println("Enter 1 to Book tickets and 2 to view History and 3 to exit");
			f=sc.nextInt();
			if(f==1)
			{
				System.out.println("Movies List");
				for(int i=1;i<=movie.size();i++)
				{
					System.out.println(i+"."+(movie.get(i-1).movieName));
				}
				System.out.println("Enter the movie number: ");
				int movieno = sc.nextInt();
				Movie selected = movie.get(movieno-1);
				details=selected.BookTicket();
				currUser.updateHistory(details);
				printticket(details,currUser.username);
			}
			else if(f==2)
			{
				currUser.printHistory(currUser.username);
			}
			else{
				System.exit(1);
			}
			

		}
		

		
	}
}