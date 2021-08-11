package edu.ncu.dongli.leetcode.exercise.primary.array;

/**
 * 问题：
 *      有效的数独
 * 描述：
 *      请你判断一个9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *      数字1-9在每一行只能出现一次。
 *      数字1-9在每一列只能出现一次。
 *      数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 *      数独部分空格内已填入了数字，空白格用'.'表示。
 * 注意：
 *      一个有效的数独（部分已被填充）不一定是可解的。
 *      只需要根据以上规则，验证已经填入的数字是否有效即可。
 */
public class Sudoku {
    /**
     * 直接按照条件遍历
     * 首先遍历9宫格的所有元素，然后使用3个二维数组遍历，记录对应的行，列以及3*3单元格是否有某个数字，
     * 如果出现冲突，直接返回false。
     * @param board
     * @return
     */
    public boolean isValidSudokuByFor(char[][] board) {
        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字
        //比如line[0][3],表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3，有就存1，没有就存0
        //二维数组column表示的是对应的行中是否有对应的数字
        //比如column[0][3],表示的是第0列（实际上是第1列，因为数组的下标是从0开始的）是否有数字3，有就存1，没有就存0
        //二维数组cell表示的是对应的行中是否有对应的数字
        //比如cell[0][3],表示的是第0个单元格（实际上是第1个，因为数组的下标是从0开始的）是否有数字3，有就存1，没有就存0
        int[][] line = new int[length][length];
        int[][] column = new int[length][length];
        int[][] cell = new int[length][length];
        for (int i = 0; i < length; ++i)
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                //num是当前格子的数字,减1是因为后面可能出现数组越界，把1-9的值变成了0-8的值了，这样就不会越界了
                int num = board[i][j] - '0' - 1;
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个有数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                    return false;
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        return true;
    }

    /**
     * 用位运算解决
     * 上面使用的是二维数组，实际上我们还可以使用一维数组，直接使用位运算来存储，
     * 因为在java中一个int类型是32位，用它来表示9位数字足够了。
     * int[] line = new int[9]：里面的9相当于数独盘的9行，每行一个int。
     * 由于一个int有32位，这里只用了9位二进制的0/1表示，就相当于数独盘的9列。int[i]的x位是1代表第i行出现了x。
     * shift = 1 << (board[i][j] - ’0’)： shift的二进制表示的 (board[i][j] - ’0’)位变成1。
     * line[j] |= shift：对第j行的9位二进制跟shift做或运算。
     * 举个例子：本次遍历第3（j）行，新增数字5，就把第5位变为1（shift = 1 << 5）,然后用或运算做记录
     * @param board
     * @return
     */
    public boolean isValidSudokuByBitOps(char[][] board) {
        int[] line = new int[9];
        int[] column = new int[9];
        int[] cell = new int[9];
        int shift = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                shift = 1 << (board[i][j] - '0');//1*2^(board[i][j])，最大就2^9，int是32位的，完全足够
                int k = (i / 3) * 3 + j / 3;//k表示所在单元格
                //如果对应的位置只要有一个大于0，说明有冲突，直接返回false
                if ((column[i] & shift) > 0 || (line[j] & shift) > 0 || (cell[k] & shift) > 0)
                    return false;
                column[i] |= shift;
                line[j] |= shift;
                cell[k] |= shift;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        char[][] board2 = new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        Sudoku sudoku=new Sudoku();
        System.out.println(sudoku.isValidSudokuByBitOps(board));
        System.out.println(sudoku.isValidSudokuByFor(board2));
    }
}
