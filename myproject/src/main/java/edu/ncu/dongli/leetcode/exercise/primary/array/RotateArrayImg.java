package edu.ncu.dongli.leetcode.exercise.primary.array;

/**
 * 问题：旋转图像
 * 描述：
 *      给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *      你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 示例：
 *      输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *      输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 *      输入：matrix = [[1,2],[3,4]]
 *      输出：[[3,1],[4,2]]
 *
 *      输入：matrix = [[1]]
 *      输出：[[1]]
 */
public class RotateArrayImg {
    /**
     * 根据例子找规律，发现先上下交换，再按照对角线交换就可以了
     * @param matrix
     */
    public void rotate_1(int[][] matrix) {
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //在按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 通过直接旋转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        //因为是对称的，只需要计算循环前半行即可
        for (int i = 0; i < length / 2; i++)
            for (int j = i; j < length - i - 1; j++) {
                //四个元素之间交换
                int temp = matrix[i][j];
                int m = length - j - 1;
                int n = length - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
    }

    public static void main(String[] args) {
        RotateArrayImg ri=new RotateArrayImg();
        int[][] matrix0=new int[][]{{1}};
        int[][] matrix1=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    }
}
