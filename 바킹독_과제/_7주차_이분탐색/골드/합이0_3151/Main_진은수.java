package _7주차_이분탐색.골드.합이0_3151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 합이 0
     * https://www.acmicpc.net/problem/3151
     * 골드4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long count = 0;
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {

                long sum = (arr[i] + arr[j]) * -1;

                int up = upperBound(arr,sum,j+1);
                int down = lowerBound(arr,sum,j+1);

                int diff = up - down;
                if (diff >= 0) {
                    count += diff;
                }
            }
        }

        System.out.println(count);

    }


    private static int upperBound(long[] arr, long target, int start) {
        int low = start;
        int high = arr.length;
        while (low < high) {
            int mid = (high + low) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    private static int lowerBound(long[] arr, long target, int start) {
        int low = start;
        int high = arr.length;
        while (low < high) {
            int mid = (high + low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


}
