package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1865_동철이의일분배 {
    static int [][] percents = null;
    static double result = 0;
    static int n=0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            n = Integer.parseInt(bf.readLine());
            result = 0;
            percents = new int[n][n];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; j++){
                    percents[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            DFS(0,1,0);
            sb.append('#').append(t).append(" ").append(String.format("%6f", result*100)).append("\n");

        }

        System.out.println(sb);
    }

    static void DFS(int cnt, double num, int v){






        if(num<=result) return;
        if(cnt == n){
            result = Math.max(result, num);
            return;
        }

        for(int i=0; i<n; i++){
            if((v & 1<<i) != 0) continue;
            DFS(cnt+1,num*percents[cnt][i]/100.0, v | 1<<i);
        }
    }
}
