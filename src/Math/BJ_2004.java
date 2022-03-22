package Math;

import java.util.Scanner;

public class BJ_2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); //nCm 에서 0의 결과 n!/(n-m)!m!

        int cnt2 = multiplier(N,2)-multiplier(N-M,2)-multiplier(M,2);
        int cnt5 = multiplier(N,5)-multiplier(N-M,5)-multiplier(M,5);

        System.out.println(Math.min(cnt2,cnt5));
    }

    static int multiplier(int num, int num2){
        int cnt = 0;

        while(num>= num2){
            cnt += num/num2;
            num /= num2;
        }
        return cnt;
    }
}
