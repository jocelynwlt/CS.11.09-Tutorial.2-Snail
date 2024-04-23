public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d == null) {
            return new int[0];
        }

        if (!isPerfectSquare(array2d)) {
            return new int[0];
        }

        int n = array2d.length;
        int[] result = new int[n * n];

        int count = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;

        while (true) {
            for (int i = left; i <= right; i++) {
                result[count] = array2d[top][i];
                count++;
            }
            if (count >= result.length) break;

            for (int i = top + 1; i <= bottom; i++) {
                result[count] = array2d[i][right];
                count++;
            }

            if (count >= result.length) break;

            for (int i = right - 1; i >= left; i--) {
                result[count] = array2d[bottom][i];
                count++;
            }

            if (count >= result.length) break;

            for (int i = bottom - 1; i > top; i--) {
                result[count] = array2d[i][left];
                count++;
            }

            if (count >= result.length) break;
            top = top + 1;
            right = right - 1;
            bottom = bottom - 1;
            left = left + 1;
        }
        return result;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (array1d == null || !isPerfectSquare(array1d) || array1d.length == 0) {
            int[][] empty = new int[0][0];
            return empty;
        }

        int n = (int) Math.sqrt(array1d.length);
        int[][] result = new int[n][n];
        int count = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;

        while (count < n * n) {
            for (int i = left; i <= right; i++) {
                result[top][i] = array1d[count];
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = array1d[count];
                count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[bottom][i] = array1d[count];
                count++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                result[i][left] = array1d[count];
                count++;
            }
            left++;
        }
        return result;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        System.out.println(array1d);
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        System.out.println(array2d);
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        int sqr = (int) Math.sqrt(array1d.length);
        return sqr*sqr==array1d.length;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        return array2d.length==array2d[0].length;
    }


}
