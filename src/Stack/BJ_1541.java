package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//https://www.acmicpc.net/problem/1541
public class BJ_1541 {
    static int N, result;
    static boolean [] numSelected, opSelected;
    static List<Integer> nums;
    static List<Character> operators;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] temp = bf.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int cnt=0;
        int num=0;
        nums = new ArrayList<>();
        operators = new ArrayList<>();
        for(int i=temp.length-1; i>=0; i--){
            char temp2 = temp[i];
            if(temp2-'0'>=0){
                num += (temp2-'0')*Math.pow(10,cnt);
                cnt +=1;
            } else {
                nums.add(num);
                operators.add(temp2);
                cnt = 0;
                num=0;

            }
        }
        nums.add(num);
        Collections.reverse(nums);
        Collections.reverse(operators);

        N = operators.size();
        numSelected = new boolean[N+1];
        opSelected = new boolean[N];
        result = 0;
    }

    static void Calculation(int cnt){
        if(cnt == N){

        }
        for(int i=0; i<N; i++){
            result += Calculator(nums.get(i), nums.get(i+1), operators.get(i));
            numSelected[i] = true;
            opSelected[i] = true;
            numSelected[i+1]=true;
            Calculation(cnt+1);
            numSelected[i] = false;
            opSelected[i] = false;
            numSelected[i+1]=false;
        }
    }

    static int Calculator(int a, int b, Character op){
        switch(op){
            case'+':
                return a+b;
            case'-':
                return a-b;
        }
    }
}
