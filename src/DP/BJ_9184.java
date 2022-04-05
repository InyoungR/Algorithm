package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9184 {
    static int [][][] memos = new int [21][21][21];;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String msg;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<21; i++){
            for(int j=0; j<21; j++){
                for(int k=0; k<21; k++){
                    if(i == 0 || j == 0 || k ==0) memos[i][j][k] = 1;
                    else memos[i][j][k] = -1;
                }
            }
        }
        while((msg=bf.readLine())!=null){
            st = new StringTokenizer(msg);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1) break;

            int answer = w(a,b,c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int w(int a, int b, int c){
        if(a<=0 || b<=0 || c<= 0) return 1;
        if(a>20 || b> 20 || c>20) {
            if(memos[20][20][20] == -1) memos[20][20][20] = w(20,20,20);
            return memos[20][20][20];
        }
        if(a<b && b<c){
            if(memos[a][b][c] == -1) memos[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1)- w(a,b-1,c);
            return memos[a][b][c];
        }
        if(memos[a][b][c] == -1) memos[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        return memos[a][b][c];

    }
}
