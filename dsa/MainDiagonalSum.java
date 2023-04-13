public class MainDiagonalSum {
    public int solve(final int[][] A) {
        int i = 0, j = 0;
        int row = A.length;
        int sum = 0;
        while(i < row){
            sum = sum + A[i][j];
            i++;
            j++;
        }
        return sum;
    }
}
