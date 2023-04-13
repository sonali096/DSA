public class MatrixSubtraction {
    public int[][] solve(int[][] A, int[][] B) {
        int row = A.length;
        int col = A[0].length;
        int ans[][] = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans[i][j] = A[i][j] - B[i][j];
            }
        }
        return ans;
    }
}
