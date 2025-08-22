package _5주차_이분탐색.골드.용액_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N;
    static Long MIN = Long.MAX_VALUE;
    static int[] SOLUTION;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        SOLUTION = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for( int i = 0; i < N; i++ ) {
            SOLUTION[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(SOLUTION);

        binarySearch();

    }

    private static void binarySearch() {
        int ml =0, mr = 0;

        for(int i=0; i<N-1; i++) {
            int lt =i+1;
            int rt =N-1;
            while(lt<=rt) {
                int mid = lt + (rt - lt)/2;
                long sum = Math.abs(SOLUTION[i]+SOLUTION[mid]);

                if(MIN > sum) {
                    MIN = sum;
                    ml = i; mr = mid;
                }
                if(SOLUTION[mid]>= -SOLUTION[i]) {
                    rt = mid-1;
                }else{
                    lt = mid+1;
                }
            }
        }

        System.out.println(SOLUTION[ml]+" "+SOLUTION[mr]);
    }
}
