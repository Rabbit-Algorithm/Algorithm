package 바킹독_과제._5주차_이분탐색.골드.좋다_1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int n, answer = 0;

    static int[] arr;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for( int i = 0; i < n; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        System.out.print(answer);
    }

    public static void twoPoint() {
        // 오름차순 정렬
        Arrays.sort(arr);

        for( int i = 0; i < n; i++ ) {
            int lt = 0, rt = n-1;

            while( lt < rt ) {
                int sum = arr[lt] + arr[rt];

                if( i == lt ) {
                    lt++;
                    continue;
                }

                if( i == rt ) {
                    rt--;
                    continue;
                }

                if( sum == arr[i] ) {
                    answer++;
                    break;
                }

                if( sum > arr[i] ) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }
    }
}
