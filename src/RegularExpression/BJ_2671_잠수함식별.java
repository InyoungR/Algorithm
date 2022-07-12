package RegularExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BJ_2671_잠수함식별 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String pattern = "[(100*1*)|(01)]*";

        boolean result = Pattern.matches(pattern, input);


    }
}
