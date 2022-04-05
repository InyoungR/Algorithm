package DP;

import java.util.Scanner;

public class BJ_1106_ing {
    static class city {
        int cost, effect;

        public city(int cost, int effect) {
            this.cost = cost;
            this.effect = effect;
        }
    }
    static city[] cities;
    static int costs[];
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goal = sc.nextInt();
        n = sc.nextInt();

        cities = new city[n];

        for (int i = 0; i < n; i++) {
            cities[i] = new city(sc.nextInt(), sc.nextInt());
        }

        costs = new int [goal+1];
        DFS(goal);
        System.out.println(costs[0]);
    }

    static void DFS(int cnt){

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int temp = cnt-cities[i].effect;
            if(temp<0) continue;
            if(costs[temp] != 0){
                costs[temp] = Math.min(costs[temp], costs[cnt]+cities[i].cost);
            } else {
                costs[temp] = costs[cnt]+cities[i].cost;
            }
            DFS(temp);
        }
    }
}
