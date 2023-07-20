import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**입력 값이 숫자와 연산자의 올바른 조합으로 들어오는지 체크*/
public class 사칙연산유효성검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 1;
            for(int i = 1; i <= N; i++) {
                StringTokenizer st =  new StringTokenizer(br.readLine());
                st.nextToken();
                char node = st.nextToken().charAt(0);
                if(st.hasMoreTokens()) { 
                    if(node >= '0' && node <= '9') { // 연산자이어야함
                        answer = 0;
                    }
                } else {
                    if(node < '0' || node > '9') { //숫자이어야 함
                        answer = 0;
                    }
                }
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
