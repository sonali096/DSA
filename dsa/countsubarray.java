public class countsubarray {
    public int solve(int[] A, int B) {
        int n = A.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum = sum + A[j];
                if(sum < B){
                    count++;
                }
            }
        }
        return count;
    }
}
/*countsubarray */