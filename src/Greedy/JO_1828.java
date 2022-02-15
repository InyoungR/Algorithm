package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1828 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        Chemical [] fridges = new Chemical[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            fridges[i] = new Chemical(low, high);

        }

        Arrays.sort(fridges);
        int max = fridges[0].high;
        int cnt = 1;
        for(int i=0; i<N; i++){
            if(fridges[i].low>max){
                cnt +=1;
                max = fridges[i].high;
            }
        }

        System.out.println(cnt);
    }

    static class Chemical implements Comparable<Chemical> {
        int low, high;

        public Chemical(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Chemical o) {
            return this.high-o.high;
        }
    }

}
