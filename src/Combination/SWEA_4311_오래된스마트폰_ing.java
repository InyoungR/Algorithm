package Combination;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWEA_4311_오래된스마트폰_ing {
    static class Number{
        int num, digit;

        public Number(int num, int digit) {
            this.num = num;
            this.digit = digit;
        }
    }

    static int answer = 0, M = 0, goal = 0, N=0, O=0;
    static int [] nums, ops;
    static ArrayList<Number> nums2 = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/Combination/SWEA_4311.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

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

            answer = -1;
            getNums(0,0);
            if(answer == -1){
                for(int i=0; i<nums2.size(); i++){
                    if(nums2.get(i).num == 0) continue;
                    DFS(nums2.get(i).digit,nums2.get(i));
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void getNums(int cnt, int result){
        if(cnt == 3) return;

        //뒤에 숫자를 바로 붙이는 경우
        for(int i=0; i<N; i++){
            int a = result*10 + nums[i];
            if(a == goal) answer = Math.max(answer, cnt+1);
            nums2.add(new Number(a, cnt+1));
            if(a != 0) getNums(cnt +1, a);
        }
    }
    static void DFS(int cnt, Number result){
        if(answer != -1 && cnt>=answer) return;
        if(result.num == goal) answer = Math.max(answer, result.num);
        if(cnt == M-1) return;

        for(int j=0; j<O; j++){
            for(int i=0; i<nums2.size(); i++){
                Number num = nums2.get(i);
                if(num.num == 0) continue;
                if(result.digit+num.digit >= M-2) continue;

                int a = calc(result.num, num.num, ops[j]);
                int cnta = result.digit+num.digit+1;

                if(a<0 || a>999) continue;
                if(a == goal) {
                    answer = Math.max(answer, cnta+1);
                    continue;
                }
                DFS(cnta, new Number(a, cnta));
            }
        }

    }
    static int calc(int a, int b, int op){
        switch(op){
            case 1:
                return a+b;
            case 2:
                return a-b;
            case 3:
                return a*b;
            case 4:
                return a/b;

        }
        return -1;
    }
}
