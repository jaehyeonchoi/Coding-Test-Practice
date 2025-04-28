import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer minusTokenizer = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        while (minusTokenizer.hasMoreTokens()) { // 뺄셈을 최대한 많이 하기 위해 -로 파싱
            StringTokenizer plusTokenizer = new StringTokenizer(minusTokenizer.nextToken("-"));
            int sum = 0;
            while (plusTokenizer.hasMoreTokens()) { // -로 파싱된 덧셈식을 계산하여 리스트에 저장
                sum += Integer.parseInt(plusTokenizer.nextToken("+")); 
            }
            list.add(sum);
        }

        int ans = list.get(0); // 첫번째 수에서 나머지 수들을 전부 빼기
        for (int i = 1; i < list.size(); i++) {
            ans -= list.get(i);
        }
        System.out.println(ans);
    }
}
