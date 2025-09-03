package 바킹독_과제._6주차_이분탐색.사냥꾼_8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int M, N, L;
    private static int[] ARR;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        ARR = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ARR[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ARR);

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (binarySearch(x, y)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean binarySearch(int x, int y) {
        int left = 0;
        int right = M - 1;
        int pos = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (ARR[mid] >= x) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (pos == -1) {
            return Math.abs(ARR[M - 1] - x) + y <= L;
        }

        if (Math.abs(ARR[pos] - x) + y <= L) {
            return true;
        }

        if (pos > 0 && Math.abs(ARR[pos - 1] - x) + y <= L) {
            return true;
        }

        return false;
    }

}
