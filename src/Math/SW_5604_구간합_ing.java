package Math;

import java.util.Scanner;

public class SW_5604_구간합_ing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc. nextInt();
        int[] sums = new int [10];

        for(int i=1; i<10; i++){
            sums[i] = sums[i-1]+i;
        }

        for(int t=1; t<=T; t++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            
        }
    }
}
