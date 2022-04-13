package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9205_맥주마시면서걷기 {
    static class Pos implements Comparable<Pos>{
        int r,c, dist;
        boolean festival = false;

        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pos o) {
            return dist-o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(bf.readLine());

            Pos[] destinations = new Pos[n+1];

            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i=0; i<n+1; i++){
                st =  new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Pos dest = new Pos(a,b, Math.abs(a-x)+Math.abs(b-y));
                if(i==n) dest.festival = true;
                destinations[i] = dest;
            }

            Queue<Pos> que = new LinkedList<>();
            boolean[] V = new boolean[n+1];
            que.add(new Pos(x,y,0));
            Arrays.sort(destinations);
            boolean flag = false;
            outer: while(!que.isEmpty()){
                Pos cur = que.poll();

                for(int i=0; i<n+1; i++){
                    if(V[i]) continue;
                    Pos next = destinations[i];
                    int dist = Math.abs(cur.r-next.r) + Math.abs(cur.c-next.c);
                    if(dist<=1000) {
                        que.add(next);
                        V[i] = true;
                        if(next.festival) {
                            sb.append("happy").append("\n");
                            flag = true;
                            break outer;
                        }
                    }
                }
            }
            if(!flag) sb.append("sad").append("\n");
        }
        System.out.println(sb);
    }
}
