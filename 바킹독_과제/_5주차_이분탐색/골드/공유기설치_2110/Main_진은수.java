package 바킹독_과제._5주차_이분탐색.골드.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 공유기 설치
     * https://www.acmicpc.net/problem/2110
     * 골드4
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        long low = 1;
        long high = 1;

        long[] arr = new long[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
            high = Math.max(high, arr[i]);
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;



        }


    }


}
