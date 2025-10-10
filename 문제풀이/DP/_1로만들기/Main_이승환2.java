package 문제풀이.DP._1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_이승환2 {

    static int N;
    static int[] dp = new int[N+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //dp[i]는 i를 1로 만드는 데 최소 연산 횟수를 저장할 배열
        dp = new int[N+1];

        //dp 배열의 초기값 설정
        //dp[0]과 dp[1]은 연산이 필요 없으므로 0이지만,
        //문제의 입력 N은 1 이상이므로 dp[1]만 고려하면 된다.
        dp[1] = 0;

        //2부터 N까지 반복하며 각 숫자를 1로 만드는 최소 연산 횟수를 구한다.
        for(int i=2; i<=N; i++){
            //1. 기본적으로 1을 뺴는 연산을 수행한다.
            //이전 숫자(i-1)을 1로 만든느 횟수에 1을 더한 값.
            dp[i] = dp[i-1] +1;

            // 2. i가 2로 나누어 떨어지는 경우
            // 1을 빼는 경우와 2로 나누는 경우 중 더 작은 값을 선택한다.
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);

            // 3. i가 3으로 나누어 떨어지는 경우
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);




        }

        // 최종 결과인 dp[N] 출력
        System.out.println(dp[N]);


    }
}
