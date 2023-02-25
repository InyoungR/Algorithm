package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2138_전구와스위치 {
    static class LightBulb{
        int n;
        boolean [] lightbulb;

        public LightBulb(int n, String input) {
            this.n = n;
            lightbulb = new boolean[n];

            for(int i=0; i<n; i++){
                if(input.charAt(i) == '1'){
                    lightbulb[i] = true;
                }
            }
        }

        public void turnSwitch(int i){
            if(i>=1) lightbulb[i-1] = !lightbulb[i-1];
            lightbulb[i] = !lightbulb[i];
            if(i<n-1) lightbulb[i+1] = !lightbulb[i+1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LightBulb lightBulb = (LightBulb) o;
            return Arrays.equals(lightbulb, lightBulb.lightbulb);
        }

        public boolean equalsI(int i, LightBulb o){
            if(lightbulb[i] == o.lightbulb[i]) return true;
            else return false;
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(lightbulb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String input = bf.readLine();
        String input2 = bf.readLine();

        LightBulb light = new LightBulb(n, input);
        LightBulb lightLater = new LightBulb(n, input2);
        int answer = 0;
        int result = 987654321;

        //첫 번째 누른 경우
        light.turnSwitch(0);
        answer = turnSwitches(n, light, lightLater);

        if(light.equals(lightLater)) result = answer+1;

        //첫 번째 안 누른 경우
        light = new LightBulb(n, input);
        answer = turnSwitches(n, light, lightLater);

        if(light.equals(lightLater)) result = Math.min(result, answer);

        if(result == 987654321) System.out.println(-1);
        else System.out.println(result);



    }

    public static int turnSwitches(int n, LightBulb light, LightBulb lightLater){
        int answer = 0;
        for(int i=1; i<n; i++){
            if(!light.equalsI(i-1, lightLater)) {
                light.turnSwitch(i);
                answer++;
            }
        }
        return answer;
    }
}
