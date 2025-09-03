package _5주차_이분탐색.골드.누가이길까_28449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M;
    static int[] NList;
    static int[] MList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        NList = new int[N];
        MList = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            NList[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            MList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(MList);

        long win = 0;
        long lose = 0;
        long draw = 0;

        for (int i = 0; i < NList.length; i++) {
            int target = NList[i];

            int lower = lowerBound(target);
            int upper = upperBound(target);

            win += lower;
            lose += M - upper;
            draw += upper - lower;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(win).append(' ').append(lose).append(' ').append(draw);

        System.out.println(sb);
    }

    static int lowerBound(int target) {
        int left = 0;
        int right = MList.length - 1;
        int result = target;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (MList[mid] < target ) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    static int upperBound(int target) {
        int left = 0;
        int right = MList.length - 1;
        int result = target;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (MList[mid] <= target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }
}
