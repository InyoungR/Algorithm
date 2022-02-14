package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    static boolean [] isSelected = new boolean [4];
    static int [] perm = new int [3];
    static List<int[]> result = new ArrayList<int[]>();

    public static void main(String[] args) {
        Permutation(0);
        for(int i=0; i<result.size(); i++){
            System.out.println(Arrays.toString(result.get(i)));
        }
    }

    static void Permutation(int cnt){
        if(cnt ==3 ) {
            result.add(perm.clone());
            return;
        }

        for(int i=1; i<4; i++){
            if(isSelected[i]) continue;
            perm[cnt] = i;
            isSelected[i] = true;
            Permutation(cnt+1);
            isSelected[i]=false;
        }

    }

}
