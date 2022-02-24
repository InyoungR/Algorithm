package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2116 {
    static class Dice {
        int A, B, C, D, E, F;

        public Dice(int a, int b, int c, int d, int e, int f) {
            A = a;
            B = b;
            C = c;
            D = d;
            E = e;
            F = f;
        }

        public int getO(int x){
            if(x==A) return F;
            else if(x==B) return D;
            else if(x==C) return E;
            else if(x==D) return B;
            else if(x==E) return C;
            else return A;
        }

        public int getMax(int x){
            if(x==A || x==F) return Math.max(Math.max(B,C), Math.max(D,E));
            else if(x==B || x==D) return Math.max(Math.max(A,C), Math.max(F,E));
            else return Math.max(Math.max(A,B), Math.max(D,F));
        }
    }
    static Dice [] dices;
    static int N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        dices = new Dice [N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            dices[i] = new Dice(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        result = 0;
        for(int i=1; i<=6; i++){
            DFS(1, dices[0].getO(i), dices[0].getMax(i));
        }

        System.out.println(result);
    }
    static void DFS(int idx, int up, int sum){
        if(idx==N){
            result = Math.max(sum,result);
            return;
        }

        DFS(idx+1, dices[idx].getO(up), sum+dices[idx].getMax(up));
    }
}
