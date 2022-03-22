package Math;

import java.util.Scanner;

public class BJ_4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n;
        while((n = sc.nextInt()) != 0){

            boolean prime [] = new boolean[2*n+1];
            prime[0] = true;
            prime[1] = true;
            for(int i=2; i<=Math.sqrt(2*n); i++){
                if(!prime[i]){ //초기값 false, 따라서 true이면 배수이다.
                    for(int j=2; j*i<=2*n; j++){
                        prime[i*j] = true;
                    }
                }
            }
            int cnt = 0;
            for(int i=n+1; i<= 2*n; i++){
                if(!prime[i]) cnt += 1;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
