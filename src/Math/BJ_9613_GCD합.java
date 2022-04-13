package Math;

import java.util.Scanner;

public class BJ_9613_GCD합 {
    static int [] nums = null;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=0; t<T; t++){
            int n = sc.nextInt();
            nums = new int[n];

            for(int i=0; i<n; i++){
                nums[i] = sc.nextInt();
            }
            long result = 0;
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    result += GCD(nums[i],nums[j]);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);


    }

    static int GCD(int a, int b){
        int x = Math.max(a,b);
        int y = Math.min(a,b);
        int temp = 0;

        while(y>0){
            temp = x%y;
            x = y;
            y = temp;
        }

        return x;
    }
}
