package _7주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수2 {

    /**
     * 좋다
     * https://www.acmicpc.net/problem/1253
     * 골드4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];
        boolean[] visited = new boolean[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);


        int count = 0;
        for (int i = 0; i < num; i++) {
            int high = num -1;
            int low = 0;

            while (low < high) {


                if (low == i) {
                    low++;
                    continue;
                }

                if (high == i) {
                    high--;
                    continue;
                }

                long sum = arr[low] + arr[high];

                if (sum == arr[i]) {
                    if (!visited[i]) {
                        visited[i] = true;
                        count++;
                    }

                    break;
                } else if (sum < arr[i]) {
                    low++;
                } else {
                    high--;
                }

            }

        }

        System.out.println(count);

    }

}
