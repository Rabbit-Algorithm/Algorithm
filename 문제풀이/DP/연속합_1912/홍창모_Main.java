package 문제풀이.DP.연속합_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;

public class 홍창모_Main {

    static int N, MAX = Integer.MIN_VALUE;

    static int[] ARR;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ARR = new int[N+1];
        ARR[0] = 0;

        for (int i = 0; i < N; i++) {
            int nextInt = Integer.parseInt(st.nextToken());
            ARR[i+1] = Math.max(ARR[i] + nextInt, nextInt);
            MAX = Math.max(ARR[i+1], MAX);
        }

        System.out.println(MAX);

    }
}
