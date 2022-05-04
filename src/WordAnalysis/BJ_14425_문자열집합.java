package WordAnalysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ_14425_문자열집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        HashSet<String> words = new HashSet<>();

        for(int i=0; i<n; i++){
            words.add(bf.readLine());
        }

        for(int i=0; i<m; i++){
            if(words.contains(bf.readLine())){
                result++;
            }
        }

        System.out.println(result);
    }
}
