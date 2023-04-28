//Max consecutive 1’s
package Interview;

public class MaxConsecutive1 {
    public int solve(String A) {
        int len = A.length();
        int arr[] = new int[len];
        int cntofone = 0, ans = 0,cntofzero = 0;
        for(int i = 0; i < len;i++){
            char ch = A.charAt(i);
            arr[i] = Integer.parseInt(String.valueOf(ch));
            if(arr[i] == 1){
                cntofone++;
            }else{
                cntofzero++;
            }
        }
        if(cntofone == len){
            return len;
        }else if(cntofzero == len){
            return 0;
        }
        //count left and right
        for(int i = 0; i < len; i++){
            if(arr[i] == 1){
                continue;
            }
            //calculate l
            int l = 0;
            for(int j = i-1; j >= 0; j--){
                if(arr[j] == 1){
                    l++;
                }else{
                    break;
                }
            }
            //calculate r
            int r = 0;
            for(int j = i+1; j < len; j++){
                if(arr[j] == 1){
                    r++;
                }else{
                    break;
                }
            }
            int count = l+r+1;
            ans = Math.max(ans, count);
        }
        return ans;
    }
}
/*Given a binary arr[], we can atmost replace a single 0 with 1.
Find the max consecutive 1’s we can get in the arr[]. TC - O(n)
 */