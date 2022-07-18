package Graph;

import java.util.*;

public class BJ_2251_물통 {
    static class Bucket{
        int size, water;

        public Bucket(int size, int water) {
            this.size = size;
            this.water = water;
        }
    }
    static Bucket [] buckets = new Bucket[3];
    static boolean [][][] V = new boolean [201][201][201];
    static PriorityQueue<Integer> answer = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            if(i<2) buckets[i] = new Bucket(sc.nextInt(), 0);
            else {
                int a = sc.nextInt();
                buckets[i] = new Bucket(a,a);
            }
        }

        BFS();

        int s = answer.size();
        StringBuilder sb = new StringBuilder();
        int prev = -1;

        for(int i=0; i<s; i++){
            int cur = answer.poll();
            if(prev == cur) continue;
            sb.append(cur).append(" ");
            prev = cur;
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }

    static void BFS(){
        Queue<Bucket[]> que = new LinkedList<>();
        V[buckets[0].water][buckets[1].water][buckets[2].water] = true;
        que.add(buckets);

        while(!que.isEmpty()){

            Bucket[] cur = que.poll();

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i==j) continue;
                    Bucket[] next;
                    if(cur[i].water!=0 && (cur[j].water !=cur[j].size)) next = Pour(i,j,cur);
                    else continue;

                    if(next[0].water == 0) answer.add(next[2].water);
                    if(V[next[0].water][next[1].water][next[2].water]) continue;

                    V[next[0].water][next[1].water][next[2].water] = true;
                    que.add(next);
                }
            }
        }


    }

    static Bucket[] Pour(int from, int to, Bucket[] buckets2){
        Bucket[] buckets = new Bucket[3];

        for(int i=0; i<3; i++){
            buckets[i] = new Bucket(buckets2[i].size,buckets2[i].water);
        }

        Bucket f = buckets[from];
        Bucket t = buckets[to];

        //빈공간보다 넣어야 할 물이 더 많다.
        if(f.water >= t.size-t.water){
            f.water -= (t.size-t.water);
            t.water = t.size;
        } else { //넣어야 할 물보다 빈공간이 더 크다
            t.water += f.water;
            f.water = 0;
        }

        buckets[from] = f;
        buckets[to] = t;

        return buckets;
    }

}
