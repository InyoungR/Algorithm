package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1106 {
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

        costs = new int [goal+101];
        Arrays.fill(costs,987654321);
        costs[0] = 0;
        for(int i=0; i<goal; i++){
            for(int j=0; j<n; j++){
                costs[i+cities[j].effect] = Math.min(costs[i+cities[j].effect], costs[i]+cities[j].cost);
            }
        }
        int result = 987654321;

        for(int i=goal; i<goal+101; i++){
            result = Math.min(result, costs[i]);
        }
        System.out.println(result);

    }

}
