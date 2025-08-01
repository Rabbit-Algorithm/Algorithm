package _4주차_백트래킹.암호만들기_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int L, C;
    static String[] strArr, LIST;
    static StringBuilder SB = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        strArr = new String[C];
        LIST = new String[L];

        st = new StringTokenizer(br.readLine());

        for( int i = 0; i < C; i++ ) {
            strArr[i] = st.nextToken();
        }

        Arrays.sort(strArr);

        backtracking(0,0, 0, 0);

        System.out.print(SB);
    }

    private static void backtracking(int curr, int depth, int vowels, int consonant) {
        if( depth == L ) {
            if( vowels > 0 && consonant > 1 ) {
                for( String s : LIST ) {
                    SB.append(s);
                }
                SB.append("\n");
            }
            return;
        }

        for( int i = curr; i < C; i++ ) {
            LIST[depth] = strArr[i];
            if( isVowels(strArr[i]) ) {
                backtracking(i+1, depth+1, vowels+1, consonant);
            } else {
                backtracking(i+1, depth+1, vowels, consonant+1);
            }

        }
    }

    static boolean isVowels(String str) {

        if( str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o") || str.equals("u") ) {
            return true;
        }

        return false;
    }
}
