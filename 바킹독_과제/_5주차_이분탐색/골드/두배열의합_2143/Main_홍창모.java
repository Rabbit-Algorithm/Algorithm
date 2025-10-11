package _5주차_이분탐색.골드.두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int T, N, M;
    static int[] ARR1, ARR2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        ARR1 = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 1; i <= N; i++ ) {
            ARR1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        ARR2 = new int[M+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            ARR2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR1);



    }
}
