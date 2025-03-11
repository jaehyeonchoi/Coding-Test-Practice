import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            }
            else {
                if (str.charAt(i - 1) == '(') { // 레이저로 인한 절단
                    stack.pop();
                    count += stack.size(); // 막대기 레이어 수만큼 증가
                }
                else { // 막대기가 끝나는 부분
                    stack.pop();
                    count ++; // 1만큼 증가
                }
            }
        }
        System.out.println(count);
    }
}
