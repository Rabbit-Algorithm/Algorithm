package 바킹독_과제._5주차_이분탐색.누가이길까_28449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 누가 이길까
     * https://www.acmicpc.net/problem/28449
     * 골드5
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());


        int[] arrA = new int[aNum];
        int[] arrB = new int[bNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrB);

        long win = 0;
        long draw = 0;
        long lose = 0;

        for (int a = 0 ; a < aNum ; a++) {

            int upper = upperBound(arrB,arrA[a]);
            int lower = lowerBound(arrB,arrA[a]);

            win += lower;
            draw += upper - lower;
            lose += bNum - upper;

        }


        System.out.println(win + " " + lose + " " + draw) ;



    }

    private static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
