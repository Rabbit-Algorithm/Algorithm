package 바킹독_과제._5주차_이분탐색.실버.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N,M,R;
    static int[] cableList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cableList = new int[N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int stick = Integer.parseInt(st.nextToken());
            cableList[i] = stick;
        }

        Arrays.sort(cableList);
        binarySearch();
        System.out.println(R);
    }

    private static void binarySearch() {

        long left = 1;
        long right = cableList[N-1];
        R = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = calcMethod(mid);

            if (count >= M) {
                R = (int)mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    static long calcMethod(long length) {
        long count = 0;
        for (int i = 0; i < N; i++) {
            count += cableList[i] / length;
        }
        return count;
    }
}
