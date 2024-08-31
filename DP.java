public class DP {

    public static int fib(int n,int[] dp){
        if(n==0 || n==1){
            return n;
        }
        
        if(dp[n]!=0){
            return dp[n];
        }
        
        dp[n]=fib(n-1,dp)+fib(n-2,dp);

        return dp[n];
    }

    public static int fibT(int n,int[] dp){
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


    public static int knapsack(int[] val,int[] w ,int wt, int n,int[][] dp){
        if(wt==0 || n==0){
            return 0;
        }

        if(dp[n][wt]!=-1){
            return dp[n][wt];
        }

        if(w[n-1]<=wt){
            dp[n][wt]=Math.max(val[n-1]+knapsack(val, w, wt-w[n-1], n-1,dp),knapsack(val, w, wt, n-1,dp));
        }else{
            dp[n][wt]=knapsack(val, w, wt, n-1,dp);
        }

        return dp[n][wt];

    }

    public static int knapsackT(int[] val,int[] w,int wt,int n){
        int[][] dp=new int[n+1][wt+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<wt+1;j++){
                if(w[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-w[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][wt];
    }

    public static boolean TargetSum(int[] num,int m,int n){
        boolean[][] dp=new boolean[n+1][m+1];
        for(int i=1;i<n+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<n+1;i++){ //number
            for(int j=1;j<m+1;j++){ //sum
                if(num[i-1]<=j && dp[i-1][j-num[i-1]]){
                    dp[i][j]=true;
                }else if(dp[i-1][j]){
                    dp[i][j]=true;
                }
            }
        }
        
        return dp[n][m];
    }
    public static void main(String[] args){
        //System.out.println("Hello world");

        //Q.1 climing stairs
        int n=7;
        int dp[]=new int[n+1];
        System.out.println(fibT(n,dp));

        //Q.2 0-1 knapsack
        int[] val={15,14,10,45,30};
        int[] w={2,5,1,3,4};
        int wt=7;
        int[][] dp1=new int[val.length+1][wt+1];

        for(int i=0;i<val.length+1;i++){
            for(int j=0;j<wt+1;j++){
                dp1[i][j]=-1;
            }
        }

        System.err.println(knapsackT(val, w, wt, val.length));

        //Q.3 Target sum k
        int[] numbers={4,2,7,1,3};
        int target=10;
        System.err.println(TargetSum(numbers,target,numbers.length));
    }
}
