package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int k = Integer.parseInt(st.nextToken()); //이미 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수

        int [] possess = new int [k];
        long result = 0;
        long max = 0;
        for(int i=0; i<k; i++){
            possess[i] = Integer.parseInt(bf.readLine());
        }

        long min = 0;
        max ++;
        long standard = 0;
        while(min<max){
            result = 0;
            standard = (max+min)/2;
            for(int i=0; i<k; i++){
                result += possess[i]/standard;
            }
            if(result<n){
                max = standard;
            } else {
                min=standard+1;
            }
        }
        System.out.println(min-1);
    }
}
