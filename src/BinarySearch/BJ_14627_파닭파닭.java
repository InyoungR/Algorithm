package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14627_파닭파닭 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int pa = Integer.parseInt(st.nextToken());
        int padak = Integer.parseInt(st.nextToken());
        int pas [] = new int [pa];

        long sum = 0;
        for(int i=0; i<pa; i++){
            int temp = Integer.parseInt(bf.readLine());
            sum += temp;
            pas[i] = temp;
        }
        int max = 1000000000;
        int min = 1;
        int standard = 0;

        while(min<=max){
            int result = 0;
            standard = (max+min)/2;

            for(int i=0; i<pa; i++){
                result += pas[i]/standard;
            }

            if(result<padak) max = standard-1;
            else min = standard+1;
        }

        System.out.println(sum - max*(long)padak);
    }
}
