package 문제풀이.DP.이친수_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_황병수 {

    static int N;
    static int[] NList;

    // NList[1][0] = 0 = a
    // NList[1][1] = 1 = w

    // NList[2][0] = 1
    // NList[2][1] = 0

    // NList[3][0] = 1
    // NList[3][1] = 1



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        NList = new int[N + 1];

        // 초기값 설정
        NList[1] = 1;

        if (N == 1 || N == 2) {
            System.out.println(N);
            return;
        }

        NList[2] = 0;

        // 점화식 , NList[i] = NList[i - 1] == 1? 0 : 1;

//        for (int i = 1; i < N; i++) {
//            NList[i] =
//        }
    }
}
