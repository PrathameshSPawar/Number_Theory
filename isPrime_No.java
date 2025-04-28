import java.util.*;
public class Main 
{
    
    public static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner pp=new Scanner(System.in);
        System.out.println("Enter the number that you want to check: ");
        int n=pp.nextInt();
        System.out.println(isPrime(n));
    }
}
//time complexit is O(sqrt(n))
