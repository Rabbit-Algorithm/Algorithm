package 바킹독_과제._5주차_이분탐색.숫자카드1_10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 숫자  카드
     * https://www.acmicpc.net/problem/10815
     * 실버4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);


        int bNum = Integer.parseInt(br.readLine());
        long[] bArr = new long[bNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            bArr[i] = Long.parseLong(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < bNum ; i++) {
            sb.append(Arrays.binarySearch(arr, bArr[i]) >= 0 ? 1 : 0).append(" ");
        }

        System.out.println(sb);

    }
}
