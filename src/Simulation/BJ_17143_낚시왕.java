package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17143_낚시왕 {
    static class shark{
        int r,c,s,d,z;
        boolean alive;

        public shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.d = d;
            if(d == 1 || d == 2){
                this.s = s % ((R-1)*2);
            } else {
                this.s = s % ((C-1)*2);
            }
            this.z = z;
            this.alive = true;
        }
        //d 1:위 2: 아래 3: 오른쪽 4: 왼쪽
        void move(){
            int dr [] = {0,-1,1,0,0};
            int dc [] = {0,-0,0,1,-1};

            int t = this.s;

            while(t-->0){

                if((d==1 && r==1) || (d==2 && r==R)) {
                    switch(this.d){
                        case 1:
                            this.d = 2;
                            break;
                        case 2:
                            this.d = 1;
                            break;
                    }
                }
                if(((d==3 && c==C) || (d==4 && c==1))){
                    switch(this.d){
                        case 3:
                            this.d = 4;
                            break;
                        case 4:
                            this.d = 3;
                            break;
                    }
                }

                this.r += dr[d];
                this.c += dc[d];
            }
        }
    }
    static int R,C,M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //상어의 개수

        Queue<shark> que = new LinkedList<>();
        shark[][] ocean = new shark[R+1][C+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            shark temp = new shark(r,c,s,d,z);

            ocean[r][c] = temp;

        }

        int c = 0;
        int sum = 0;
        while(++c<=C){
            //상어 잡기
            for(int r=1; r<=R; r++){
                if(ocean[r][c] != null){
                    sum += ocean[r][c].z;
                    ocean[r][c] = null;
                    break;
                }
            }

            //ocean에서 상어를 빼서 이동시킨 후 que에 추가
            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(ocean[i][j] != null){
                        shark temp = ocean[i][j];
                        temp.move();
                        que.add(temp);
                        ocean[i][j] = null;
                    }
                }
            }

            //que에 들어있는 상어들 재배치
            int s = que.size();
            for(int i=0; i<s; i++){
                shark temp = que.poll();

                if(ocean[temp.r][temp.c] == null){
                    ocean[temp.r][temp.c] = temp;
                } else {
                    if(ocean[temp.r][temp.c].z<temp.z){
                        ocean[temp.r][temp.c] = temp;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
