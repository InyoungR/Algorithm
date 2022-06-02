package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
//A+(B*C*D)
//A*B-C*D/E -> AB*CD*E/-
public class BJ_1918_후위표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //'A' : 65 'Z' 90 나머지 부호들은 60보다 작다
        String msg = bf.readLine();

        Stack<Character> stack = new Stack<>();
        boolean flag = false;

        for(int i=0; i<msg.length(); i++){
            char a = msg.charAt(i);
            char b = '0';

            if(a>=65) sb.append(a);
            else if (a == '(') stack.add(a);
            else if (a == ')'){
                while(!stack.isEmpty() && (b = stack.pop())!='('){
                    sb.append(b);
                }
            } else {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(a)){
                    sb.append(stack.pop());
                }
                stack.push(a);
//                if(a == '*' || a == '/'){ //top의 우선순위는 낮거나 동일
//                    while (!stack.isEmpty() && (stack.peek()== '*' || stack.peek() == '/')) {
//                        sb.append(stack.pop());
//                    }
//                    stack.add(a);
//                } else { //top의 우선순위는 높거나 동일
//                    while(!stack.isEmpty() && stack.peek()!= '(') {
//                        sb.append(stack.pop());
//                    }
//                    stack.add(a);
//                }
            }

        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    public static int precedence(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        else return 0; //스택 안에는 '('도 들어올 수 있다. 하지만 '('는 꺼내져서는 안되기 때문에 제일 낮은 값을 반환하도록 한다.
    }
}
