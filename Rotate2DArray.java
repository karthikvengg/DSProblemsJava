/*
Given a 2-D array, Rotate it by 90 degrees.
 */
package rotate2darray;

/**
 *
 * @author Karthikeyan_Varadara
 */

import java.io.*;
import java.util.*;

class Rotate2DArray
{
    public static void main (String[] args)
    {
        int[][] contents = {{1, 2}, {4, 5}, {7, 8}};
        //System.out.println(contents[0].length);
        for(int i=0;i<contents[0].length;i++){
            for(int j=contents.length-1;j>=0;j--){
                System.out.print(contents[j][i]);
            }
            System.out.println();
        }
        
    }
}