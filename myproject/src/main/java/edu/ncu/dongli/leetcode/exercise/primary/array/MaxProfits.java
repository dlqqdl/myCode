package edu.ncu.dongli.leetcode.exercise.primary.array;

/**
 * 问题：买卖股票的最佳时机 II
 * 描述：
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例：
 *      输入: prices = [7,1,5,3,6,4]
 *      输出: 7
 *      解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *           随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 *      输入: prices = [1,2,3,4,5]
 *      输出: 4
 *      解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *           注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 *      输入: prices = [7,6,4,3,1]
 *      输出: 0
 *      解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfits {
    /**
     * 动态规划法
     * 定义dp[i][0]表示第i+1天交易完之后手里没有股票的最大利润，dp[i][1]表示第i+1天交易完之后手里持有股票的最大利润。
     * 递推公式:
     *      dp[i][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);
     *      dp[i][1]=max(dp[i-1][1],dp[i-1][0]-prices[i]);
     * 初始条件:
     *      dp[0][1]=-prices[0];
     *      dp[0][0]=0;
     * @param prices
     * @return
     */
    public int maxProfitByDP(int[] prices) {
        //边界判断
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        //初始条件：
        //第1天手里有股票的最大利润，进行的交易肯定是买入，所以利润是负的
        //第1天手里没有股票的最大利润，肯定是没有买入，所以利润为0
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候，利润才会最大，只需要返回dp[length - 1][0]即可
        return dp[length - 1][0];
    }

    /**
     * 动态规划法的优化：
     * 当天的利润只和前一天有关，没必要使用一个二维数组，只需要使用两个变量：
     *      一个记录当天交易完之后手里持有股票的最大利润
     *      一个记录当天交易完之后手里没有股票的最大利润
     * @param prices
     * @return
     */
    public int maxProfitByDP_Optimize(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        //初始条件
        int hold = -prices[0];//持有股票
        int noHold = 0;//没持有股票
        for (int i = 1; i < length; i++) {
            //递推公式：
            //noHold是没持有股票的，所以是前一天没持有股票，和昨日持有股票，但是今天卖光所得利润进行比较
            noHold = Math.max(noHold, hold + prices[i]);
            //hold是持有股票，所以是昨日持有股票，和今日没持有股票，但是买入后进行比较
            hold = Math.max(hold, noHold - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候利润才会最大，所以这里返回的是noHold
        return noHold;
    }

    /**
     * 贪心法：
     * 如果股票一直上涨，只需要找到股票上涨的最大值和股票开始上涨的最小值，计算他们的差就是这段时间内股票的最大利润。
     * 如果股票下跌就不用计算，最终只需要把所有股票上涨的时间段内的利润累加就是我们所要求的结果
     * @param prices
     * @return
     */
    public int maxProfitByGreedy(int[] prices) {
        //边界判断
        if (prices == null || prices.length < 2)
            return 0;
        int total = 0;
        int index = 0;
        int length = prices.length;
        while (index < length) {
            //如果股票下跌就一直找，直到找到股票开始上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1])
                index++;
            //股票上涨开始的值，也就是这段时间上涨的最小值
            int min = prices[index];
            //一直找到股票上涨的最大值为止
            while (index < length - 1 && prices[index] <= prices[index + 1])
                index++;
            //计算这段上涨时间的差值，然后累加
            total += prices[index++] - min;
        }
        return total;
    }

}
