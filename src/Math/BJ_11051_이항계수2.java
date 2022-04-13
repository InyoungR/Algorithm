package Math;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11051_이항계수2 {

    static int [][] memo = null;
    static int mod= 10007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        memo = new int [n+1][n+1];

        for(int i=0; i<=n; i++){
            Arrays.fill(memo[i],-1);
        }

        int result = DP(n,k);
        System.out.println(result);
    }

    static int DP(int n, int k){

        if(k== 0 || n==k){
            memo[n][k] = 1;
            return memo[n][k];
        } else if(memo[n][k] == -1) {
            memo[n][k] = (DP(n-1,k-1)%mod+DP(n-1,k)%mod)%mod;
        }
        return memo[n][k];
    }
}
