package 바킹독_과제._5주차_이분탐색.골드.두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 두 배열의 합
     * https://www.acmicpc.net/problem/2143
     * 골드3
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long target = Long.parseLong(br.readLine());


        int aSize = Integer.parseInt(br.readLine());
        int[] aArr = new int[aSize];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        int bSize = Integer.parseInt(br.readLine());
        int[] bArr = new int[bSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }


        int aSumSize = (aSize * (aSize - 1)) / 2 + aSize;
        int bSumSize = (bSize * (bSize - 1)) / 2 + bSize;

        long[] aSumArr = new long[aSumSize];
        int aIndex = 0;
        for (int i = 0; i < aSize; i++) {
            long sum = aArr[i];
            aSumArr[aIndex] = aArr[i];
            aIndex++;
            for (int j = i + 1; j < aSize; j++) {
                aSumArr[aIndex] = sum + aArr[j];
                sum += aArr[j];
                aIndex++;
            }
        }


        long[] bSumArr = new long[bSumSize];
        int bIndex = 0;
        for (int i = 0; i < bSize; i++) {
            long sum = bArr[i];
            bSumArr[bIndex] = bArr[i];
            bIndex++;
            for (int j = i + 1; j < bSize; j++) {
                bSumArr[bIndex] = sum + bArr[j];
                sum += bArr[j];
                bIndex++;
            }
        }

        Arrays.sort(bSumArr);

        long count = 0;
        for (int i = 0; i < aSumSize; i++) {

            int up = upperBound(bSumArr,target - aSumArr[i]);
            int down = lowerBound(bSumArr,target - aSumArr[i]);

            count += up-down;
        }

        System.out.println(count);


    }


    private static int upperBound(long[] arr, long target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = (low + high) / 2;

            if (target >= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low;
    }

    private static int lowerBound(long[] arr, long target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = (low + high) / 2;

            if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        return low;
    }

}
