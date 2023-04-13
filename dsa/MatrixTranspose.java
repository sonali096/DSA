public class MatrixTranspose {
    public int[][] solve(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int transpose[][] = new int[col][row];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }
}
