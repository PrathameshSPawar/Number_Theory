/*Write a Java program to perform prime factorization of a number n using three different methods:
Brute-force trial division (Time Complexity: O(n))
Optimized trial division up to √n (Time Complexity: O(√n))
Using a precomputed sieve to store smallest prime factors (Time Complexity: O(log n) per query after O(n log log n) preprocessing)
Print the prime factors with their powers (for method 1 and 2), and just list prime factors (repeated) for method 3
*/

import java.util.*;
public class Main {
    public static int n= (int)1e6 + 5;
    public static int sieve[]=new int[n];
    public static void method1(int n)
    {
        for(int i=2;i<=n;i++)
        {
            if(n%i==0) {
                int cnt=0;
                while(n%i==0) {
                    n=n/i;
                    cnt++;
                }
                System.out.print(i+"^"+cnt+" ");
            }
        }
        //TC: O(n)
    }
    
    public static void method2(int n)
    {
        for(int i=2;i*i<=n;i++){
            if(n%i==0)
            {
                int cnt=0;
                while(n%i==0){
                    n=n/i;
                    cnt++;
                }
                System.out.print(i+"^"+cnt+" ");
            }
        }
        if(n!=1)
        {
            System.out.println(n+"^1");
        }
        //TC: O(Math.sqrt(n))
    }
    
    public static int size=(int)1e6+5;
    public static int sieveArr[]=new int[size];
    public static void sieve(){
        for(int i=0;i<size;i++) sieveArr[i]=1;
        
        sieveArr[0]=sieveArr[1]=0;
        for(int p=2;p<size;p++){
            if(sieveArr[p]==1){
                sieveArr[p]=p;
                for(long j=(long)p*p;j<size;j+=p)
                {
                    if(sieveArr[(int)j]==1) sieveArr[(int)j]=p;
                }
            }
        }
    }
    public static void method3(int n)
    {
        while(n>1)
        {
            int facto=sieveArr[n];
            while(n%facto==0)
            {
                System.out.print(facto+" ");
                n=n/facto;
            }
        }
        //TC: O(nlog(log(n)))
    }

    public static void main(String[] args) {
        Scanner pp= new Scanner(System.in);
        int n=pp.nextInt();
        method1(n);
        method2(n);
        sieve();
        method3(n);
    }
}
