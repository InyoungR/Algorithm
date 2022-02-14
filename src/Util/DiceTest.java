package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceTest {

    static boolean [] isSelected = new boolean [7];
    static int [] dice = new int [3];
    static List<int[]> result = new ArrayList<int[]>();

    public static void main(String[] args) {
        dice4(0, 1);
        for(int i=0; i<result.size(); i++){
            System.out.println(Arrays.toString(result.get(i)));
        }
        System.out.printf("총 경우의 수 : %d%n", result.size());
    }

    static void dice1(int cnt){
        if(cnt == 3){
            result.add(dice.clone());
            return;
        }

        for(int i=1; i<7; i++){
            dice[cnt]=i;
            dice1(cnt+1);
        }
    }

    static void dice2(int cnt){
        if(cnt == 3){
            result.add(dice.clone());
            return;
        }

        for(int i=1; i<7; i++){
            if(isSelected[i])continue;
            dice[cnt]=i;
            isSelected[i]=true;
            dice2(cnt+1);
            isSelected[i]=false;
        }
    }

    static void dice3(int cnt, int start){
        if(cnt == 3){
            result.add(dice.clone());
            return;
        }

        for(int i=start; i<7; i++){
            dice[cnt]=i;
            dice3(cnt+1, i);
        }
    }

    static void dice4(int cnt, int start){
        if(cnt == 3){
            result.add(dice.clone());
            return;
        }

        for(int i=start; i<7; i++){
            dice[cnt]=i;
            dice4(cnt+1, i+1);
        }
    }



}
