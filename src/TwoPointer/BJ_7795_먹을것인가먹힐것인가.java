package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(bf.readLine());

        for(int t=0; t<T; t++){
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int A[] = new int [n];
            int B[] = new int [m];
            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<m; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int a = n-1;
            int b = 0;

            int cnt = 0;

            while(a>=0){
                b=0;
                while(b<m){
                    if(A[a]>B[b]) {
                        cnt++;
                        b++;
                    } else {
                        break;
                    }

                }
                a--;
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
