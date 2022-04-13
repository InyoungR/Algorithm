package Math;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11401_이항계수3 {

    static long [] memo = null;
    static long mod= 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        memo = new long [n+1];
        memo[0] = 1L;
        memo[1] = 1L;

        long num = Factorial(n);
        long denom = Factorial(k)*Factorial(n-k)%mod;

        System.out.println(num*Pow(denom, mod-2)%mod);
    }

    static long Factorial(int n){
        if(n<=1) return memo[n];
        if(memo[n] == 0) memo[n] = (Factorial(n-1)*n)%mod;
        return memo[n];
    }

    static long Pow(long base, long expo){
        if(expo == 1){
            return base%mod;
        }

        long temp = Pow(base,expo/2);
        if(expo %2 == 1){
            return (temp*temp%mod) * base%mod;
        }
        return temp*temp%mod;
    }
}
