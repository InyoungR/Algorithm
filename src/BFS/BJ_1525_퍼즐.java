package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1525_퍼즐 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> V = new HashSet<>();
        Queue<int[]> que = new LinkedList<>();
        int [] start = new int [2];

        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<3; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 0) {
                    a= 9;
                    start[1] = 9-(3*i+j+1);//8
                }
                start[0] = start[0]*10 + a;//687524391
            }
        }

        boolean flag = false;
        V.add(start[0]);
        if(start[0] != 123456789) que.add(start);
        else flag = true;
        int cnt = 0;
        int [] d = {-1,1,3,-3};

        outer: while(!que.isEmpty()){
            int s = que.size();
            cnt++;

            for(int i=0; i<s; i++){
                int [] nums = que.poll();

                int num = nums[0];
                int digit = nums[1];
                num -= (int) Math.pow(10, digit)*9;

                for(int j=0; j<4; j++){
                    if(digit%3 == 0 && j==0) continue;
                    if(digit%3 == 2 && j==1) continue;

                    int digitN = digit + d[j];
                    if(digitN<0 || digitN>8) continue;

                    int change = num/(int) Math.pow(10, digitN);
                    change %= 10;

                    int next = num - (change * (int) Math.pow(10,digitN));
                    next += 9 * Math.pow(10,digitN);
                    next += change * Math.pow(10, digit);

                    if(next == 123456789) {flag = true; break outer;}
                    if(V.contains(next)) continue;

                    V.add(next);
                    que.add(new int [] {next, digitN});
                }
            }
        }

        if(flag)System.out.println(cnt);
        else System.out.println(-1);
    }
}
