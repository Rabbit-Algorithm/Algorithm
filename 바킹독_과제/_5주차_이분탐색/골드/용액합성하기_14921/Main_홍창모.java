package 바킹독_과제._5주차_이분탐색.골드.용액합성하기_14921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N;
    static long ANSWER, MIN = Long.MAX_VALUE;
    static long[] SOLUTION;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        SOLUTION = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            SOLUTION[i] = Long.parseLong(st.nextToken());
        }

        binarySearch();

        System.out.println(ANSWER);
    }

    private static void binarySearch() {
        int ml =0, mr = 0;

        for(int i=0; i<N-1; i++) {
            int lt =i+1;
            int rt =N-1;

            while(lt<=rt) {
                int mid = lt + (rt-lt) / 2;

                long sum = SOLUTION[i]+SOLUTION[mid];

                if(MIN > Math.abs(sum)) {
                    MIN = Math.abs(sum);
                    ANSWER = sum;
                }

                if( sum == 0 ) {
                    break;
                } else if( sum > 0 ) {
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }

        }
    }
}
