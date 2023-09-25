public class 징검다리건너기 {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        s.solution(stones, k);
    }

    static class Solution {
        public int solution(int[] stones, int k) {
            int answer = 0;

            int min = 0;
            int max = Integer.MAX_VALUE;

            while (min <= max) {
                int mid = (min + max) / 2;

                if (check(mid, k, stones)) {
                    min = mid + 1;
                    answer = mid;
                } else {
                    max = mid - 1;
                }
            }

            System.out.println(answer);
            return answer;
        }

        public boolean check(int mid, int k, int[] stones) {
            int cnt = 0;
            for (int stone : stones) {
                if (stone < mid) {
                    if (++cnt >= k) return false;
                } else cnt = 0;
            }

            return true;
        }
    }
}
