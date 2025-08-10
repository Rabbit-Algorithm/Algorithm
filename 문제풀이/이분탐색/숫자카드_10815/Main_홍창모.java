package 문제풀이.이분탐색.숫자카드_10815;

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

        // 정렬 처리
        Arrays.sort(ARR1);

        SB = new StringBuilder();

        binarySearch();

        System.out.println(SB);
    }

    private static void binarySearch() {

        for( int i = 0; i < M; i++ ) {
            int lt = 0;
            int rt = N-1;

            boolean found = false;
            while (lt <= rt) {
                int mid = lt + (rt-lt) / 2;

                if( ARR1[mid] < ARR2[i] ) {
                    lt = mid + 1;
                } else if( ARR1[mid] == ARR2[i] ) {
                    found = true;
                    break;
                } else {
                    rt = mid - 1;
                }
            }

            if( found ) {
                SB.append(1).append(" ");
            } else {
                SB.append(0).append(" ");
            }
        }
    }
}
