package TwoPolonger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_7453_합이0인네정수_ing {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(bf.readLine());

        long [] A = new long [n];
        long [] B = new long [n];
        long [] C = new long [n];
        long [] D = new long [n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        int c = n/2;
        int d = n/2;
        long sum = 0;
        long cnt = 0;

        for(int a=0; a<n; a++){
            sum = A[a];
            for(int b=0; b<n; b++){
                sum += B[b];
                c= n/2;
                d= n/2;


            }
        }

    }
}
