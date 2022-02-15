package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
public class JO_1828_Fail {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bf.readLine());
        List<int []> fridges = new ArrayList<>();
        int cnt = 1;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            boolean flag = false;

            if(fridges.isEmpty()) {
                fridges.add(new int []{low, high});
                continue;
            }

            for(int j=0; j<fridges.size(); j++){
                int low2 = fridges.get(j)[0];
                int high2 = fridges.get(j)[1];

                if (low2<=high && low<=high2) {
                    fridges.get(j)[0] = Math.max(low, low2);
                    fridges.get(j)[1] = Math.min(high, high2);
                    flag = true;
                }
            }

            if(!flag){
                fridges.add(new int [] {low, high});
            }
        }
        System.out.println(fridges.size());
    }

}
