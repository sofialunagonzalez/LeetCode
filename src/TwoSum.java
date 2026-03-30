import java.util.Arrays;

public class TwoSum {

    static class Solution {

        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length ; i++) {
                for (int j = 1; j < nums.length ; j++) {
                    if(nums[i] + nums[j] == target && i!=j){
                        return new int[] {i,j};
                    }
                }
            }
            return new int[]{-1, -1};
        }

        private boolean samePair(int[] result, int[] expected) {
            if (result == null || result.length != 2) return false;

            return (result[0] == expected[0] && result[1] == expected[1]) ||
                    (result[0] == expected[1] && result[1] == expected[0]);
        }

        private void runTest(int testNumber, int[] nums, int target, int[] expected) {
            int[] result = twoSum(nums, target);
            boolean ok = samePair(result, expected);

            System.out.println("Test " + testNumber + ": " + (ok ? "OK" : "FAIL"));

            if (!ok) {
                System.out.println("  nums     = " + Arrays.toString(nums));
                System.out.println("  target   = " + target);
                System.out.println("  esperado = " + Arrays.toString(expected));
                System.out.println("  obtenido = " + Arrays.toString(result));
            }
        }

        public void runAllTests() {

            runTest(1,
                    new int[]{2, 7, 11, 15},
                    9,
                    new int[]{0, 1});

            runTest(2,
                    new int[]{3, 2, 4},
                    6,
                    new int[]{1, 2});

            runTest(3,
                    new int[]{3, 3},
                    6,
                    new int[]{0, 1});

            runTest(4,
                    new int[]{1, 5, 3, 7},
                    8,
                    new int[]{0, 3});

            runTest(5,
                    new int[]{-1, -2, -3, -4, -5},
                    -8,
                    new int[]{2, 4});

            runTest(6,
                    new int[]{0, 4, 3, 0},
                    0,
                    new int[]{0, 3});
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.runAllTests();
    }
}
