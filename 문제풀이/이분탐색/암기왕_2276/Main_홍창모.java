package 문제풀이.이분탐색.암기왕_2276;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int T, N, M;
    static int[] ARR;
    static StringBuilder SB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        SB = new StringBuilder();
        StringTokenizer st;

        for( int t = 0; t < T; t++ ) {
            N = Integer.parseInt(br.readLine());
            ARR = new int[N];

            st = new StringTokenizer(br.readLine());

            for( int i = 0; i < N; i++ ) {
                ARR[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            Arrays.sort(ARR);

            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());
                binarySearch(target);
            }
        }

        System.out.println(SB);
    }

    private static void binarySearch(int target) {
        int left = 0;
        int right = N-1;

        int answer = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if( ARR[mid] == target ) {
                answer = 1;
                break;
            }

            if( ARR[mid] > target ) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        SB.append(answer).append("\n");
    }
}
