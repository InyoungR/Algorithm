package Math;

import java.util.Scanner;

public class BJ_1016_제곱ㄴㄴ수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean [] notPrime = new boolean [(int) (max-min)+1];

        for(long i=2; i*i<=max; i++){
            long share = min/(i*i);
            if(share*i*i<min) share++;

            for(long j=share; j*i*i<=max; j++){
                notPrime[(int) (j*i*i-min)] = true;
            }
        }

        int cnt = 0;

        for(int i=0; i<max-min+1; i++){
            if(!notPrime[i]) cnt++;
        }

        System.out.println(cnt);
    }
}
