package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스 수
        int n = Integer.parseInt(bf.readLine());

        for(int i=0; i<n; i++){
            int sum = 0;
            sb.append("#").append(i+1).append(" ");
            //농장의 크기와 배열 생성
            int m = Integer.parseInt(bf.readLine());
            char [][] map = new char [m][m];

            //농장물 입력 받기
            for(int j=0; j<m; j++){
                map[j] = bf.readLine().toCharArray();
            }

            for(int r=0; r<=m/2; r++){
                for(int c=m/2-r; c<=m/2+r; c++){
                    sum += map[r][c]-'0';
                }
            }

            for(int r=m/2-1; r>=0; r-- ){
                for(int c=m/2-r; c<=m/2+r; c++){
                    sum += map[m-r-1][c]-'0';
                }
            }

            sb.append(sum).append("\n");

        }
        System.out.println(sb);

    }
}
