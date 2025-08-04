package 바킹독_과제._5주차_이분탐색.골드.세용액_2473;

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

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] minArr = new long[3];

        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {

                long sum = (arr[i] + arr[j]) * -1;

                int low = j + 1;
                int high = num - 1;


                while (low <= high) {

                    int mid = (low + high) / 2;
                    long diff = arr[mid] - sum;

                    if (min > Math.abs(diff)) {
                        min = Math.abs(diff);
                        minArr[0] = arr[i];
                        minArr[1] = arr[j];
                        minArr[2] = arr[mid];
                    }


                    if (diff > 0) {
                        high = mid - 1;
                    } else if (diff == 0) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[mid]);
                        return;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        System.out.println(minArr[0] + " " + minArr[1] + " " + minArr[2]);


    }


}
