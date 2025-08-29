package _5주차_이분탐색.골드.공유기설치_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_황병수 {
    static int N, M;
    static int[] homeList;
    static  int[] sumList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println("saasdsd");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homeList = new int[N];
        sumList = new int[N];

        for (int i = 0; i < N; i++) {
            homeList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(homeList);

        for (int i = N - 1; i > 1; i--) {
            for (int j = N - 2; j > 0; j--) {
                sumList[j] = homeList[i] - homeList[j];
            }
        }

        Arrays.sort(sumList);



    }
}
