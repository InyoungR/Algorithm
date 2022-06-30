package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20055_컨베이어벨트위의로봇 {
    static class Cell{
        int durab;
        boolean robot;

        public Cell(int durab, boolean robot) {
            this.durab = durab;
            this.robot = robot;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Cell [] conveirUp = new Cell[N];
        Cell [] conveirDown = new Cell[N];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++){
            conveirUp[i] = new Cell(Integer.parseInt(st.nextToken()), false);
        }

        for(int i=N-1; i>=0; i--){
            conveirDown[i] = new Cell(Integer.parseInt(st.nextToken()), false);
        }

        while(K>0){

            //만약 n에 도착한 로봇이 있다면 내린다
            if(conveirUp[N-1].robot) conveirUp[N-1].robot = false;

            //1. 컨베이어벨트 회전
            int i=0;
            Cell temp = conveirUp[0];
            conveirUp[0] = conveirDown[0];

            while(i<N-1){
                conveirDown[i] = conveirDown[++i];
            }

            conveirDown[i] = conveirUp[i];

            while(i>1){
                conveirUp[i] = conveirUp[--i];
            }
            conveirUp[1] = temp;
            //만약 n에 도착한 로봇이 있다면 내린다
            if(conveirUp[N-1].robot) conveirUp[N-1].robot = false;

            //2. 로봇이동
            for(int j=N-2; j>=0; j--){
                if(conveirUp[j].robot && conveirUp[j+1].durab>0 && !conveirUp[j+1].robot){
                    conveirUp[j].robot = false;
                    conveirUp[j+1].durab--;
                    if(conveirUp[j+1].durab == 0) K--;
                    conveirUp[j+1].robot = true;

                }
            }

            //3. 올리는 위치에 로봇 올리기
            if(conveirUp[0].durab>0){
                conveirUp[0].robot = true;
                conveirUp[0].durab--;
                if(conveirUp[0].durab == 0) K--;
            }

            cnt++;

        }

        System.out.println(cnt);

    }
}
