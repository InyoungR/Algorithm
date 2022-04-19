package WordAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935_문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char [] text = bf.readLine().toCharArray();
        char [] pattern = bf.readLine().toCharArray();

        int tLength = text.length, pLength = pattern.length;
        char [] result = new char[tLength];

        int idx = -1;
       for(int i=0; i<tLength; i++){
           result[++idx] = text[i];
           if(idx<pLength-1) continue;
           boolean flag = true;

           if(result[idx] == pattern[pLength-1]){
               int idx2 = idx-1;
               for(int j=pLength-2; j>=0; j-- ){
                   if(result[idx2--] != pattern[j]){
                       flag = false;
                       break;
                   }
               }
               if(flag) idx = idx2;
           }
       }
        if(idx == -1) sb.append("FRULA");
        else {
            for(int i=0; i<=idx; i++){
                sb.append(result[i]);
            }
        }
        System.out.println(sb);
    }

}
