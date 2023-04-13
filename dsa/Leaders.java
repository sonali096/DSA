public class Leaders {
    public int solve(int arr[]){
        int n = arr.length;
        int ans = 1;
        int max_val = arr[n-1];
        for(int i = n-2; i >=0; i--){
            if(arr[i]> max_val){
                max_val = arr[i];
                ans++;
            }
        }
        return ans;
    }
}
