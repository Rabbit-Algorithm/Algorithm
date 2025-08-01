package 바킹독_과제._4주차_백트래킹.로또_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과M6_15655번을 참고해서 품
//depth말고 start를 줘서 달랐을 때에도 세도록 코드 수정

public class Main_이승환 {

    private static int K;
    private static int[] S;
    private static int[] LOTTO = new int[6];
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if(K == 0){
                break;
            }

            S = new int[K];

            for(int i=0; i<K; i++){
                S[i] = Integer.parseInt(st.nextToken());
            }

            BackTracking(0,0);
            SB.append("\n");

        }

        System.out.print(SB);


    }

    private static void BackTracking(int depth, int start) {
        if(depth == 6){
            for(int i=0; i<6; i++){
                SB.append(LOTTO[i]).append(" ");
            }
            SB.append("\n");
            return;
        }

        for(int i = start; i<K; i++){
            LOTTO[depth] = S[i];
            BackTracking(depth+1, i+1);
        }


    }

}