import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if (canMakeByStrfry(str1, str2)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    public static boolean canMakeByStrfry(String str1, String str2) {
        if (str1.length() == str2.length()) {
//            for (int i = 0; i < str1.length(); i++) {
//                str2 = str2.replaceFirst(String.valueOf(str1.charAt(i)), "");
//            }
//            return str2.isEmpty();

            int[] arr = new int[26];
            for (int i = 0; i < str1.length(); i++) {
                arr[str1.charAt(i) - 'a']++;
                arr[str2.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
