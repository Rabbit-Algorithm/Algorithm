package 바킹독_과제._5주차_이분탐색.실버.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    /**
     * 수찾기
     * https://www.acmicpc.net/problem/1920
     * 실버4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int aNum = Integer.parseInt(br.readLine());
        int[] aArr = new int[aNum];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }


        int bNum = Integer.parseInt(br.readLine());
        int[] bArr = new int[bNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(aArr);


        for (int i = 0; i < bNum; i++) {
            System.out.println(Arrays.binarySearch(aArr, bArr[i]) >= 0 ? 1 : 0);
        }


    }


}
