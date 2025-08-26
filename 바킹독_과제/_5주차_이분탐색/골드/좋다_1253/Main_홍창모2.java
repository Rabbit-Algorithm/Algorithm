package _5주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모2 {

    static int N, ANSWER = 0;
    static int[] ARR;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ARR = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            int num = Integer.parseInt(st.nextToken());
            ARR[i] = num;
        }

        // 정렬 처리
        Arrays.sort(ARR);

        int cnt = 0;

        for( int i = 0; i < N; i++ ) {
            boolean found = false;
            for( int j = 0; j < N; j++ ) {
                if( i == j ) continue;
                int target = ARR[i] - ARR[j];

                if( binarySearch(target, i, j) ) {
                    found = true;
                    break;
                }
            }
            if( found ) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean binarySearch(int target, int i, int j) {
        int left = 0;
        int right = ARR.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (ARR[mid] == target && mid != i && mid != j) {
                return true;
            }
            if (ARR[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
