package 바킹독_과제._3주차_백트래킹.N과M4_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_이승환 {

    static int N,M;
    static int[] arr;


    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        BackTracking(0,1);

        System.out.print(sb);
    }

    private static void BackTracking(int depth,int start) {

        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++){
            arr[depth] = i;

            BackTracking(depth+1, i);
        }
    }
}
