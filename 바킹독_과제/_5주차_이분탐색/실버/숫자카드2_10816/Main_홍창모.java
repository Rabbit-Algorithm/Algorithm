package 바킹독_과제._5주차_이분탐색.실버.숫자카드2_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static int[] ARR1, ARR2;
    static StringBuilder SB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ARR1 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            ARR1[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        ARR2 = new int[M];
        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < M; i++ ) {
            ARR2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ARR1);
        SB = new StringBuilder();

        for( int i = 0; i < M; i++ ) {
            int cnt = upperBound(ARR2[i]) - lowerBound(ARR2[i]);
            SB.append(cnt).append(" ");
        }

        System.out.println(SB);
    }

    public static int lowerBound(int target) {
        // target이 시작하는 가장 왼쪽 인덱스를 찾는다.
        int lt = 0;
        int rt = N;

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            if (ARR1[mid] >= target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }

    public static int upperBound(int target) {

        // target이 끝나는 가장 오른쪽 인덱스를 찾는다.

        int lt = 0;
        int rt = N;

        while (lt < rt) {
            int mid = lt + (rt - lt) / 2;

            if (ARR1[mid] > target) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }

        return lt;
    }
}
