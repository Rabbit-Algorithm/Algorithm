package 바킹독_과제._5주차_이분탐색.실버.과자나눠주기_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int M, N;
    private static long[] SNACK_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        SNACK_LIST = new long[N];

        long maxLen = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SNACK_LIST[i] = Long.parseLong(st.nextToken());
            maxLen = Math.max(maxLen, SNACK_LIST[i]);
        }

        long result = binarySearch(maxLen);
        System.out.println(result);
    }

    public static long binarySearch(long right) {
        long left = 1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(mid);

            if (count >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static long getCount(long len) {
        long count = 0;
        for (long a : SNACK_LIST) {
            count += (a / len);
        }
        return count;
    }

}
