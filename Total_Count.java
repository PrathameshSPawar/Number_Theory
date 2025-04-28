/*Total Count
Find numbers which are less than or equal to M and divisible by first N prime numbers.
sample input:
M = 30
N = 3
sample output: 22

Constraints:
1<= M <= 10^15
1<= N <= 20*/
import java.util.*;
public class Main {
    public static int countNO=0;
    public static int m=0;
    public static boolean isPrime(int n)
    {
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }

    public static void subSetCount(int mask,int prime[])
    {
        int n=prime.length;
        int lcm=1,cntSetBits=0;
        for(int i=0;i<n;i++)
        {
            if((mask & (1<<i)) !=0){
               lcm*=prime[i];
                cntSetBits++;
            }
        }
        
        //int noOfSetBits = Integer.bitCount(mask);
        if(cntSetBits%2==1) countNO+=(m/lcm);
        else countNO-=(m/lcm);
    }

    public static void main(String[] args) {
        Scanner pp=new Scanner(System.in);
        System.out.println("\nEnter no of prime that you want: ");
        int n=pp.nextInt();
        int primeNo[]=new int[n];
        //primeNo[n-1]=0;
        int index=0;
        int number=2;
        while(index < n)
        {
            if(isPrime(number))
            {
                primeNo[index++]=number;
            }
            number++;
        }
        System.out.println("All prime numberd arr is fill please give m number");
        m=pp.nextInt();
        for(int mask=1;mask<(1<<n);mask++)
        {
            subSetCount(mask,primeNo);
        }
        System.out.println(countNO);
        return;
    }
}
