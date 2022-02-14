package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BJ_10874 모든 순열 https://www.acmicpc.net/problem/10974
public class NextPermutation {
    static int N;
    static int [] input;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(bf.readLine());
        input = new int [N];

        for(int i=0; i<N; i++){
            input[i] = i+1;
        }

        do{
            for(int i=0; i<N; i++){
                sb.append(input[i]).append(" ");
            } sb.append("\n");
        } while (Np());

        System.out.println(sb);
    }

    public static boolean Np(){
        //1. 교환위치 찾기
        int i = N-1;
        while(i>0 && input[i-1]>=input[i]) --i;

        if(i==0) return false;

        //2. 교환대상 찾기
        int j= N-1;
        while(input[i-1]>=input[j]) --j;

        //3. 위치 바꾸기
        swap(i-1,j);

        //4. peak 이상의 값들을 오름차순 정렬
        int k = N-1;
        while(i<k) swap(i++, k--);
        return true;
    }

    public static void swap(int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
