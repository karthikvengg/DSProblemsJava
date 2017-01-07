import java.util.*;


class CoolNumbers {

    public static void main(String args[] ) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int l,r,sum;
        for (int i = 0; i < N; i++) {
            l = s.nextInt();
            r = s.nextInt();
            sum = 0;
            for(int j=l;j<=r;j++){
                sum = sum + f(j);
            }                
            System.out.println(sum);
        }
    }    
    static int f(int n){
        String a=""+n;
        int digits=a.length();
        int arr_len1=(int)Math.pow(2,digits);
        
        int arr1[]=new int[arr_len1];
        
        values(arr1,arr_len1,digits);
        
        if(n>arr1[arr1.length-1]){
            int arr_len2=(int)Math.pow(2,digits+1);
            int arr2[]=new int[arr_len2];
            values(arr2,arr_len2,digits+1);
            return arr2[0];
        }    
        else if(n<=arr1[0])
            return arr1[0];
        else{
            for(int i=0;i<arr1.length;i++){
                if(n<=arr1[i])
                    return arr1[i];
            }
        }
        return 0;
    }

    static void values(int []arr,int arr_len,int digits){
        String x,zeros;
        for(int i=0;i<arr_len;i++){            
            zeros="0";
            x = Integer.toBinaryString(i);
            if (x.length()<digits){
                for(int j=0;j<(digits-x.length()-1);j++)
                    zeros=zeros+"0";
                x = zeros+x;
            }
                x = x.replaceAll("0", "2");
                x = x.replaceAll("1", "5");        
                arr[i]=Integer.parseInt(x);
        }
    }    
}