import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner pp=new Scanner(System.in);
	    int t=pp.nextInt();
	
	    while(t-->0)
	    {
	        int n=pp.nextInt();
	        int arr[]=new int[n];
	        for(int i=0;i<n;i++) arr[i]=pp.nextInt();
	    
	        int prefSum[]=new int[n];
	        prefSum[0]=arr[0];
	        for(int i=1;i<n;i++) prefSum[i]=prefSum[i-1]+arr[i];
	    
	        for(int i=0;i<n;i++) prefSum[i]=prefSum[i]%n;
	    
	        int start=0,end=0;
	        HashMap<Integer,Integer> mp=new HashMap<>();
	        for(int i=0;i<n;i++)
	        {
	            //case 1 where prefSum=0
	            if(prefSum[i]==0)
	            {
	                start=0;
	                end=i;
	                break;
	            }else{
	                int rem=prefSum[i];
	                if(mp.containsKey(rem))
	                {
	                    start=mp.get(rem)+1;
	                    end=i;
	                    break;
	                }
	                mp.put(rem,i);
	            }
	        }
	        System.out.print(end-start+1);
	        System.out.println();
	        for(int i=start;i<=end;i++)
	        {
	            System.out.print(i+1+ " ");
	        }
	        System.out.println();
	    }

	}
}
