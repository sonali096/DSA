public class Addthematrices {
    public int[][] solve(int[][] A, int[][] B) {
        int Arow = A.length;
        int Brow = A.length;
        int Acol = A[0].length;
        int arraysum[][] = new int[Arow][Acol];
        for(int i = 0; i < Arow;i++){
            for(int j = 0; j < Acol; j++){
                arraysum[i][j] = A[i][j] + B[i][j];
            }
        }
        return arraysum;
    }
}
