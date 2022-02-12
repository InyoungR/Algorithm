package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BJ_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        int [][] board = new int [100][100];
        int result=0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j=x; j<x+10; j++){
                for(int k=y; k<y+10; k++){
                    board[j][k] = 1;
                }
            }
        }

        for(int j=0; j<100; j++){
            for(int k=0; k<100; k++){
                result += board[j][k];
            }
        }
        System.out.println(result);
    }
}
