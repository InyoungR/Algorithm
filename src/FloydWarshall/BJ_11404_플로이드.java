package FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int [][] adjMatrix = new int [n+1][n+1];
        int INF = 9999999;

        for(int i=1; i<=n; ++i) {
            for(int j=1; j<=n; ++j) {
                if(i != j && adjMatrix[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
                    adjMatrix[i][j]=INF;
                }
            }
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjMatrix[from][to] = Math.min(adjMatrix[from][to], cost);
        }


        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                if(i==k) continue;
                for(int j=1; j<=n; j++){
                    if(i==j || k==j) continue;
                    if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]){
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(adjMatrix[i][j] == INF) sb.append(0).append(" ");
                else sb.append(adjMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
