
/* Print the common elements in 3 arrays. Inefficient solution. O(n^3)*/

import java.io.*;
import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
		int[] a={1,2,3,4,5};
        int[] b={4,3,9,10};
        int[] c={2,3,8,4};
        
        List<Integer> ls=new ArrayList<Integer>();
        for(int i=0;i<a.length;i++)
            for(int j=0;j<b.length;j++)
                for(int k=0;k<c.length;k++)
                    if (a[i]==b[j])
                        if (b[j]==c[k])
                            System.out.println(c[k]);                                        
    }
}
 
