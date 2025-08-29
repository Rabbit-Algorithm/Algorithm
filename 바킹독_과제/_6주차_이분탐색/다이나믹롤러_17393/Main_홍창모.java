package 바킹독_과제._6주차_이분탐색.다이나믹롤러_17393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N;
    static long[][] INK_LIST;
    static StringTokenizer st;
    static StringBuilder SB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        INK_LIST = new long[2][N];

        for( int i = 0; i < 2; i++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < N; j++ ) {
                INK_LIST[i][j] = Long.parseLong(st.nextToken());
            }
        }

        SB = new StringBuilder();

        for( int i = 0; i < N; i++ ) {
            binarySearch(INK_LIST[0][i], i);
        }

        System.out.println(SB);
    }

    private static void binarySearch(long target, int idx) {
        int left = idx;
        int right = N-1;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            if( INK_LIST[1][mid] > target ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        SB.append(right-idx).append(" ");
    }
}
