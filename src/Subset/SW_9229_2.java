package Subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_9229_2 {

    public static void main(String[] args) throws IOException {
        int T, N, M, max, weight;
        int[] bags;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            bags = new int [N];
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++){
                bags[j] = Integer.parseInt(st.nextToken());
            }
            max=0;

            for(int j=0; j<N; j++){
                for(int k=j+1; k<N; k++){
                    weight= bags[j]+bags[k];
                    if(weight<=M && weight>max){
                        max = weight;
                    }
                }
            }

            if(max != 0) sb.append("#").append(i+1).append(" ").append(max).append("\n");
            else sb.append("#").append(i+1).append(" ").append(-1).append("\n");
        }
        System.out.println(sb.toString());
    }


}
