package _7주차_이분탐색.골드.두배열의합_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int T, N, M;
    static int[] NList;
    static int[] MList;

    static List<Integer> sumNList = new ArrayList<>();
    static List<Integer> sumMList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        NList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++) {
            NList[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        MList = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            MList[i] = Integer.parseInt(st.nextToken());
        }

        // 합 배열을 만들자!!

        //    1 2 3 4 5 6
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += NList[j];
                sumNList.add(sum);
            }
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += MList[j];
                sumNList.add(sum);
            }
        }

    }
}
