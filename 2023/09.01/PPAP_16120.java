import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * P가 나오면 Stack에 쌓아줌
 * A가 나오면 PPAP로 바꿀 수 있는지 체크 후 맞다면 Stack에 있던 P 2개를 빼줌 -> PPAP는 P 로 치환되기 때문에 A 뒤에 오는 P는 Stack에 들어감
 */
public class PPAP_16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'P') stack.push('P');
            else {
                if (stack.size() >= 2 && i != str.length() - 1 && str.charAt(i + 1) == 'P') {
                    stack.pop();
                    stack.pop();
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }

        System.out.println(stack.size() == 1 ? "PPAP" : "NP");
    }
}
