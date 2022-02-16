package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.acmicpc.net/problem/1541
public class BJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char [] temp = bf.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int cnt=0;
        int num=0;
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        for(int i=temp.length; i>=0; i--){
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
    }
}
