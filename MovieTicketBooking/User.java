import java.util.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class User extends History
{
	String username;
	String password;
	List<History> history = new ArrayList<>();
	SimpleDateFormat Formater = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	User(){;}
	User(String name,String password)
	{
		this.username=name;
		this.password=password;


	}
	public void addMovie(String name)
	{
		history.get(history.size()-1).movieName=name;
	}
	public void addTheatre(List<String> T)
	{
		Date date = new Date();
		history.get(history.size()-1).theatreName=T.get(0);
		history.get(history.size()-1).tickets=T.get(1);
		history.get(history.size()-1).showtime=T.get(2);

		history.get(history.size()-1).date=Formater.format(date);

	}
	public void printHistory()
	{
		for(History i:history)
		{
			System.out.println(username+" "+i.date+" "+i.movieName+" "+i.theatreName+" "+i.showtime+" "+i.tickets);
		}
	}
}
