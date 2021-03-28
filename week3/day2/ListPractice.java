package week3.day2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 /*String companyName="TESTLEAF";
		 char[] unique = companyName.toCharArray();
		 Set <Character> test = new HashSet <Character>();
		
		 for(int i =0; i<unique.length; i++)
	{
		test.add(unique[i]);
		
	}*/
		 
	
		int[] num =  {2,7,11,15};
		int target = 9;
		Map<Integer,Integer> uniqu = new HashMap<Integer,Integer>();
		for(int i = 0; i <num.length;i++)
		{
		uniqu.put(num[i], uniqu.getOrDefault(num[1], 0)+1);
		}
		int diff;
		for(int i =0; i <num.length;i++)
			{
			 diff = target-num[i];
			if(uniqu.containsKey(diff)&& uniqu.get(diff) != i)
			{
				System.out.println(num[i]);
				 
			}
				
			}
				
		
		
		
		
		
		 
		 
	}

}
