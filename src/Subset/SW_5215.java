package Subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5215 {
    static Burger [] ingredients;
    static int N, L, result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            ingredients = new Burger[N];

            for(int j=0; j<N; j++){
                st = new StringTokenizer(bf.readLine());
                ingredients[j] = new Burger(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            result = 0;
            Combination(0,0,0);
            System.out.println(result);
        }
    }

    static void Combination (int cnt, int calorie, int score){

        if(calorie>L) return;
        result = Math.max(result, score);
        if(cnt==N) return;

        int score2 = ingredients[cnt].score;
        int calorie2 = ingredients[cnt].calorie;

        Combination(cnt+1, calorie+calorie2, score+score2);
        Combination(cnt+1, calorie, score);

    }

    static class Burger{
        int score;
        int calorie;

        public Burger(int score, int calorie) {
            this.score = score;
            this.calorie = calorie;
        }
    }
}


