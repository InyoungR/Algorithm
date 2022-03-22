package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        char king []= input(st.nextToken());
        char stone []= input(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            String input = bf.readLine();
            if(input.length()==1){
                if(check(king,input)){
                    move(king,input,0);
                }
                if(king[0] == stone[0] && king[1] == stone[1]) {
                    if(check(stone,input)) move(stone,input,0);
                    else move(king,input,1);
                }
            } else{
                if(check(king,input.substring(0,1))&& check(king,input.substring(1))){
                    move(king,input.substring(0,1),0);
                    move(king,input.substring(1),0);
                }
                if(king[0] == stone[0] && king[1] == stone[1]){
                    if(check(stone,input.substring(0,1))&& check(stone,input.substring(1))) {
                        move(stone,input.substring(0,1),0);
                        move(stone,input.substring(1),0);
                    }
                    else {
                        move(king,input.substring(0,1),1);
                        move(king,input.substring(1),1);
                    }
                }
            }
        }

        System.out.print(king[0]);
        System.out.print(king[1]);
        System.out.println();
        System.out.print(stone[0]);
        System.out.print(stone[1]);

    }
    static boolean check (char [] loc, String d) {
        switch(d){
            case"R":
                if(loc[0]+1<='H') return true;
                break;
            case "L":
                if(loc[0]-1>='A') return true;
                break;
            case "B":
                if(loc[1]-1>='1') return true;
                break;
            case "T":
                if(loc[1]+1<='8') return true;
                break;
        }
        return false;
    }
    static char [] move (char [] loc, String d, int forward) { //forward 1이면 뒤로
        if(forward == 0){
            switch(d){
                case"R":
                    if(loc[0]+1<='H') loc[0] += 1;
                    break;
                case "L":
                    if(loc[0]-1>='A') loc[0] -= 1;
                    break;
                case "B":
                    if(loc[1]-1>='1') loc[1] -= 1;
                    break;
                case "T":
                    if(loc[1]+1<='8') loc[1] += 1;
                    break;
            }
        }else {
            switch(d){
                case"R":
                    if(loc[0]-1>='A') loc[0] -= 1;
                    break;
                case "L":
                    if(loc[0]+1<='H') loc[0] += 1;
                    break;
                case "B":
                    if(loc[1]+1<='8') loc[1] += 1;
                    break;
                case "T":
                    if(loc[1]-1>='1') loc[1] -= 1;
                    break;
            }
        }
        return loc;
    }
    static char[] input(String a){
        char [] temp = new char[2];
        temp[0] = a.charAt(0);
        temp[1] = a.charAt(1);
        return temp;
    }
}
