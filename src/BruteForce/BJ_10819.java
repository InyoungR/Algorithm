package BruteForce;

import java.util.Scanner;

public class BJ_10819 {
    static int n, result;
    static int [] nums, nums2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int [n];
        nums2 = new int [n];

        for(int i=0; i<n; i++){
            nums[i]= sc.nextInt();
        }
        result = 0;
        permutation(0,0);
        System.out.println(result);
    }

    static void permutation(int idx, int flag){
        if(idx == n){
            int sum = 0;
            for(int i=0; i<n-1; i++){
                sum += Math.abs(nums2[i]-nums2[i+1]);
            }
            result = Math.max(result, sum);
        }
        for(int i=0; i<n; i++){
            if((flag & 1 << i) != 0) continue;
            nums2[idx] = nums[i];
            permutation(idx+1, flag| 1<<i);
        }
    }
}
