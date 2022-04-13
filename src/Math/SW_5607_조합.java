package Math;

import java.util.Scanner;

public class SW_5607_조합 {

    static long [] memo = null;
    static long mod= 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        memo = new long [1000001];
        memo[0] = 1L;
        memo[1] = 1L;

        for (int i = 1; i < memo.length; i++) {
            memo[i] = memo[i - 1] * i % mod;
        }

        for(int t=1; t<=T; t++){

            int n = sc.nextInt();
            int k = sc.nextInt();

            long num = memo[n];
            long denom = memo[k]*memo[n-k]%mod;

            sb.append("#").append(t).append(" ").append(num*Pow(denom, mod-2)%mod).append("\n");
        }
        System.out.println(sb);
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
