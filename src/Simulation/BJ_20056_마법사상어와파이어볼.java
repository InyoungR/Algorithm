package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20056_마법사상어와파이어볼 {
    static int N;
    static class Fireball{
        int r,c,m,s,d, cnt;
        boolean even;
        boolean allEvenorOdd;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
            this.cnt = 1;
            if(d%2 == 0) this.even = true;
            else this.even = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //파이어볼 개수
        int K = Integer.parseInt(st.nextToken()); //명령의 개수

        Fireball [][] map = new Fireball[N][N];
        Queue<Fireball> que = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Fireball f = new Fireball(r,c,m,s,d);
            map[r][c] = f;
            que.add(f);
        }

        while(K-- > 0){
            Fireball [][] map2 = new Fireball[N][N];

            while(!que.isEmpty()){
                Fireball cur = que.poll();
                map[cur.r][cur.c] = null;
                Queue<Fireball> que2 = new LinkedList<>();

                //fireball이 나누어질 필요 없는 하나라면
                if(cur.cnt == 1){
                    que2.add(move(cur));
                } else { //fireball이 합쳐져서 4개로 나누어진다면
                    if(cur.allEvenorOdd){ //방향이 모두 홀수이거나 짝수
                        for(int i=0; i<8; i+=2){
                            Fireball f = new Fireball(cur.r,cur.c,cur.m/4, cur.s/cur.cnt, i);
                            que2.add(move(f));
                        }
                    } else {
                        for(int i=1; i<8; i+=2){
                            Fireball f = new Fireball(cur.r,cur.c,cur.m/4, cur.s/cur.cnt, i);
                            que2.add(move(f));
                        }
                    }
                }

                while(!que2.isEmpty()){
                    Fireball f = que2.poll();
                    if(map2[f.r][f.c] == null){ //비어있는 칸이라면
                        map2[f.r][f.c] = f;
                    } else { //파이어볼이 합체되어야 한다면
                        Fireball already = map2[f.r][f.c];

                        already.m += f.m;
                        already.s += f.s;
                        already.cnt += 1;

                        if(already.even != f.even) already.allEvenorOdd = false;
                        else if(already.cnt == 2) already.allEvenorOdd = true;

                        map2[f.r][f.c] = already;
                    }
                }
            }

            for(int i=0; i<N; i++){
                map[i] = map2[i].clone();
            }

            que = new LinkedList<>();
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] != null){
                        if(map[i][j].cnt != 1){
                            map[i][j].m = (map[i][j].m/5)*4;
                            if(map[i][j].m == 0) map[i][j] = null;
                            else que.add(map[i][j]);
                        } else {
                            que.add(map[i][j]);
                        }
                    }
                }
            }
        }

        int answer = 0;

        while(!que.isEmpty()){
            answer += que.poll().m;
        }

        System.out.println(answer);
    }

    static Fireball move(Fireball f){

        int [] dr = {-1,-1,0,1,1,1,0,-1};
        int [] dc = {0,1,1,1,0,-1,-1,-1};

        f.r += dr[f.d] * (f.s % N);
        f.c += dc[f.d] * (f.s % N);

        if(f.r >= N) f.r -= N;
        if(f.c >= N) f.c -= N;
        if(f.r<0) f.r +=N;
        if(f.c<0) f.c +=N;

        return f;
    }
}
