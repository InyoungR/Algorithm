package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559 {
    static int K, N, result;
    static int[] temperature;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken()); //총 N개의 수
        K = Integer.parseInt(st.nextToken()); //연속 K개의 합중 최대를 구하기

        st = new StringTokenizer(bf.readLine());
        temperature = new int [N];
        for(int i=0; i<N; i++){
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int j=0; j<K; j++){
            sum += temperature[j];
        }
        result = sum;

        for(int i=0; i<N-K; i++){
            sum -= temperature[i];
            sum += temperature[i+K];
            if(sum>result) result = sum;
        }

        System.out.println(result);
    }

}
