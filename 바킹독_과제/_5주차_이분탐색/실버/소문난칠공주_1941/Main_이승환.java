package 바킹독_과제._5주차_이분탐색.실버.소문난칠공주_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_이승환 {

    // 이다솜파 = 'S' // chlth4aud
    // 임도연파 = 'Y'
    static char[][] PRINCESSES;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PRINCESSES = new char[5][5];


        for(int i=0; i<5; i++){
            String line = br.readLine();
            PRINCESSES[i] = line.toCharArray();

        }


        BinarySearch();

    }

    private static void BinarySearch(){


    }


}
