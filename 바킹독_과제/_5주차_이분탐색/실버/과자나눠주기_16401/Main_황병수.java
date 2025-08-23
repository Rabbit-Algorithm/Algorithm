package 바킹독_과제._5주차_이분탐색.실버.과자나눠주기_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M;
    static Long R;
    static int[] snackList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snackList = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int stick = Integer.parseInt(st.nextToken());
            snackList[i] = stick;
        }

        Arrays.sort(snackList);
        binarySearch();
        System.out.println(R);
    }

    private static void binarySearch() {

        long left = 1;
        long right = snackList[N-1];
        R = 0L;

        while (left <= right) {

            long mid = (left + right) / 2;
            int count = 0;

            for (int snack : snackList) {
                count += (int)(snack / mid);
            }

            if (count >= M) {
                R = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
    }
}
