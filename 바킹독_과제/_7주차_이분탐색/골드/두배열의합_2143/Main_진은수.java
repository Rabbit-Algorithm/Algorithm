package _7주차_이분탐색.골드.두배열의합_2143;

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

        int target = Integer.parseInt(br.readLine());

        int aSize = Integer.parseInt(br.readLine());
        long[] aArr = new long[aSize];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aArr[i] = Long.parseLong(st.nextToken());
        }

        int bSize = Integer.parseInt(br.readLine());
        long[] bArr = new long[bSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bArr[i] = Long.parseLong(st.nextToken());
        }

        int aSumSize = (aSize * (aSize - 1)) / 2 + aSize;
        int bSumSize = (bSize * (bSize - 1)) / 2 + bSize;

        long[] aSum = new long[aSumSize];
        long[] bSum = new long[bSumSize];

        int aCount = 0;
        for (int i = 0; i < aSize; i++) {
            long sum = aArr[i];
            aSum[aCount] = aArr[i];
            aCount++;
            for (int j = i+1; j < aSize; j++) {
                aSum[aCount] = sum + aArr[j];
                sum += aArr[j];
                aCount++;
            }
        }


        int bCount = 0;
        for (int i = 0; i < bSize; i++) {
            long sum = bArr[i];
            bSum[bCount] = bArr[i];
            bCount++;
            for (int j = i+1; j < bSize; j++) {
                bSum[bCount] = sum + bArr[j];
                sum += bArr[j];
                bCount++;
            }
        }

        Arrays.sort(aSum);

        long count = 0;
        for (int i = 0; i < bSumSize; i++) {

            int up = upperBound(aSum,target - bSum[i]);
            int down = lowerBound(aSum,target - bSum[i]);

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
