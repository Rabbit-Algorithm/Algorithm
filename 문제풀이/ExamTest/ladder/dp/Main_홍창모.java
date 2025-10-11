package 문제풀이.ExamTest.ladder.dp;

public class Main_홍창모 {
    class Solution {
        public int solution(int[] sticker) {
            int n = sticker.length;

            if( n == 1 ) return sticker[0];
            if( n == 2 ) return Math.max(sticker[0], sticker[1]);

            int[] dp = new int[n];

            if( n == 1 ) return sticker[0];
            if( n == 2 ) return Math.max( sticker[0], sticker[1] );

            dp[0] = sticker[0];
            dp[1] = Math.max(sticker[0], sticker[1]);

            for( int i = 2; i < n; i++ ) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
            }

            return dp[n-1];
        }
    }
}
