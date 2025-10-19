package 문제풀이.DP.자두나무_2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_진은수 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken())+1;
        int number = Integer.parseInt(st.nextToken())+1;

        int[][] dp = new int[size][number];

        dp[0][0] = 0;

        for (int i = 1; i < size; i++) {
            int num = Integer.parseInt(br.readLine()) - 1;


            for (int j = 0; j < number && j <= i; j++) {

                int weight = j % 2;


                if (j == 0) {
                    if (num == weight) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if(j == i) {
                    if (num == weight) {
                        dp[i][j] = dp[i - 1][j-1] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j-1];
                    }
                } else {
                    if (num == weight) {
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }

            }


        }

        int max = 0;
        for (int i = 0; i < number; i++) {
            max = Math.max(max, dp[size - 1][i]);
        }

        System.out.println(max);

    }
}
