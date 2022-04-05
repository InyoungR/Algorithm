package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1194 {
    static class pos{
        int r,c,key, cnt;

        public pos(int r, int c, int key, int cnt) {
            this.r = r;
            this.c = c;
            this.key = key;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); //세로
        int m = Integer.parseInt(st.nextToken()); //가로
        Queue<pos> que = new LinkedList<>();
        char [][] map = new char[n][m];
        boolean [][][] V = new boolean[1<<6][n][m];

        for(int i=0; i<n; i++){
            String msg = bf.readLine();
            for(int j=0; j<m; j++){
                char temp = msg.charAt(j);
                if(temp == '0') {
                    que.add(new pos(i,j,0,0));
                    V[0][i][j] = true;
                    map[i][j]='.';
                    continue;
                }
                map[i][j] = temp;
            }
        }
        int [] dr = {-1,1,0,0};
        int [] dc = {0,0,-1,1};
        int result = 0;
        int vcnt = 0;
        outer:while(!que.isEmpty()){
            pos cur = que.poll();

            for(int dir=0; dir<4; dir++){
                int nr = cur.r+dr[dir];
                int nc = cur.c+dc[dir];

                if(nr<0 || nc<0 || nr>=n || nc>=m || V[cur.key][nr][nc]) continue;
                switch(map[nr][nc]){
                    case '#':
                        break;
                    case '.':
                        V[cur.key][nr][nc] = true;
                        que.add(new pos(nr,nc,cur.key, cur.cnt+1));
                        break;
                    case '1':
                        result = cur.cnt+1;
                        break outer;
                   default:
                        if(Character.isLowerCase(map[nr][nc])){
                            if((1 << (map[nr][nc]-'A') & cur.key) != 0) {
                                V[cur.key][nr][nc] = true;
                                que.add(new pos(nr,nc,cur.key, cur.cnt+1));
                                break;
                            }
                            que.add(new pos(nr,nc,cur.key | 1 << (map[nr][nc]-'a'), cur.cnt+1));
                            V[cur.key | 1 << (map[nr][nc]-'a')][nr][nc] = true;
                            break;
                        } else {
                            if((1 << (map[nr][nc]-'A') & cur.key) != 0){ //0이라면 같은것
                                V[cur.key][nr][nc] = true;
                                que.add(new pos(nr,nc,cur.key, cur.cnt+1));
                                break;
                            } else {
                                break;
                            }
                        }
                }
            }
        }
        System.out.println(result == 0 ? -1:result);

    }
}
