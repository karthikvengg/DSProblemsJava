
/* Print the common elements in 3 arrays. Efficient solution. O(n)*/

import java.io.*;
import java.util.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i:a)
            hm.put(i,1);
        for(int i:b){
            if(!hm.containsKey(i))
                hm.put(i, 1);
            else{
                int d=hm.get(i);
                hm.put(i, ++d);
            }
        }
        for(int i:c){
            if(!hm.containsKey(i))
                hm.put(i, 1);
            else{
                int d=hm.get(i);
                hm.put(i, ++d);
            }
        }         
        for(Map.Entry i:hm.entrySet()){
            if ((int)i.getValue()==3)
                System.out.println(i.getKey());
        }                
    }
}
 
