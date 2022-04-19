package Math;

import java.util.Scanner;

public class SW_6026_성수의비밀번호공격 {
    static int mod = 1000000007;
    static long [] fac = new long [101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        factorial();

        for(int t=1; t<=T; t++){
            int m = sc.nextInt();
            int n = sc.nextInt();

            long answer = solve(m,n);

            sb.append("#").append(t).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }

    static long solve(int m, int n){//치역 m 공역 n
        long result = Pow(m, n);
        for(int i=1; i<m; i++){
            int a = i%2==0?1:-1;
            long r= a * (nCr(m, m-i)*Pow(m-i, n))%mod;
            result = (result+r+mod)%mod;
        }
        return result;
    }

    static void factorial(){
        fac[0] = fac[1] = 1;

        for(int i=2; i<=100; i++){
            fac[i] =( fac[i-1]*i)%mod;
        }
    }
    static long Pow(long a, long b){
        if(b==1) return a;
        long c = Pow(a,b/2);
        if(b%2 == 1){
            return ((c*c)%mod)*a%mod;
        } else return (c*c)%mod;
    }

    static long nCr(int n, int r){
        if(r==0 || n==r) return 1L;

        long a = fac[n];
        long b = Pow(fac[n-r],mod-2);
        long c = Pow(fac[r],mod-2);

        return ((a*b)%mod)*c%mod;
    }
}
