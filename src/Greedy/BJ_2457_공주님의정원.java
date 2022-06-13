package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2457_공주님의정원 {
    static class Flower implements Comparable<Flower>{
        int bloomM,bloomD, fallM, fallD;

        public Flower(int bloomM, int bloomD, int fallM, int fallD) {
            this.bloomM = bloomM;
            this.bloomD = bloomD;
            this.fallM = fallM;
            this.fallD = fallD;
        }

        @Override
        public int compareTo(Flower o) {
            if (fallM != o.fallM) return o.fallM - fallM;
            else return o.fallD - fallD;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(bf.readLine());

        PriorityQueue<Flower> que0 = new PriorityQueue<>((o1, o2) -> {
            if(o1.bloomM != o2.bloomM) return o1.bloomM - o2.bloomM;
            else return o1.bloomD - o2.bloomD;
        });

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());

            que0.add(new Flower(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }


        int [] date = {3,1};
        PriorityQueue<Flower> que = null;
        int result = 0;

        while(date[0]<12 && !que0.isEmpty()){
            que = new PriorityQueue<>();

            int s = que0.size();
            for(int i=0; i<s; i++){
                Flower f = que0.peek();
                if((f.bloomM<date[0]) || (f.bloomM==date[0] && f.bloomD<=date[1])){
                    que.add(que0.poll());
                }
            }

            if(que.isEmpty()){
                result = 0;
                break;
            }
            Flower f = que.poll();
            date[0] = f.fallM;
            date[1] = f.fallD;
            result++;
        }
        if(date[0]<12) result = 0;
        System.out.println(result);
    }
}
