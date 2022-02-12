package Bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_24023 {

    static int left, right, sum;
    static boolean flag, flag2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(Check(temp, k, i)){
                System.out.printf("%d %d", left+1, right+1);
                flag2 = true;
                break;
            }
        }

        if(!flag2) System.out.print(-1);



    }

    public static boolean Check(int num, int k, int idx){
        if(((num|k)^k)==0){
            sum = sum|num;
            if(sum == k){
                if(!flag){
                    left = idx;
                }
                right = idx;
                return true;
            } else if(!flag){
                left = idx;
                flag = true;
            }
        } else {
            flag = false;
            sum = 0;
            return false;
        } return false;
    }
}
