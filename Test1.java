1.
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的
最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res=new int[amount+1];
        Arrays.fill(res,amount+1);
        res[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    res[i]=Math.min(res[i],res[i-coins[j]]+1);
                }
            }
        }
        return res[amount]>amount?-1:res[amount];
    }
}


