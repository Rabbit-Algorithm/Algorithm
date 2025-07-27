package 바킹독_과제._3주차_백트래킹.N과M3_15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//초기 코드 (시간초과가 남)
public class Main_이승환2 {

    static int N,M;
    static int[] arr;

    //어짜피 다 들를거기 떄문에 visited가 필요가 없다.
//    static int[] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        BackTracking(0);

        System.out.print(sb);
    }


    private static void BackTracking(int depth) {

            if(depth == M) {
                for (int i = 0; i < M; i++) {
                    sb.append(arr[i]).append(' ');
                }
                sb.append("\n");
                return;
            }

            for(int i=1; i<=N; i++){
                arr[depth] = i;
                BackTracking(depth+1);

            }
    }
}
