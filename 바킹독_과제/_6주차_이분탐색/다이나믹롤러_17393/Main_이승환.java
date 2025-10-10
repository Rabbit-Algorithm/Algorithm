package 바킹독_과제._6주차_이분탐색.다이나믹롤러_17393;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int N;
    static long[] A;
    static long[] B;

    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        A = new long[N];
        B = new long[N];

        //이거 아이디어 좋은듯
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(stA.nextToken());
            B[i] = Long.parseLong(stB.nextToken());
        }

        // 3. 결과를 효율적으로 저장하기 위한 StringBuilder
        sb = new StringBuilder();

        binarySearch();

        // 7. 최종 결과 출력
        System.out.println(sb.toString().trim());
    }

    private static void binarySearch() {
        // 4. 각 타일 i에 대해 순회
        for (int i = 0; i < N; i++) {
            long target = A[i];

            int left = i; // 자기 자신의 오른쪽만 신경쓰기 때문에
            int right = N-1;
            int result = i; //결과값

            while(left <= right){
                int mid = left +(right-left)/2; //오버플로우 방지

                if(target >= B[mid]){
                    result = mid;
                    left = mid+1;
                }else{
                    right = mid-1;
                }

            }
            sb.append(result-i).append(" ");

        }
    }
}