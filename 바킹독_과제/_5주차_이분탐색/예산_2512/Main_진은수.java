package 바킹독_과제._5주차_이분탐색.예산_2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 예산
     * https://www.acmicpc.net/problem/2512
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int low = 1;
        int high = 1;

        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < num ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high,arr[i]);
        }

        long total = Long.parseLong(br.readLine());

        while (low <= high) {

            long sum = 0;
            int mid = (low + high) / 2;

            for (int i = 0 ; i < num ; i++) {
                int diff = arr[i] - mid;

                if (diff > 0) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }


            if (sum > total) {
                high = mid-1;
            } else {
                low = mid +1;
            }

        }

        System.out.println(high);



    }


}
