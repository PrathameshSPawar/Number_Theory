https://www.codechef.com/problems/DIVSUBS
/*here their are two ways to solve this problem one is using HashMap but which gives n logn TC 
Second one is using arrays which gives O(n) TC*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner pp = new Scanner(System.in);
        System.out.println("Enter the Test cases: ");
        int t=pp.nextInt();
        while(t-->0)
        {
            int n=pp.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=pp.nextInt();
            }

            int pref_sum[]=new int[n];
            pref_sum[0]=arr[0];
            for(int i=1;i<n;i++)  pref_sum[i]=pref_sum[i-1]+arr[i];

            for (int i=0;i<n;i++) pref_sum[i]=pref_sum[i]%n;

            int start=0,end=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            int isPresent[]=new int[n];
            Arrays.fill(isPresent,-1);
            for(int i=0;i<n;i++)
            {
                int curr=pref_sum[i];
                if(curr==0){
                    start=0;
                    end=i;
                    break;
                }else{
                    if(isPresent[curr]!=-1)
                    {
                        start=isPresent[curr]+1;
                        end=i;
                        break;
                    }
                    isPresent[curr]=i;
                }
            }
            for(int i=start;i<end+1;i++)
            {
                System.out.println(i+ " ");
            }
        }
    }
}
