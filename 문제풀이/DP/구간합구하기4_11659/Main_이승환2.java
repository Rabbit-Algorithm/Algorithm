package 문제풀이.DP.구간합구하기4_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//O(N*M)이 O(N+M)으로 바뀜
//
public class Main_이승환2 {

    static int N;
    static int M;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());

        //누적합 배열 만들기
        for(int i=1; i<=N; i++){
            //이전까지의 누적 합 + 현재 숫자
            dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        // 2. M번의 질문에 대해 뺄셈으로 답을 구함.
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            //prev 부터 next 까지의 합 = (1~next까지의 합) - (1~prev-1까지의 합)
            int sum = dp[next] - dp[prev -1];
            sb.append(sum).append('\n');

        }

        System.out.println(sb);


    }


}
