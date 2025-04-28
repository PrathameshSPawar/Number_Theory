/*📄 Question:
Write a program to count how many prime numbers are strictly less than a given number n, where n can be as large as 10^6.
Use the Sieve of Eratosthenes algorithm to solve the problem efficiently.

Also, state the time complexity of your solution.

⏳ Time Complexity:
Building the sieve: O(n log log n)

Counting primes: O(n)

Thus, the overall time complexity is O(n log log n).*/

import java.util.*;
public class Main {
    public static int n= (int)1e6 + 5;
    public static int sieve[]=new int[n];
    public static void makeSieve()
    {
        for(int i=0;i<n;i++) sieve[i]=1;
        sieve[0]=sieve[1]=0;

        for(int i=2;i<n;i++)
        {
            if(sieve[i]==1)
            {
                for(int j=2*i;j<n;j+=i) sieve[j]=0;
            }
        }
    }

    public static void main(String[] args) {
        makeSieve();
        Scanner pp= new Scanner(System.in);
        int no=pp.nextInt(),countPrime=0;
        for(int i=2;i<=no;i++)
        {
            if(sieve[i]==1) countPrime++;
        }
        System.out.println(countPrime);
    }
}
