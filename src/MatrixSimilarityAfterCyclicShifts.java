import java.util.Arrays;

public class MatrixSimilarityAfterCyclicShifts {

    static class Solution {
            public boolean areSimilar(int[][] mat, int k) {
                int row = mat.length;
                int colum = mat[0].length;
                boolean s = true;
                if (k % colum == 0 && k!=1)
                    return true;
                else {
                    for (int i = 0; i < row; i++) {
                        if (s == true) {
                            s = allSame(mat, i) || split(mat, i, k);
                        } else {
                            return false;
                        }

                    }
                    return s;
                }
            }

        public boolean allSame(int[][] mat, int row) {
            boolean same = true;
            int i = 0;
            while (same && i < mat[0].length-1) {
                same = mat[row][i]==mat[row][i+1];
                i++;
            }
            return same;
        }
        public boolean split(int[][] mat, int row, int k) {
            int cols = mat[row].length;
            boolean split = true;
            int j = k % cols;

            for (int i = 0; i < cols; i++) {
                split = mat[row][i] == mat[row][j];
                if (!split) return false;
                j = (j + 1) % cols;
            }

            return true;
        }

        static void runTest(int[][] mat, int k, boolean expected) {
            Solution sol = new Solution();
            boolean result = sol.areSimilar(mat, k);

            System.out.println("mat = " + Arrays.deepToString(mat));
            System.out.println("k = " + k);
            System.out.println("Esperado = " + expected);
            System.out.println("Obtenido = " + result);
            System.out.println(result == expected ? "OK" : "FAIL");
            System.out.println("---------------------------");
        }

        public static void main(String[] args) {
            runTest(new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            }, 4, false);

            runTest(new int[][]{
                    {1, 2, 1, 2},
                    {5, 5, 5, 5},
                    {6, 3, 6, 3}
            }, 2, true);

            runTest(new int[][]{
                    {2, 2},
                    {2, 2}
            }, 3, true);

            // Casos extra útiles
            runTest(new int[][]{
                    {1, 2, 3, 4}
            }, 4, true);

            runTest(new int[][]{
                    {1, 2, 3, 4}
            }, 1, false);

            runTest(new int[][]{
                    {1},
                    {2},
                    {3}
            }, 10, true);

            runTest(new int[][]{
                    {1, 1, 1},
                    {2, 2, 2}
            }, 5, true);

            runTest(new int[][]{
                    {1, 2},
                    {3, 4}
            }, 1, false);
            runTest(new int[][]{
                    {9, 10, 10, 6, 6, 8, 10, 7, 10, 9},
                    {10, 6, 1, 10, 10, 5, 7, 9, 9, 2},
                    {8, 5, 8, 3, 5, 2, 2, 9, 7, 10}
            }, 20, true);
        }
    }
}

