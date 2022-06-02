package RegularExpression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_14405_피카츄 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String pika = bf.readLine();
        String pattern = "(pi|ka|chu)+";
        boolean mat = pika.matches(pattern);
        if(mat) System.out.println("YES");
        else System.out.println("NO");
    }
}
