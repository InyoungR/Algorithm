package MonthTest;

import java.util.Scanner;

public class WithoutCrime {
    static int V,P,L, result;
    static int [] houses;
    static boolean [] selected;
    static int [] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int t=1; t<=T; t++){
            V = sc.nextInt(); //마을의 개수
            P = sc.nextInt(); //경찰서 개수
            L = sc.nextInt(); //원의 둘레

            houses = new int[V];
            answer = new int [P];

            selected = new boolean[V];
            for(int i=0; i<V; i++){
                houses[i] = sc.nextInt();
            }

            result = 987654321;

            choose(0,0);

            sb.append("#").append(t).append(" ").append(result).append("\n");
            for(int i=0; i<P; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void choose(int idx, int cnt){
        if(cnt == P){
            getCnt();
            return;
        }
        for(int i=idx; i<V; i++){
            selected[i] = true;
            choose(i+1, cnt+1);
            selected[i] = false;
        }
    }

    private static void getCnt() {
        int temp=0;
        for(int i=0; i<V; i++){
            if(selected[i]) continue;
            int a = 987654321;
            for(int j=0; j<V; j++){
                if(selected[j]){
                    a = Math.min(a,getDist(houses[i],houses[j]));
                }
            }
            temp += a;
        }

        if(temp<result){
            result = temp;
            int idx = 0;
            for(int i=0; i<V; i++){
                if(selected[i]) answer[idx++] = houses[i];
            }
        }
    }

    static int getDist(int a, int b){
        int x = Math.abs(a-b);
        int y = L-x;
        return Math.min(x,y);
    }
}
