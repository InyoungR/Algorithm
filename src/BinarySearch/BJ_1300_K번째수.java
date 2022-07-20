package BinarySearch;

import java.util.Scanner;

public class BJ_1300_K번째수 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long max = n*n;
        long min = 1*1;
        int answer = 0;
        while(min<max){
            long mid = (min+max)/2;
            long cnt = 0;

            for(int i=1; i<=n; i++){
                cnt += Math.min(mid/i, n);
            }
            //1 2 2 3 3 4 6 6 9
            if(cnt>k){
                max = mid;
            } else {
                min = mid+1;
            }
        }

        System.out.println(min);
    }
}
