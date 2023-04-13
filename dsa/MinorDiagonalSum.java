public class MinorDiagonalSum {
    public int solve(final int[][] A) {
        int M = A.length;
        int i = 0, j = M-1;
        int sum = 0;
        while(i < M && j >= 0){
            sum = sum + A[i][j];
            i++;
            j--;
        }
        return sum;
    }
}
