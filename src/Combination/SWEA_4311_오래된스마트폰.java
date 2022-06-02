package Combination;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_4311_오래된스마트폰 {
    static HashMap<Integer,Character> op = new HashMap<>();
    static int answer = 0, M = 0, goal = 0, N=0, O=0;
    static int [] nums, ops;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./Combination/SWEA_4311.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        op.put(1,'+');
        op.put(2, '-');
        op.put(3, '*');
        op.put(4, '/');

        int T = Integer.parseInt(bf.readLine());

        for(int t=1; t<=T; t++){
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken()); //터치가능숫자
            O = Integer.parseInt(st.nextToken()); //터치가능 연산자 수
            M = Integer.parseInt(st.nextToken()); //최대 터치가능 횟수

            nums = new int [N];
            ops = new int [O];

            st = new StringTokenizer(bf.readLine());

            for(int i=0; i<N; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(bf.readLine());
            for(int i=0; i<O; i++){
                ops[i] = Integer.parseInt(st.nextToken());
            }

            goal = Integer.parseInt(bf.readLine());

            answer = 0;
        }
    }

    static void DFS(int cnt, int result){
        if(result == goal) answer = Math.max(answer, result);
        if(cnt == M) return;

        //뒤에 숫자를 바로 붙이는 경우
        for(int i=0; i<N; i++){
            DFS(cnt +1, result*10+nums[i]);
        }
        //연산을 하는 경우
        if(cnt >=1){
            for(int i=0; i<O; i++){
                for(int j=0; j<N; j++){
                    if(ops[i] == 4 && nums[j] == 0) continue;
                    DFS(cnt+2, )
                }
            }
        }
    }
    static int calc(int a, int b, int op){
        switch(op){
            case 1:
                return a+b;
                break;
            case 2:
                return a-b;
                break;
            case 3:
                return a*b;
                break;
            case 4:
                return a/b;
                break;
        }

    }
}
