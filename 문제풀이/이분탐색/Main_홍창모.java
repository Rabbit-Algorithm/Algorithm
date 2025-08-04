package 문제풀이.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int A,B, COUNT;
    static int[] ARR_A, ARR_B;
    static StringBuilder SB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ARR_A = new int[A];
        ARR_B = new int[B];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < A; i++ ) {
            ARR_A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < B; i++ ) {
            ARR_B[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 처리
        Arrays.sort(ARR_A);
        Arrays.sort(ARR_B);

        binarySearch();

        System.out.println(COUNT);
        System.out.print(SB);
    }

    static void binarySearch() {


        for( int i = 0; i < A; i++ ) {

            int lt = 0;
            int rt = B-1;

            boolean found = false;
            while ( rt >= lt ) {
                int mid = lt + (rt-lt) / 2;

                if( ARR_A[i] < ARR_B[mid] ) {
                    rt = mid - 1;
                } else if (ARR_A[i] == ARR_B[mid]) {
                    found = true;
                    break;
                } else {
                    lt = mid + 1;
                }
            }

            if( !found ) {
                COUNT++;
                SB.append(ARR_A[i]).append(" ");
            }
        }


    }
}
