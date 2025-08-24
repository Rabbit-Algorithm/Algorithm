package 바킹독_과제._5주차_이분탐색.골드.세용액_2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static long[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ARR = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ARR[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(ARR);

        long minDiff = Long.MAX_VALUE;
        long ans1 = 0, ans2 = 0, ans3 = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = ARR[i] + ARR[left] + ARR[right];
                long absSum = Math.abs(sum);

                if (absSum < minDiff) {
                    minDiff = absSum;
                    ans1 = ARR[i];
                    ans2 = ARR[left];
                    ans3 = ARR[right];
                }

                if (sum == 0) {
                    System.out.println(ans1 + " " + ans2 + " " + ans3);
                    return;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(ans1 + " " + ans2 + " " + ans3);
    }
}
