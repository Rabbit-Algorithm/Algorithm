package 바킹독_과제._5주차_이분탐색.골드.용액_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수1 {

    /**
     * 용액
     * https://www.acmicpc.net/problem/2467
     * 골드5
     */

    // 투 포인터 풀이
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int low = 0;
        int high = num - 1;

        long min = Long.MAX_VALUE;
        long lower = 0;
        long upper = 0;

        while (low < high) {

            long diff = arr[high] + arr[low];

            if (diff == 0) {
                lower = arr[low];
                upper = arr[high];
                break;
            } else if (diff > 0) {
                if (Math.abs(diff) < min) {
                    lower = arr[low];
                    upper = arr[high];
                    min = Math.abs(diff);
                }
                high--;
            } else {
                if (Math.abs(diff) < min) {
                    lower = arr[low];
                    upper = arr[high];
                    min = Math.abs(diff);
                }
                low++;
            }
        }


        System.out.println(lower + " " + upper);


    }


}
