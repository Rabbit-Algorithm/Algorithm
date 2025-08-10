package 바킹독_과제._5주차_이분탐색.실버.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static int[] ARR1, ARR2;
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

        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < M; i++ ) {
            int target = ARR2[i];

            sb.append(binarySearch(target)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int target) {

        int lt = 0;
        int rt = N-1;

        while ( lt <= rt ) {
            int mid = lt + (rt-lt) / 2;

            if( ARR1[mid] < target ) {
                lt = mid + 1;
            } else if( ARR1[mid] == target ) {
                return 1;
            } else {
                rt = mid - 1;
            }
        }

        return 0;
    }
}
