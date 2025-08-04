package 바킹독_과제._5주차_이분탐색.골드.합이0인네정수_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 합이 0인 네 정수
     * https://www.acmicpc.net/problem/7453
     * 골드4
     */


    /**
     * 투포인터, 이분탐색, Map 풀이 가능
     * 성능 투포인터가 가장 좋은듯.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        long[][] arr = new long[num][4];

        for (int y = 0; y < num; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 4; x++) {
                arr[y][x] = Long.parseLong(st.nextToken());
            }
        }


        int totalNum = num * num;
        long[] abArr = new long[totalNum];
        long[] cdArr = new long[totalNum];


        int index = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                abArr[index] = arr[i][0] + arr[j][1];
                cdArr[index] = arr[i][2] + arr[j][3];
                index++;
            }
        }
        Arrays.sort(abArr);
        Arrays.sort(cdArr);


        long count = 0;

        int low = 0;
        int high = totalNum - 1;

        while (low >= 0 && low <= totalNum - 1 && high >= 0 && high <= totalNum - 1) {

            long sum = abArr[low] + cdArr[high];

            if (sum > 0) {
                high--;
            } else if (sum == 0) {

                int up = upperBound(cdArr,cdArr[high]);
                int down = lowerBound(cdArr,cdArr[high]);

                count += up-down;

                low++;
            } else {
                low++;
            }
        }


        System.out.println(count);

    }


    private static int lowerBound(long[] arr, long target) {
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

    private static int upperBound(long[] arr, long target) {
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
