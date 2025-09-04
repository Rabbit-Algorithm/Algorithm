package 문제풀이.이분탐색.어두운굴다리_17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {
    
    static int N, M;
    static int[] STREETLIGHT;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        STREETLIGHT = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            STREETLIGHT[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(STREETLIGHT);

        binarySearch();
    }

    private static void binarySearch() {
        int left = 1;
        int right = N;

        int answer = 0;

        while (left <= right) {
            int mid = left + (right-left) / 2;

            if( canLight(mid) ) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canLight( int height ) {
        int prev = 0;

        for( int i = 0; i < STREETLIGHT.length; i++ ) {
            if( STREETLIGHT[i] - height <= prev ) {
                prev = STREETLIGHT[i] + height;
            } else {
                return false;
            }
        }

        // 마지막 가로등이 비추는 곳이 굴다리 길이보다 같거나 커야함
        return N - prev <= 0;
    }
}
