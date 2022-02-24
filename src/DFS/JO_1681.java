package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1681 {
    static int [][] adjMatrix;
    static int N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());
        adjMatrix = new int [N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = Integer.MAX_VALUE;
        DFS(0,0,1,0);
        System.out.println(result);
    }

    static void DFS(int idx, int cost, int flag, int curr){
        if(idx==N-1){
            if(adjMatrix[curr][0] == 0) return;
            cost += adjMatrix[curr][0];
            result = Math.min(result, cost);
            return;
        }

        if(cost>result) return;

        for(int i=0; i<N; i++){
            if((flag & 1<<i)!=0) continue;
            if(adjMatrix[curr][i] == 0) continue;
            DFS(idx+1, cost+adjMatrix[curr][i], flag|1<<i, i);
        }
    }


}
