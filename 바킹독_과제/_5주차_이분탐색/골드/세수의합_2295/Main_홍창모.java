package 바킹독_과제._5주차_이분탐색.골드.세수의합_2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {

    static int N;
    static long[] U;
    static List<Long> sortSetList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        U = new long[N];

        HashSet<Long> set = new HashSet<>();

        for( int i = 0; i < N; i++ ) {
            long num = Long.parseLong(br.readLine());
            U[i] = num;
        }

        Arrays.sort(U);

        for( int i = 0; i < N; i++ ) {
            for( int j =0; j <N; j++ ) {
                // 두수의 합중 동일한 값 제거
                set.add(U[i]+U[j]);
            }
        }

        sortSetList = new ArrayList<>(set);
        Collections.sort(sortSetList);

        binarySearch();
    }

    private static void binarySearch() {

        for( int i = N-1; i >= 0; i-- ) {
            for( int j = N-1; j >=0; j-- ) {

                long minus = U[i] - U[j];

                int lt = 0, rt = sortSetList.size() - 1;

                while(lt <= rt) {
                    int mid = lt + (rt-lt) / 2;

                    if( minus == sortSetList.get(mid) ) {
                        System.out.println(U[i]);
                        return;
                    }  else if( minus > sortSetList.get(mid) ) {
                        lt = mid + 1;
                    } else {
                        rt = mid - 1;
                    }
                }

            }
        }
    }
}
