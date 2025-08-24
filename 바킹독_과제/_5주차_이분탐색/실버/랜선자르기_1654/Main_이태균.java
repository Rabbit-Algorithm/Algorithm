package 바킹독_과제._5주차_이분탐색.실버.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int K, N;
    private static long[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        ARR = new long[K];

        long maxLen = 0;
        for (int i = 0; i < K; i++) {
            ARR[i] = Long.parseLong(br.readLine());
            maxLen = Math.max(maxLen, ARR[i]);
        }

        long result = binarySearch(maxLen);
        System.out.println(result);
    }

    public static long binarySearch(long right) {
        long left = 1;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = getCount(mid);

            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static long getCount(long length) {
        long count = 0;

        for (long lan : ARR) {
            count += lan / length;
        }
        return count;
    }
}
