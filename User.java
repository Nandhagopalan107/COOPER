import java.util.*;
class User extends History
{
	String username;
	String password;
	
	User(String name,String password)
	{
		this.username=name;
		this.password=password;


	}
	public   void updateHistory(ArrayList<String> T)
	{

			history.add(T);
	} 

}