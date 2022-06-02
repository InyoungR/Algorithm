package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_1865_동철이의일분배 {
    static class Percent implements Comparable<Percent>{
        int i,j,percent;

        public Percent(int i, int j, int percent) {
            this.i = i;
            this.j = j;
            this.percent = percent;
        }

        @Override
        public int compareTo(Percent o) {
            return o.percent - percent;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(bf.readLine());

            boolean [] checkI = new boolean [n];
            boolean [] checkJ = new boolean [n];
            PriorityQueue<Percent> que = new PriorityQueue<>();
            double result = 1;

            for(int i=0; i<n; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j=0; j<n; j++){
                    int a = Integer.parseInt(st.nextToken());
                    que.add(new Percent(i,j,a));
                }
            }

            while(!que.isEmpty()){
                Percent cur = que.poll();

                if(checkI[cur.i] || checkJ[cur.j]) continue;

                result *= cur.percent/100.0;
                checkI[cur.i] = true;
                checkJ[cur.j] = true;
            }

            sb.append('#').append(t).append(" ").append(String.format(%d, result*100)).append("\n");

        }

        System.out.println(sb);
    }
}
