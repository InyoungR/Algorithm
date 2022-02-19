package Bitmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Jun {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = 0;
        for(int i = N - 1; i >= 0; i--) {			// r, c 모두 맨 앞자리부터 교차한다.
            result <<= 1;							// 현재까지 정답 * 2
            result += (r >> i) & 1;					// r 자리 추가
            result <<= 1;							// 현재까지 정답 * 2
            result += (c >> i) & 1;					// c 자리 추가
        }

        System.out.printf("%d", result);
    }

}


/*
 * 반씩 잘라가면서 생각하면 편하다.
 *
 *   0  1  4  5
 *   2  3  6  7
 *   8  9 12 13
 *  10 11 14 15
 *
 *  9의 위치는 (2, 1)
 *  4칸짜리를 붙여가며 크기를 크게 만들어가므로 r -> c -> r -> c ...의 순서로 나누어진다. (0 ~ 7 & {8 ~ 15}) -> ({8 ~ 11} & 12 ~ 15) -> ({8 ~ 9} & 10 ~ 11) -> (8 & {9})
 *
 *  r을 이진수로 표현하고 c를 이진수로 표현한 다음 두 수를 번갈아서 앞부터 쓰면 된다.
 *  2 = _0  _1  _0 (2)
 *  1 =  0   0   1 (2)
 *
 *  결과 : _0   0  _1   0  _0   1 = 9
 */

