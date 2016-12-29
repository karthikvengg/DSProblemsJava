/*
Search an element in an array where difference between adjacent elements is 1
 */
package FirstOccurance;

import java.util.*;
import java.lang.*;

public class FirstOccurance {

    public static void main(String[] args) {               
        int arr[] = {1, 2, 3, 4, 5, 4};
        int s = 5;
        int i = 0;
        boolean flag=false;
        while (s!=arr[i]){
            int diff = Math.abs(s-arr[i]);
            i=i+diff;
            if(i>arr.length)
                break;
            if(s==arr[i]){
                System.out.println(i);
                flag=true;
                break;
            }                
        }
        if (flag==false)
            System.out.println("Not found");
    }
}