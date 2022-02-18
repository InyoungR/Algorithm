package Subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_9229 {

    static int T, N, M, max, result;
    static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            bags = new int [N];
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                bags[j] = Integer.parseInt(st.nextToken());
            }
            max=0;
            result = 0;
            Recursion(0,0,0);
            if(result == 2) sb.append("#").append(i+1).append(" ").append(max).append("\n");
            else sb.append("#").append(i+1).append(" ").append(-1).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void Recursion(int cnt, int weight, int idx){
        if(cnt>2) return;
        if(idx==N)return;
        if(weight>M) return;
        if(weight<=M && max < weight){
            max = weight;
            result = cnt;
        }

        Recursion(cnt+1, weight+bags[idx], idx+1);
        Recursion(cnt, weight, idx+1);
    }
}
