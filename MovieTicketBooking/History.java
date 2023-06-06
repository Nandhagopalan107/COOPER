


import java.util.*;

class History 
{
	
	public ArrayList<ArrayList> history=new ArrayList<>();
	public  void printHistory(String name)
	{
		System.out.print(name+" ");
		for(ArrayList<String> i : history)
		{
			for(String j : i)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
}
