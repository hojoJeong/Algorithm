import java.util.*;
import java.io.*;

public class Main_5658_보물상자_비밀번호 {
    static int N, K, unitCount, result;
    static char[] chArr;
    static HashSet<Integer> pwSet;

    // K 번째로 큰 수
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/5658.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 처음 회전한 값과 동일 해 질 때 까지 계속 해서 회전.
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            init();

            // unitCount 만큼 회전
            String temp = br.readLine();
            chArr = temp.toCharArray();

            // 1. 회전을 함.
            // 2. 회전된 값을 4등분한다.
            // 3. 10진수로 변환 -> treeSet에 넣는다.
            // 3. 다시 회전을 한다. 이 과정을 uniCount만큼 반복한다.

            String temp2 = temp;
            for (int i = 0; i < unitCount; i++) {
                for (int j = 0; j < 4; j++) {
                    String temp3 = temp2.substring(j * unitCount, (j * unitCount) + unitCount);
                    pwSet.add(changeToDecimal(temp3));
                }

                temp2 = (temp2.substring(1, temp.length())) + temp2.substring(0, 1);
                //System.out.println("temp2 : " + temp2);
            }

            List<Integer> list = new ArrayList<>();
            Iterator<Integer> iter = pwSet.iterator();
            while (iter.hasNext()) {
                list.add(iter.next());
            }

            Collections.sort(list, Collections.reverseOrder());
            result = list.get(K-1);

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void DFS() {

    } // End of DFS

    private static int changeToDecimal(String hex) { // 10진수를 16진수로 변환
        return Integer.parseInt(hex, 16);
    } // End of changeToDecimal

    private static void init() {
        unitCount = N / 4;
        result = 0;
        pwSet = new HashSet<>();
        chArr = new char[N];

    } // End of init
} // End of Main class