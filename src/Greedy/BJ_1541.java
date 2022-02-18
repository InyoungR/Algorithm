package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = bf.readLine().split("-");

        for(int i=0; i<inputs.length; i++){
            String temp [];
            if(inputs[i].contains("+")){
                int num=0;
                temp = inputs[i].split("\\+");
                for(String txt: temp){
                    num += Integer.parseInt(txt);
                }
                inputs[i] = String.valueOf(num);
            }
        }

        int num = Integer.parseInt(inputs[0]);

        for(int i=1; i<inputs.length; i++){
            num -= Integer.parseInt(inputs[i]);
        }

        System.out.println(num);
    }
}
