public class MatricesSame {
    public int solve(int[][] A, int[][] B) {
        int Arow = A.length;
        int Brow = B.length;
        int Acol = A[0].length;
        if(Arow != Brow){
            return 0;
        }
        for(int i = 0; i < Arow; i++){
            for(int j = 0; j < Acol; j++){
                if(A[i][j] != B[i][j]){
                    return 0;
                }
            }
        }
        return 1;
    }
}
