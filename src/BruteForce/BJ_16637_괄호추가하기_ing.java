package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16637_괄호추가하기_ing {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int [] nums = new int [n/2+1];
        char [] ops = new char [n/2];
        String msg = bf.readLine();

        for(int i=0; i<n/2; i++){
            nums[i] = msg.charAt(2*i)-'0';
            ops[i] = msg.charAt(2*i+1);
        }
        nums[n/2] = msg.charAt(n-1)-'0';
    }

    static void DFS(int idx, int sum){

        //괄호 안치는 경우

        //괄호 치는 경우
    }

    static int calc(int num, int num2, char op){
        int answer = 0;
        switch(op){
            case '+':
                answer = num+num2;
                break;
            case '-':
                answer = num-num2;
                break;
            case '*':
                answer = num*num2;
                break;
        }
        return answer;
    }
}
