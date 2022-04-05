package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int [][] cheese = new int [R][C];
        boolean [][] V = new boolean[R][C];
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};
        int cnt = 0;
        int hour = 0;
        int chee = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<C; j++){
                int temp = Integer.parseInt(st.nextToken());
                cheese[i][j] = temp;
                if(temp == 1){
                    cnt += 1;
                }
            }
        }

        while(cnt>0){
            Queue<int[]> que = new LinkedList<>();
            que.add(new int []{0,0});
            V = new boolean[R][C];
            V[0][0] = true;
            chee = 0;
            while(!que.isEmpty()){
                int [] cur = que.poll();

                for(int dir=0; dir<4; dir++){
                    int r = cur[0]+dr[dir];
                    int c = cur[1]+dc[dir];

                    if(r>=0 && c>= 00 && r<R && c<C && !V[r][c]){
                        if(cheese[r][c] == 0) que.add(new int []{r,c});
                        else if(cheese[r][c] == 1) {
                            chee += 1;
                            cnt -= 1;
                            cheese[r][c] = 0;
                        }
                        V[r][c] = true;
                    }
                }
            }
            hour += 1;

        }

        System.out.println(hour);
        System.out.println(chee);
    }
}
