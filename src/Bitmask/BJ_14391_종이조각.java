package Bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14391_종이조각 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] nums = new int [N][M];

        for(int i=0; i<N; i++){
            String msg = bf.readLine();
            for(int j=0; j<M; j++){
                nums[i][j] = msg.charAt(j) - '0';
            }
        }

        int answer = 0;

        for(int i=0; i<(1<<(N*M)); i++){
            int sum = 0;
            for(int r=0; r<N; r++){
                int cur = 0;
                for(int c=0; c<M; c++){
                    int a = r*M+c;
                    if((i & 1<<a) == 0){
                        cur = cur*10 + nums[r][c];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            for(int c=0; c<M; c++){
                int cur = 0;
                for(int r=0; r<N; r++){
                    int a = r*M+c;
                    if((i & 1<<a) != 0){
                        cur = cur*10 + nums[r][c];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            answer = Math.max(answer,sum);
        }

        System.out.println(answer);
    }
}
