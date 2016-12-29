
/* Print the common elements in 3 arrays. Inefficient solution. O(n^4)*/

import java.io.*;
import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] a={1,2,3,4,5};
        int[] b={4,7,9,10};
        int[] c={2,6,8,9};
        
        List<Integer> ls=new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if (a[i]==b[j]){
                    ls.add(a[i]);
                }
            }
        }
        for(int k=0;k<c.length;k++){     
            for(int f:ls){
                if(c[k]==f){
                    System.out.println(f);
                }                
            }            
        }
    }
}
 
