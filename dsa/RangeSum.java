public class RangeSum {
    public long[] rangeSum(int[] A, int[][] B) {
        //construct Prefix sum 
        int len = A.length;
        long pf_sum[] = new long[len];
        pf_sum[0] = A[0];
        for(int i = 1; i < len;i++){
            pf_sum[i] = pf_sum[i-1] + A[i];
        }
        //run through 2D Array and provide Sum and assign it to new Array
        /*
        0 3
        1 2
        */
       int row = B.length;
       int col = B[0].length;
       long ans[] = new long[row];
       for(int r = 0; r < row; r++){
            int L = B[r][0];
            int R = B[r][1];
            //long sum = 0;
            if(L > 0){
                ans[r] = pf_sum[R] - pf_sum[L-1];
            }else{
                ans[r] = pf_sum[R];
            }
        }
        return ans;
    }
}
/*You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.


 */