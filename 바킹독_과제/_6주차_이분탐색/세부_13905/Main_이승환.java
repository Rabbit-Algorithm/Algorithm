package 바킹독_과제._6주차_이분탐색.세부_13905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int N; //집의 수
    static int M; //다리의 수
    static int s; //숭이의 출발 위치

    static int e; //혜빈이의 위치


    static long[] bridge;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //집의 수
        N = Integer.parseInt(st.nextToken()); //다리의 수

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //숭이의 출발 위치
        N = Integer.parseInt(st.nextToken()); //혜빈이의 위치


    }

    private static void binarySearch() {



    }

}
