package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593_상범빌딩 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String msg = null;

        while((msg=bf.readLine()) != null){
            StringTokenizer st = new StringTokenizer(msg);

            int L = Integer.parseInt(st.nextToken()); //층수
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0) break;

            char [][][] building = new char[L][R][C];
            int sl=0, sr = 0, sc = 0;
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    msg = bf.readLine();
                    for(int k=0; k<C; k++){
                        char a = msg.charAt(k);
                        building[i][j][k] = a;
                        if(a == 'S'){
                            sl = i; sr = j; sc = k;
                        }
                    }
                }
                bf.readLine();
            }

            boolean [][][] V = new boolean[L][R][C];
            int [] dl = {0,0,0,0,-1,1};
            int [] dr = {-1,1,0,0,0,0};
            int [] dc = {0,0,-1,1,0,0};
            Queue<int []> que = new LinkedList<>();

            que.add(new int [] {sl,sr,sc});
            V[sl][sr][sc] = true;
            int m = 0;
            boolean escape = false;

            outer: while(!que.isEmpty()){
                int s = que.size();
                m++;

                for(int i=0; i<s; i++){
                    int [] cur = que.poll();

                    for(int dir=0; dir<6; dir++){
                        int nl = cur[0] + dl[dir];
                        int nr = cur[1] + dr[dir];
                        int nc = cur[2] + dc[dir];

                        if(nl<0 || nr<0 || nc<0 || nl>=L || nr>=R || nc>=C || V[nl][nr][nc] || building[nl][nr][nc] == '#') continue;

                        if(building[nl][nr][nc] == 'E') {
                            escape = true;
                            break outer;
                        }
                        V[nl][nr][nc] = true;
                        que.add(new int [] {nl,nr,nc});

                    }
                }
            }

            if(escape) sb.append("Escaped in ").append(m).append(" minute(s).").append("\n");
            else sb.append("Trapped!").append("\n");

        }
        System.out.println(sb);
    }
}
