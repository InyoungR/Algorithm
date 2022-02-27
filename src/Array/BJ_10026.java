package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026 {
    static char [][] picture;
    static int N;
    static boolean[][] V;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        picture = new char[N][];
        for(int i=0; i<N; i++){
            picture[i] = bf.readLine().toCharArray();
        }
        int result1 = 0;
        int result2 = 0;
        V = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!V[i][j]){
                    Normal(i,j);
                    result1 +=1;
                }
            }
        }

        V = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(picture[i][j] == 'R'){
                    picture[i][j] = 'G';
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!V[i][j]){
                    Normal(i,j);
                    result2 +=1;
                }
            }
        }

        System.out.printf("%d %d",result1,result2);
    }

    static void Normal(int rr, int cc){
        Queue<int[]> que = new LinkedList<>();
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};

        que.offer(new int[] {rr,cc});
        V[rr][cc] = true;

        while(!que.isEmpty()){
            int [] curr = que.poll();
            int pixel = picture[curr[0]][curr[1]];

            for(int dir=0; dir<4; dir++){
                int r=curr[0]+dr[dir];
                int c=curr[1]+dc[dir];

                if(r>=0 && c>=0 && r<N && c<N && !V[r][c] && picture[r][c]==pixel){
                    que.offer(new int[] {r,c});
                    V[r][c] = true;
                }
            }
        }
    }
}
