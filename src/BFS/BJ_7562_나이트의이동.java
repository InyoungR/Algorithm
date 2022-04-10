package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7562_나이트의이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(bf.readLine());
        int [] dr = {-2,-2,-1,-1,2,2,1,1};
        int [] dc = {-1,1,-2,2,-1,1,-2,2};

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            int [] start = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(bf.readLine());
            int [] goal = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

            Queue<int[]> que = new LinkedList<>();
            boolean[][] V = new boolean[n][n];

            if(start[0] != goal[0] || start[1] != goal[1]) que.add(start);
            V[start[0]][start[1]] = true;
            int cnt = 0;

            outer: while(!que.isEmpty()){
                int size = que.size();
                cnt++;
                for(int i=0; i<size; i++){
                    int [] cur = que.poll();

                    for(int dir=0; dir<8; dir++){
                        int r = cur[0] + dr[dir];
                        int c = cur[1] + dc[dir];

                        if(r<0 || c<0 || r>=n || c>=n || V[r][c]) continue;
                        if(r == goal[0] && c== goal[1]) break outer;

                        V[r][c] = true;
                        que.add(new int [] {r,c});
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
