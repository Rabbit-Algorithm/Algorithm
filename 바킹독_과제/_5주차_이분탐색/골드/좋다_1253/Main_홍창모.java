package _5주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, ANSWER;
    static int[] ARR;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ARR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR);

        for (int i = 0; i < N; i++) {
            twoPoint(ARR[i], i);
        }

        System.out.println(ANSWER);

    }

    private static void twoPoint(int target, int idx) {

        int lt = 0;
        int rt = N-1;

        while (lt < rt) {

            if( idx == lt ) {
                lt++;
                continue;
            } else if( idx == rt ) {
                rt--;
                continue;
            }

            int sum = ARR[lt] + ARR[rt];

            if( sum == target ) {
                ANSWER++;
                return;
            }

            if( sum < target ) {
                lt++;
            } else {
                rt--;
            }

        }

    }
}
