package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2174_로봇시뮬레이션 {
    static class Robot {
        int no, r,c;
        int dir;

        public Robot(int no, int r, int c, String dir) {
            this.no = no;
            this.r = r;
            this.c = c;
            switch(dir){
                case "N":
                    this.dir = 0;
                    break;
                case "E":
                    this.dir = 1;
                    break;
                case "S":
                    this.dir = 2;
                    break;
                case "W":
                    this.dir = 3;
                    break;
            }
        }

        void turnLeft(){
            this.dir--;
            if(dir<0) this.dir = 3;
        }

        void turnRight(){
            this.dir++;
            if(dir>3) this.dir = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken()); //가로
        int B = Integer.parseInt(st.nextToken()); //세로

        Robot [][] map = new Robot[B+1][A+1];

        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken()); //로봇의 개수
        int M = Integer.parseInt(st.nextToken()); //명령의 개수

        Robot [] robots = new Robot[N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            robots[i] = new Robot(i,b,a,dir);
            map[b][a] = robots[i];
        }
        //북 동 남 서
        int [] dr = {1,0,-1,0};
        int [] dc = {0,1,0,-1};
        boolean flag = false;

        outer: for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int no = Integer.parseInt(st.nextToken());
            String order = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            switch(order){
                case "L":
                    for(int j=0; j<cnt; j++) robots[no].turnLeft();
                    break;
                case "R":
                    for(int j=0; j<cnt; j++) robots[no].turnRight();
                    break;
                case "F":
                    for(int j=0; j<cnt; j++){
                        Robot robot = robots[no];
                        int nr = robot.r + dr[robot.dir];
                        int nc = robot.c + dc[robot.dir];

                        if(nr<=0 || nc <=0 || nr>B || nc>A) {
                            sb.append("Robot ").append(no).append(" crashes into the wall");
                            flag = true;
                            break outer;
                        }

                        if(map[nr][nc] != null){
                            sb.append("Robot ").append(no).append(" crashes into robot ").append(map[nr][nc].no);
                            flag = true;
                            break outer;
                        }

                        map[robot.r][robot.c] = null;
                        robot.r = nr;
                        robot.c = nc;
                        map[nr][nc] = robot;
                        robots[no] = robot;
                    }
                    break;
            }

        }
        if(flag){
            System.out.println(sb);
        }else {
            System.out.println("OK");
        }
    }
}
