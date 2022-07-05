package WordAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1213_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();

        int[] words = new int [26];

        for(int i=0; i<input.length(); i++){
            char a = input.charAt(i);
            words[a-'A']++;
        }

        int cnt = 0;
        int middle = 0;
        for(int i=0; i<26; i++){
            if(words[i] % 2 !=0) {
                cnt++;
                middle = i;
            }
        }
        boolean flag = false;
        if(cnt>1) {
            System.out.println("I'm Sorry Hansoo");
            flag = true;
        }
        if(cnt==1 && input.length()%2 == 0) {
            System.out.println("I'm Sorry Hansoo");
            flag = true;
        }

        if(!flag){
            Stack<Character> front = new Stack<>();
            Stack<Character> back = new Stack<>();

            for(int i=0; i<26; i++){
                if(words[i] == 0) continue;

                while(words[i] >=2){
                    front.push((char) ('A'+i));
                    back.push((char) ('A'+i));

                    words[i] -=2;
                }
            }

            StringBuilder sb = new StringBuilder();

            for(char a : front){
                sb.append(a);
            }

            if(cnt==1) sb.append((char) ('A'+middle));

            while(!back.isEmpty()){
                sb.append(back.pop());
            }

            System.out.println(sb);

        }


    }
}
