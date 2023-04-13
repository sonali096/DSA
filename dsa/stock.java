public class stock {
    public int maxProfit(final int[] A) {
        int n = A.length;
        if(n==0){
            return 0;
        }
        // 1 4 5 2 4
        int min_value = Integer.MAX_VALUE, max_value = 0;
        for(int i = 0; i < n; i++){
            min_value = Math.min(min_value, A[i]);
            max_value = Math.max(max_value,A[i]-min_value);
        }
        //Find index to buy ans sell stock
        // int max_i = -1, min_i = -1;
        // int ans = n;
        // for(int i = n-1; i )
        return max_value;
    }
}
