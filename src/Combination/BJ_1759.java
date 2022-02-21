package Combination;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_1759 {
    static int L, C;
    static List<Character> vowels = Arrays.asList('a','e','i','o','u');
    static char [] alphabets;
    static char [] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();//암호의 길이
        C = sc.nextInt(); //암호 후보 개수

        alphabets = new char [C];
        result = new char[L];

        for(int i=0; i<C; i++){
            alphabets[i] = sc.next().charAt(0);
        }
        Arrays.sort(alphabets);
        Combi(0,0);
        System.out.println(sb);
    }

    public static void Combi(int idx, int start){
        if(idx == L){
            int vow = 0;
            int conso = 0;
            for(char c : result){
                if (vowels.contains(c)) vow+=1;
                else conso +=1;
            }
            if(vow>=1 && conso >=2) {
                for(char c : result){
                    sb.append(c);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i=start; i<C; i++){
            result[idx] = alphabets[i];
            Combi(idx+1, i+1);
        }
    }
}
