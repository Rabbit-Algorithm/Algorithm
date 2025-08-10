package 문제풀이.이분탐색.차집합_1822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수2 {

    /**
     * 차집합
     * https://www.acmicpc.net/problem/1822
     * 실버4
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());

        int[] aArr = new int[aNum];
        int[] bArr = new int[bNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bArr);

        List<Integer> answers = new ArrayList<>();


        for (int i = 0; i < aNum; i++) {
            if (Arrays.binarySearch(bArr, aArr[i]) < 0) {
                answers.add(aArr[i]);
            }
        }


        System.out.println(answers.size());
        answers.sort(Comparator.naturalOrder());
        for (int i : answers) {
            System.out.print(i + " ");
        }

    }


}
