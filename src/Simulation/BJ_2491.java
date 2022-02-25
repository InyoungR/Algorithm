package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2491 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int cnt = 1;
        int cnt2 = 1;
        int start = Integer.parseInt(st.nextToken());
        int max = 1;
        int max2 = 1;
        for(int i=1; i<N; i++){
            int next = Integer.parseInt(st.nextToken());
            if(next>= start) {cnt +=1;}
            else { cnt = 1; }
            if(next<= start) {cnt2 +=1;}
            else { cnt2 = 1; }
            start = next;
            max = Math.max(max, cnt);
            max2 = Math.max(max2, cnt2);
        }
        System.out.println(Math.max(max,max2));

    }
}
