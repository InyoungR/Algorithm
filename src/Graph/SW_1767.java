package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1767 {
    static class Core{
        int r,c;

        public Core(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, answercnt, answerlength;
    static List<Core> cores;
    static List<int []> result;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=T; t++){
            n = Integer.parseInt(bf.readLine());
            int [][] map = new int [n][n];
            cores = new ArrayList<>();
            answercnt = 0;
            answerlength= Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; j++){
                    int temp = Integer.parseInt(st.nextToken());
                    map[i][j] = temp;
                    if(temp == 1) cores.add(new Core(i,j));
                }
            }
            DFS(0,map,0,0);
            sb.append("#").append(t).append(" ").append(answerlength).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int idx, int [][] map2, int cnt, int length ){

        if(idx == cores.size()){
            if(cnt > answercnt) {
                answercnt = cnt;
                answerlength = length;
            } else if( cnt == answercnt){
                answerlength = Math.min(length, answerlength);
            }
            return;
        }
        int r = cores.get(idx).r;
        int c =cores.get(idx).c;

        if(r!=0 && c != 0 && r!=n-1 && c!=n-1){
            int [][] map = new int [n][n];

            for(int i=0; i<n; i++){
                map[i] = map2[i].clone();
            }
            int length2 = length;

            for(int i=0; i<4; i++){
                if(!check(r,c,map,i)) continue;

                while(true){
                    r += dr[i];
                    c += dc[i];

                    if(r<0 || c<0 || r>=n || c>=n ) break;
                    map[r][c] = 2;
                    length2 += 1;
                }
                DFS(idx+1, map, cnt+1, length2);

                for(int j=0; j<n; j++){
                    map[j] = map2[j].clone();
                }
                length2 = length;
                r = cores.get(idx).r;
                c = cores.get(idx).c;
            }
        }
        DFS(idx+1, map2, cnt, length);
    }

    static boolean check(int r, int c, int [][] map, int dir){
        int plus = 1;
        boolean flag = false; //가장자리에 붙어있는지 체크
        boolean flag2 = false; //끝까지 이어지는지 체크
        r += dr[dir];
        c += dc[dir];
        while(r>=0 && c>=0 && r<n && c<n){
            flag = true;
            if(map[r][c] != 0){
                flag2 = true;
                break;
            }
            r += dr[dir];
            c += dc[dir];
        }
        if(!flag) return false; //들어가지도 않았다면 false
        else if(flag2) return false; //들어가서 끝까지 찍지 못하고 나왔다면
        else return true; //들어갔지만 끝을 찍었다면
    }
}
