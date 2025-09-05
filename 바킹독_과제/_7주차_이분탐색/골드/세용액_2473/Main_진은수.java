package _7주차_이분탐색.골드.세용액_2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 세 용액
     * https://www.acmicpc.net/problem/2473
     * 골드3
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


        long min = Long.MAX_VALUE;

        long one = 0;
        long two = 0;
        long three = 0;


        for (int i = 0; i < num - 2; i++) {
            int low = i + 1;
            int high = num - 1;
            while (low < high) {

                long sum = arr[i] + arr[low] + arr[high];

                if (sum == 0) {
                    one = arr[i];
                    two = arr[low];
                    three = arr[high];
                    break;
                } else if (sum > 0) {

                    if (min > Math.abs(sum)) {
                        min = Math.abs(sum);
                        one = arr[i];
                        two = arr[low];
                        three = arr[high];
                    }
                    high--;
                } else {
                    if (min > Math.abs(sum)) {
                        min = Math.abs(sum);
                        one = arr[i];
                        two = arr[low];
                        three = arr[high];
                    }
                    low++;
                }


            }


        }


        System.out.println(one + " " + two + " " + three);


    }


}
