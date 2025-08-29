package 바킹독_과제._6주차_이분탐색.다이나믹롤러_17393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 함정이 너무 많다~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
public class Main_황병수 {

    static int N,M;
    static long[] NList;
    static long[] MList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        NList = new long[N];
        MList = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NList[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            MList[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            getaVoid(i, NList[i]);
        }

        System.out.println(sb);
    }

    private static void getaVoid(int leftIndex, long target) {
        if (MList[leftIndex] > target) {
            sb.append("0 ");
            return;
        }

        int result = leftIndex;
        int left = leftIndex + 1;
        int right = N - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (MList[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        sb.append(result - leftIndex).append(" ");
    }
}
