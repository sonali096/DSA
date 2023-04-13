public class ProductArray {
    public int[] solve(int[] A) {
        int len = A.length;
        int product = 1;
        for(int i = 0; i < len; i++){
            product = product * A[i];
        }
        //construct product Array
        int arr[] = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = product / A[i];
        }
        return arr;
    }
}
