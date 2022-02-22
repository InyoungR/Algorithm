package BruteForce;

import java.util.Scanner;

public class BJ_1681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String L = String.valueOf(sc.nextInt());
        int i = 1;

        while(N>0){
            if(checkL(i++, L)) N -=1;
        }

        System.out.println(i-1);
    }

    static boolean checkL(int x, String L){
        String temp = String.valueOf(x);
        if(temp.contains(L)) return false;
        else return true;
    }
}
