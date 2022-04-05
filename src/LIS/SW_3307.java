package LIS;

import java.util.Arrays;
import java.util.Scanner;

public class SW_3307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int t=1; t<=T; t++){
            int n = sc.nextInt();
            int[] arr = new int [n];
            int[] result = new int [n];

            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            result[0] = 1;

            for(int i=1; i<n; i++){
                for(int j=i-1; j>=0; j-- ){
                    if(arr[i]>= arr[j]){
                        result[i] = Math.max(result[j]+1, result[i]);
                    } else {
                        result[i] = Math.max(result[i],1);
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(Arrays.stream(result).max().getAsInt()).append("\n");
        }
        System.out.println(sb);
    }
}
