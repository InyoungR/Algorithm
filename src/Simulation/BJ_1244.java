package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244 {
    static int [] switches;
    static int S;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(bf.readLine());
        switches = new int[S+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=S; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int N = Integer.parseInt(bf.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            switch(st.nextToken()){
                case"1":
                    boy(Integer.parseInt(st.nextToken()));
                    break;
                case"2":
                    girl(Integer.parseInt(st.nextToken()));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;

        while(i<=S){
            sb.append(switches[i]).append(" ");
            if(i%20 == 0) sb.append("\n");
            i +=1;
        }

        System.out.println(sb);
    }

    public static void girl(int x){
        switches[x] = switches[x]^1;
        int a = 1;
        while(x-a>0 && x+a<=S && switches[x+a] == switches[x-a]){
            switches[x+a] = switches[x+a]^1;
            switches[x-a] = switches[x-a]^1;
            a += 1;
        }
    }

    public static void boy(int x){
        int a = 1;

        while(x*a<=S){
            switches[x*a] = switches[x*a]^1;
            a +=1;
        }
    }
}
