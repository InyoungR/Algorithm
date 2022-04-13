package Math;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_8458_원점으로집합 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int t=1; t<=T; t++){
            int n = sc.nextInt();

            int [] nums = new int [n];
            int [] nums2 = new int [n];

            boolean flag = true;
            int max = 0;
            for(int i=0; i<n; i++){
                nums[i] = Math.abs(sc.nextInt())+Math.abs(sc.nextInt());
                max = Math.max(max, nums[i]);
                if(i>=1 && nums[i]%2 != nums[i-1]%2) flag = false;
            }
            int cnt = 0;
            if(!flag) cnt = -1;

            int sum = 0;
            if(flag){
                while(true){
                    boolean flag2 = true;
                    if(sum<max || (max-sum)%2 != 0){
                        flag2 = false;
                    }
                    if(flag2) break;
                    sum += ++cnt;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }

}
