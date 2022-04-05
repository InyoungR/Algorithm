package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136_ing {

    static int [][] map = new int [10][10];
    static int [] papers = {0,5,5,5,5,5};
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        //입력받기
        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<10; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    static void dfs(int r, int c, int cnt){



    }

}
