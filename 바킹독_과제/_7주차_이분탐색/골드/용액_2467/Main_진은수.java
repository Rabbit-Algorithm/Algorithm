package _7주차_이분탐색.골드.용액_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 용액
     * https://www.acmicpc.net/problem/2467
     * 골드5
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

        int low = 0;
        int high = num - 1;
        long min = Long.MAX_VALUE;
        long left = 0;
        long right = 0;
        while (low < high) {

            long sum = arr[low] + arr[high];

            if (sum == 0) {
                left = arr[low];
                right = arr[high];
                break;
            } else if (sum > 0) {

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    left = arr[low];
                    right = arr[high];
                }
                high--;
            } else {
                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    left = arr[low];
                    right = arr[high];
                }
                low++;
            }


        }



        System.out.println(left + " " + right);



    }


}
