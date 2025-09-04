package 문제풀이.이분탐색.게임_1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int percent = (int) ((long)Y * 100.0 / X);

        binarySearch(percent);

    }

    private static void binarySearch(int percent) {
        int left = 1;
        int right = 1_000_000_000;

        int answer = -1;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            int tempPercent = (int)((long)(Y + mid) * 100.0 / ( X + mid ));

            if( percent != tempPercent ) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
