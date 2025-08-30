package 바킹독_과제._6주차_이분탐색.사냥꾼_8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int M; //사대의 수
    static int N; //동물의 수
    static long L; // 사정거리

    static int[] hunters;

    static long[][] animals;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //사대의 수
        N = Integer.parseInt(st.nextToken()); // 동물의 수
        L = Long.parseLong(st.nextToken()); // 사정거리

        hunters = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            hunters[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hunters);

        int huntCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken()); // 동물의 x좌표
            long b = Long.parseLong(st.nextToken()); // 동물의 y좌표

            // y좌표가 사정거리보다 큰 상황
            if (b > L) {
                continue;
            }


            int left = 0;
            int right = M - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                //사대와 동물 사이의 거리를 계산
                long distance = Math.abs(hunters[mid] - a) + b;

                if (distance <= L) {
                    //사정거리안이면 count++;
                    huntCount++;
                    break;
                }

                // 이분탐색 시작
                if (a < hunters[mid]) {
                    // 더 왼쪽 사대를 탐색
                    right = mid - 1;
                } else {
                    //더 오른쪽 사대를 탐색
                    left = mid + 1;
                }
            }
        }

        System.out.println(huntCount);

    }

    private static void binarySearch() {



    }

}
