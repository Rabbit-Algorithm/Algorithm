package _7주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

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

        long count = 0;
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                long sum = arr[i] + arr[j];
                int index = Arrays.binarySearch(arr, sum);

                if (index >= 0) {
                    if (!visited[index]) {
                        visited[index] = true;
                        count++;
                    }
                }

            }
        }

        System.out.println(count);

    }

}
