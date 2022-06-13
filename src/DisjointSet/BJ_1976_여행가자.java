package DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1976_여행가자 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(bf.readLine()); //도시의 수
        int M = Integer.parseInt(bf.readLine()); //여행하는 도시의 수

        int [][] map = new int [N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int [] travel = new int [M];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++){
            travel[i] = Integer.parseInt(st.nextToken());
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(k == i) continue;
                for(int j=1; j<=N; j++){
                    if(i==j || k==j) continue;
                    if(map[i][k] == 1 && map[k][j] == 1) map[i][j] = 1;
                }
            }
        }

        boolean flag = true;
        for(int i=0; i<M-1; i++){
            int from = travel[i];
            int to = travel[i+1];
            if(from == to) continue;
            else if(map[from][to] == 0){
                flag = false;
                break;
            }
        }

        if(flag) System.out.println("YES");
        else System.out.println("NO");

    }
}
