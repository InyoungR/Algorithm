package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2564 {
    static int W,H;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(bf.readLine());
        int [] stores = new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            stores[i] = getLoc(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        st = new StringTokenizer(bf.readLine());
        int dongkeun = getLoc(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );

        int result = 0;
        int T = 2*W + 2*H;
        for(int i=0; i<n; i++){
            int dist = Math.abs(dongkeun-stores[i]);
            result += Math.min(dist, T-dist);
        }
        System.out.println(result);
    }

    static int getLoc(int axis, int dist){
        int loc = 0;
        switch(axis){
            case 1:
                loc = W+H+dist;
                break;
            case 2:
                loc = W-dist;
                break;
            case 3:
                loc = W+H-dist;
                break;
            case 4:
                loc = 2*W + H + dist;
                break;
        }
        return loc;
    }
}
