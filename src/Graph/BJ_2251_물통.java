package Graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_2251_물통 {
    static class Bucket {
        int size, water;

        public Bucket(int size, int water) {
            this.size = size;
            this.water = water;
        }
    }
    static Bucket [] buckets = new Bucket[3];
    static boolean [][][] V = new boolean [201][201][201];
    static PriorityQueue<Integer> que = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<3; i++){
            if(i<2) buckets[i] = new Bucket(sc.nextInt(), 0);
            else {
                int a = sc.nextInt();
                buckets[i] = new Bucket(a,a);
            }
        }

    }

    static void DFS(){
        if(buckets[0].water == 0){
            que.add(buckets[2].water);
            return;
        }


    }

    static void Pour(int from, int to){
        Bucket f = buckets[from];
        Bucket t = buckets[to];

        if(f.water >= t.size){
            t.water = t.size;
            f.water -= t.size;
        } else {
            t.water = f.water;
            f.water = 0;
        }

        buckets[from] = f;
        buckets[to] = t;
    }

}
