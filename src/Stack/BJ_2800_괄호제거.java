package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2800_괄호제거 {
    static class bracket implements Comparable<bracket>{
        int start, end;

        public bracket(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(bracket o) {
            return start-o.start;
        }
    }
    static StringBuilder sb = new StringBuilder();
    static String equa = null;
    static ArrayList<bracket> brackets;
    static PriorityQueue<String> que = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        equa = bf.readLine();
        Stack<Integer> stack = new Stack<>();
        brackets = new ArrayList<>();

        for(int i=0; i<equa.length(); i++){
            if(equa.charAt(i)=='('){
                stack.push(i);
            }else if(equa.charAt(i) == ')'){
                brackets.add(new bracket(stack.pop(),i));
            }
        }

        deleteBracket(equa, 0);

        sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        while(!que.isEmpty()){
            String str = que.poll();
            if(!set.contains(str)){
                sb.append(str).append("\n");
                set.add(str);
            }
        }
        System.out.println(sb);
    }
    //type 0은 열기 1은닫기
    static void deleteBracket(String str, int idx){
        if(idx>= brackets.size()) return;

        for(int i=idx; i<brackets.size(); i++){
            bracket brack = brackets.get(i);

            sb = new StringBuilder(str);
            sb.replace(brack.start, brack.start+1, " ");
            sb.replace(brack.end, brack.end+1, " ");
            que.add(sb.toString().replaceAll(" ",""));
            deleteBracket(sb.toString(), i+1);
            sb.replace(brack.start, brack.start+1, "(");
            sb.replace(brack.end, brack.end+1, ")");

        }

    }

}
