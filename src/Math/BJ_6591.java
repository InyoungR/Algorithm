package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_6591 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(n==0) break;
            if(r>n/2) r = n-r;

            double answer = 1;

            for(int i=n; i>n-r; i--){
                answer *= i;
            }
            for(int i=1; i<=r; i++){
                answer /=i;
            }

            sb.append((int)answer).append("\n");

        }
        System.out.println(sb);
    }
}
