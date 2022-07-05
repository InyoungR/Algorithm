package LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2565_전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int [][] wires = new int [n][2];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires,(o1, o2) -> o1[0] - o2[0]);
        int idx = 0;
        int [] dp = new int [n];
        for(int i=0; i<n; i++){
            if(idx == 0) dp[idx++] = wires[i][1];
            else{
                if(dp[idx-1]<wires[i][1]) dp[idx++] = wires[i][1];
                else dp[LowerBound(dp, wires[i][1])] = wires[i][1];
            }
        }

        System.out.println(n-idx);

    }

    static int LowerBound(int [] list, int num){
        int answer = 0;
        for(int i=0; i<list.length; i++){
            if(list[i]>num){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
