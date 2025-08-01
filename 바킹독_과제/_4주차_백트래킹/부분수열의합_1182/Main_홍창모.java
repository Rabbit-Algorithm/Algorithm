package _4주차_백트래킹.부분수열의합_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, S, COUNT;
    static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        ARR = new int[N];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0,0);
        if( S == 0 ) COUNT--;
        System.out.println(COUNT);
    }

    private static void backtracking(int index, int sum) {
        if (index == N) {
            if (sum == S) COUNT++;
            return;
        }

        // 포함하는 경우
        backtracking(index + 1, sum + ARR[index]);

        // 포함하지 않는 경우
        backtracking(index + 1, sum);
    }
}
