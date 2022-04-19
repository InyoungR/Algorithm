package MonthTest;

import java.util.Scanner;

public class BJ_18442_우체국1 {
    static int V,P;
    static long L, result;
    static long [] houses;
    static boolean [] selected;
    static long [] answer, answer2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        V = sc.nextInt(); //마을의 개수
        P = sc.nextInt(); //경찰서 개수
        L = sc.nextLong(); //원의 둘레

        houses = new long[V];
        answer = new long [P];
        answer2 = new long [P];

        selected = new boolean[V];
        for(int i=0; i<V; i++){
            houses[i] = sc.nextLong();
        }

        result = Long.MAX_VALUE;
        choose(0,0);

        sb.append(result).append("\n");
        for(int i=0; i<P; i++){
            sb.append(answer2[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }

    static void choose(int idx, int cnt){
        if(cnt == P){
            getCnt();
            return;
        }
        for(int i=idx; i<V; i++){
            answer[cnt] = houses[i];
            choose(i+1, cnt+1);
        }
    }

    private static void getCnt() {
        long temp=0;
        for(int i=0; i<V; i++){
            long a = Long.MAX_VALUE;
            for(int j=0; j<P; j++){
                a = Math.min(a,getDist(houses[i],answer[j]));
            }
            temp += a;
        }

        if(temp<result){
            result = temp;
            answer2 = answer.clone();
        }
    }

    static long getDist(long a, long b){
        long x = Math.abs(a-b);
        long y = L-x;
        return Math.min(x,y);
    }
}
