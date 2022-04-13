package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3238_이항계수구하기 {

    static long n, r, result;
    static int p, tmpN, tmpR;
    static long fact[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(bf.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            int mod = Integer.parseInt(st.nextToken());

            result = 1;
            fact = new long [mod+1];
            fact[0] = 1;
            for(int i=1; i<=mod; i++){
                fact[i] = (fact[i-1] * i) %mod;
            }

            while(n !=0 || r != 0){
                tmpN = (int) (n%mod);
                tmpR = (int) (k%mod);

                if(tmpN < tmpR){
                    result = 0;
                    break;
                }
                result = (((result*fact[tmpN])%mod) * (Pow((fact[tmpR] * fact[tmpN - tmpR]) %mod, mod-2, mod)%mod))%mod;
                n /=mod;  k/=mod;
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }


    static long Pow(long base, long expo, long mod){
        if(expo == 0) return 1;
        if(expo == 1)return base%mod;

        long temp = Pow(base,expo/2, mod);
        if(expo %2 == 1){
            return (temp*temp%mod) * base%mod;
        }
        return temp*temp%mod;
    }
}
