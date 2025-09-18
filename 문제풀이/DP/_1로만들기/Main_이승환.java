package 문제풀이.DP._1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_이승환 {

    static int N;

    static int[] dp = new int[N+1];

    static int[] prev = new int[N+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        //dp[i] : i를 1로 만드는 최소 연산 횟수
        dp = new int[N+1];
        //prev[i]: i에서 최적 경로로 가기 위해 다음으로 이동해야 하는 값(i -> prev[i])
        prev = new int[N+1];

        //초기화
        dp[1] = 0; //1은 이미 1이므로 끝
        prev[1] = 0; //경로의 끝 표시

        //i를 2부터 N까지 채워나간다
        for(int i=2; i<=N; i++) {
            //기본적으로는 i-1에서 온 경우를 가정
            dp[i] = dp[i - 1] + 1; // i-> i-1 연산 1회
            prev[i] = i - 1;


            //i가 2로 나누어 떨어지면 i/2에서 오는 경우 고려
            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    prev[i] = i / 2;
                }
            }

            //i가 3으로 나누어 떨어지면 i/3에서 오는 경우 고려
            if(i % 3 == 0){
                if(dp[i] > dp[i/3] +1){
                    dp[i] = dp[i/3] +1;
                    prev[i] = i/3;
                }
            }

        }

        //출력: 첫 줄에 최소 연산 횟수
        sb.append(dp[N]).append("\n");

        //경로 복원: N-> ... -> 1(prev를 따라간다)
        int cur = N;
        while (cur != 0){
            sb.append(cur).append(' ');
            if(cur == 1) break;
            cur = prev[cur];
        }

        System.out.println(sb.toString().trim());





    }
}
