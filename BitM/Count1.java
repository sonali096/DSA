package BitM
public class Count1 {
    public int count(int n){
        int cnt=0;
        while(n){
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args){
        int A = 20;
        int result  = count(A);
        System.out.println(result);
    }

    
}
