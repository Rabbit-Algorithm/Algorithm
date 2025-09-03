package 바킹독_과제._6주차_이분탐색.다이나믹롤러_17393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static long[] INK_LIST, VISCOSITY_LIST, RESULT_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        INK_LIST = new long[N];
        VISCOSITY_LIST = new long[N];
        RESULT_LIST = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            INK_LIST[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            VISCOSITY_LIST[i] = Long.parseLong(st.nextToken());
        }

        binarySearch();

        StringBuilder sb = new StringBuilder();
        for (long r : RESULT_LIST) {
            sb.append(r).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static void binarySearch() {
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = N - 1;
            long target = INK_LIST[i];

            while (left <= right) {
                int mid = (left + right) / 2;

                if (VISCOSITY_LIST[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            RESULT_LIST[i] = right - i;
        }
    }

}
