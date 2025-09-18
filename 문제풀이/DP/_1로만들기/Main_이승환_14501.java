package 문제풀이.DP._1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이승환_14501 {

    static int N;

    static int[] T; //작업 소요일

    static int[] P; // 보수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N+2];
        P = new int[N+2];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp();

    }

    private static void dp() {
        int[] dp = new int[N+2]; //dp[i] = i일부터 얻을 수 있는 최대 이익
        dp[N+1] = 0; // 퇴사 이후는 0

        for(int i=N; i>=1; i--){
            int finishDay = i+T[i]; // 상담이 끝나는 날
            if(finishDay <= N+1){
                dp[i] = Math.max(dp[i+1], P[i]+dp[finishDay]);
            }else dp[i] = dp[i+1];
        }


        System.out.println(dp[1]);
    }

}
