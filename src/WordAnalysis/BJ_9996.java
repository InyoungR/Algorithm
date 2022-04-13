package WordAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        String pattern = bf.readLine();
        int p = pattern.indexOf("*");
        int pp = pattern.length();
        outer : for(int i=0; i<N; i++){
            String word = bf.readLine();
            if(word.length() < pp-1){
                sb.append("NE").append("\n");
                continue outer;
            }
            for(int j=0; j<p; j++){
                if(pattern.charAt(j) != word.charAt(j)){
                    sb.append("NE").append("\n");
                    continue outer;
                }
            }
            for(int j=1; pp-j>p; j++){
                if(pattern.charAt(pp-j) != word.charAt(word.length()-j)){
                    sb.append("NE").append("\n");
                    continue outer;
                }
            }
            sb.append("DA").append("\n");
        }
        System.out.println(sb);
    }
}
