package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {
    static int [] combi = new int [3];
    static List<int[]> result = new ArrayList<int[]>();

    public static void main(String[] args) {
        Combination(0, 1);
        for(int i=0; i<result.size(); i++){
            System.out.println(Arrays.toString(result.get(i)));
        }
    }

    static void Combination(int cnt, int start){
        if(cnt ==3 ) {
            result.add(combi.clone());
            return;
        }

        for(int i=start; i<6; i++){
            combi[cnt] = i;
            Combination(cnt+1, i+1);
        }

    }

}

