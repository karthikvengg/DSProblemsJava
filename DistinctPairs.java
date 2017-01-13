/*
Count all distinct pairs with difference equal to k
Count all distinct pairs with sum equal to k
 */
package DistinctPairs;
import java.util.*;
/**
 *
 * @author Karthikeyan_Varadara
 */

public class DistinctPairs{

    public static void main(String[] args) {
        //Count all distinct pairs with sum equal to k
        /*
        int arr[] = {1, 0, 3, 4, 2};
        Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
        int count = 0;
        int k = 3;
        for(int i=0;i<arr.length;i++)
            if(!hs.containsKey(arr[i]-k))
                hs.put(arr[i], i);
            else
                count++;
        System.out.print(count);
        */
        //Count all distinct pairs with difference equal to k
        int arr[] = {8, 12, 16, 4, 0, 20};
        Hashtable<Integer,Integer> hs = new Hashtable<Integer,Integer>();
        int count = 0;
        int k = 4;
        for(int i=0;i<arr.length;i++)
            if(!hs.containsKey(arr[i]))
                hs.put(arr[i], i);
        
        for(int i=0;i<arr.length;i++){
            if(hs.containsKey(arr[i]+k))
                count++;
            if(hs.containsKey(arr[i]-k))
                count++;
            hs.remove(arr[i]);
        }
        System.out.print(count);
    }
}