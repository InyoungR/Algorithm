package FloydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14938_서강그라운드 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken()); //지역의 개수
        int m = Integer.parseInt(st.nextToken()); //수색범위
        int r = Integer.parseInt(st.nextToken()); //길의 개수

        int [] items = new int [n+1];
        int [][] map = new int [n+1][n+1];

        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=n; i++){
            items[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            map[from][to] = dist;
            map[to][from] = dist;
        }
        int INF = 987654321;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i!=j && map[i][j]==0) map[i][j]=INF;
            }
        }

        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                if(k==i) continue;
                for(int j=1; j<=n; j++){
                    if(j==k || j==i) continue;
                    if(map[i][k]==INF || map[k][j]==INF) continue;
                    if(map[i][k]+map[k][j]<map[i][j]){
                        map[i][j] = map[i][k]+map[k][j];
                    }
                }
            }
        }

        int max = 0;

        for(int i=1; i<=n; i++){
            int item = 0;
            for(int j=1; j<=n; j++){
                if(map[i][j]<=m) item += items[j];
            }
            max = Math.max(item, max);
        }

        System.out.println(max);

    }
}
