import java.util.*;
public class Main 
{
	static boolean isLogin= false,flag=false;
	static String uname="",upassword;

	public static void printticket(ArrayList<String> a,String name)
	{	System.out.println("Your Ticket details");
		System.out.println("Name : "+name);
		System.out.println("MovieName: "+a.get(0));
		System.out.println("TheatreName: "+a.get(1));
		System.out.println("Seat no:\n");
		System.out.println(a.get(2));


	}
	public static User Login(ArrayList<User> user)
	{
		
			System.out.println("LOGIN");	
			
			for(User tuser:user)
			{
				
				if(tuser.username.equals(uname))
				{
					flag=true;
					
					if(tuser.password.equals(upassword))
					{
							int index = user.indexOf(tuser);
							isLogin=true;
							return user.get(index);
							
							
					}
					else{
						System.out.println("Incorrect password");
					}
				}
				
			
			
			System.out.println("User doesn't exist");



		}
		return new User();
	}
	public static void main(String[] args)
	 {
	 	
		User currUser = new User();
		
		Scanner sc = new Scanner(System.in);
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
		while(!isLogin)
		{
		System.out.print("Enter the username:");
		uname = sc.nextLine();	
		System.out.print("Enter the password:");
		upassword = sc.nextLine();

		currUser=Login(user);
		}


		
		List<String> details;
		int f ;
		while(true)
		{
			System.out.println("Enter 1 to Book tickets and 2 to view History and 3 to exit 4 to Logout");
			f=sc.nextInt();
			switch(f)
			{
			case 1:
			
				System.out.println("Movies List");
				for(int i=1;i<=movie.size();i++)
				{
					System.out.println(i+"."+(movie.get(i-1).movieName));
				}
				System.out.println("Enter the movie number: ");
				int movieno = sc.nextInt();
				Movie selected = movie.get(movieno-1);
				currUser.history.add(new History());
				details = selected.BookTicket();
				currUser.addMovie(selected.movieName);
				currUser.addTheatre(details);
				break;
			case 2:
			
				currUser.printHistory();
				break;
			
			case 3:
				System.exit(1);
				break;
			
			case 4:
				isLogin=false;
				while(!isLogin)
				{
				System.out.print("Enter the username:");
				uname = sc.nextLine();	
				System.out.print("Enter the password:");
				upassword = sc.nextLine();

				currUser=Login(user);
				}

			default:
				break;
			}
			
			

		}
		

		
	}
}
