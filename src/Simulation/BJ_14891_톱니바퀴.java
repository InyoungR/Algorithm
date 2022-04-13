package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14891_톱니바퀴 {
    static char[][] gears;
    static int [] pointers;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        gears = new char[4][8];
        pointers = new int [4];

        for(int i=0; i<4; i++){
            gears[i]= bf.readLine().toCharArray();
        }

        int n = Integer.parseInt(bf.readLine());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            Move(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
        }
        int result = 0;

        if(gears[0][pointers[0]]=='1') result += 1;
        if(gears[1][pointers[1]]=='1') result += 2;
        if(gears[2][pointers[2]]=='1') result += 4;
        if(gears[3][pointers[3]]=='1') result += 8;

        System.out.println(result);
    }

    static void Move(int idx, int type){

        Queue<int[]> que = new LinkedList<>();
        que.add(new int [] {idx, type});
        boolean [] V = new boolean[4];
        V[idx] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();

            int left = cur[0]-1;
            int right = cur[0]+1;

            if(left>=0 && !V[left]){
                int r = pointers[left]+2>=8? pointers[left]+2-8:pointers[left]+2;
                int l = pointers[cur[0]]-2<0?8+ pointers[cur[0]]-2: pointers[cur[0]]-2;
                if(gears[left][r] != gears[cur[0]][l]){
                    V[left] = true;
                    que.add(new int [] {left, -1*cur[1]});
                }
            }

            if(right<4 && !V[right]){
                int r = pointers[cur[0]]+2>=8? pointers[cur[0]]+2-8:pointers[cur[0]]+2;
                int l = pointers[right]-2<0?8+ pointers[right]-2: pointers[right]-2;
                if(gears[cur[0]][r] != gears[right][l]){
                    V[right] = true;
                    que.add(new int [] {right, -1*cur[1]});
                }
            }

            if(cur[1] == 1) pointers[cur[0]] -=1;
            if(cur[1] == -1) pointers[cur[0]] +=1;

            if(pointers[cur[0]]<0) pointers[cur[0]] = 7;
            if(pointers[cur[0]]>=8) pointers[cur[0]] = 0;
        }
    }
}
