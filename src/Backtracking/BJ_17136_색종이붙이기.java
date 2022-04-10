package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136_색종이붙이기 {
    static int [][] map = new int [10][10];
    static int [] papers = {0,5,5,5,5,5};
    static int answer=25, cnt=0, cnt2 = 0, total = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<10; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<10; j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1) cnt++;
            }
        }

        cnt2 = cnt;
        DFS();

        System.out.println(answer==25?-1:answer);
    }

    static void DFS(){
        if(total>answer) return;

        outer: for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                //색칠할 공간을 찾았다면
                if(map[i][j] == 1){
                    //사이즈별로 색종이 붙여보기
                    for(int s=5; s>=1; s--){
                        if(papers[s] >0 && check(i,j,s)){
                            color(i,j,s,2);
                            papers[s]--;
                            total++;
                            if(cnt == 0) {
                                cnt2 = 0;
                                answer = Math.min(answer,total);
                            }
                            DFS();
                            color(i,j,s,1);
                            papers[s]++;
                            total--;
                        }
                    }
                    break outer;
                }
            }
        }

        if(cnt == 0) {
            cnt2 = 0;
            answer = Math.min(answer,total);
        }
    }

    static boolean check(int r, int c, int size){
        boolean flag = true;
        outer: for(int i=0; i<size; i++){
            int nr = r+i;
            for(int j=0; j<size; j++){
                int nc = c+j;
                if(nr<0 || nc<0 || nr>=10 || nc>=10 || map[nr][nc] != 1) {
                    flag = false;
                    break outer;
                }
            }
        }
        return flag;
    }
    static void color(int r, int c, int size, int type){
        int plus = 0;
        switch(type){
            case 2:
                plus = -1;
                break;
            case 1:
                plus = 1;
                break;
        }
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                map[r+i][c+j] = type;
                cnt+=plus;
            }
        }
    }

}
