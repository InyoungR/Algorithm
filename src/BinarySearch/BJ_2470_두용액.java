package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2470_두용액 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();

        for(int i=0; i<n; i++){
            nums.add(sc.nextInt());
        }
        int a = 0;
        int b = n-1;
        int answer[] = new int [2];
        int sum = Integer.MAX_VALUE;

        Collections.sort(nums);

        while(a<b){
            int tempSum = nums.get(a)+ nums.get(b);
            if(Math.abs(tempSum)<Math.abs(sum)){
                sum = tempSum;
                answer[0] = nums.get(a);
                answer[1] = nums.get(b);
            }

            if(tempSum>0){
                b--;
            } else if(tempSum<0){
                a++;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb);

    }
}
