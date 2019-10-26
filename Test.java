1.
class Solution {
    public int climbStairs(int n) {
        int f1=1;
        int f2=2;
        int f3=0;
        if(n<3){
            return n;
        }
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
}



class Solution {
    public int maxSubArray(int[] nums) {
       int sum=0;
        int maxsum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum<0){
                sum=0;
            }
            if(sum>maxsum){
                maxsum=sum;
            }
        }
        return maxsum;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int i=0;
        for( i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                break;
            }
        }
        if(prices.length<2||i==(prices.length-1)){
            return 0;
        }
        int maxprice=0;
        int min=prices[0];
        for(i=0;i<prices.length;i++){
            maxprice=Math.max(maxprice,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return maxprice;
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int num=0;
       int[] res=new int[cost.length];
        for(int i=0;i<res.length;i++){
            if(i<2){
                res[i]=cost[i];
            }else{
                res[i]=Math.min(res[i-1],res[i-2])+cost[i];
            }
        }
        return Math.min(res[cost.length-1],res[cost.length-2]);
    }
}


class Solution {
    public int rob(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int[] res=new int[nums.length+1];
        res[0]=0;
        res[1]=nums[0];
        for(int i=2;i<=nums.length;i++){
            res[i]=Math.max(res[i-2]+nums[i-1],res[i-1]);
        }
        return res[nums.length];
    }
}
2.
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
class Solution {
    public int maxProduct(int[] nums) {
        int[] max=new int[nums.length];
        int[] min=new int[nums.length];
         max[0]=nums[0];
        min[0]=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            max[i]=Math.max(Math.max(max[i-1]*nums[i],min[i-1]*nums[i]),nums[i]);
            min[i]=Math.min(Math.min(max[i-1]*nums[i],min[i-1]*nums[i]),nums[i]);
            res=Math.max(max[i],res);
        }
        return res;
    }
}

3.
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length<2){
            return nums[0];
        }
        int[] res1=new int[nums.length];
        int[] res2=new int[nums.length];
        res1[0]=0;
        res1[1]=nums[0];
        for(int i=2;i<res1.length;i++){
            res1[i]=Math.max(res1[i-1],res1[i-2]+nums[i-1]);
        }
        res2[0]=0;
        res2[1]=nums[1];
        for(int i=2;i<res2.length;i++){
            res2[i]=Math.max(res2[i-1],res2[i-2]+nums[i]);
        }
        return Math.max(res1[nums.length-1],res2[nums.length-1]);
    }
}

