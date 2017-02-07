/* 
Given a array of integer which contains 0's , 1's and 2's.
Write a program to sort it with minimum time complexity and space complexity.
*/

package sort;
import java.util.*;


class Sort {
    public static void main(String args[] ) throws Exception {
        //int []arr ={0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        //int []arr ={2,0,1,2,1,0,2,1,1};
        int []arr={1,2,1,2,1,2,0,0,1,2};
        int start=0,next=1,end=arr.length-1,temp;
        for(int i=0;i<arr.length;i++){
            if(end<next)
                break;
            if(arr[start]>arr[end]){
                temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
            if(arr[start]==0)
                start++;
            if(arr[end]==2)
                end--;
            if(arr[next]==0){
                temp=arr[start];
                arr[start]=arr[next];
                arr[next]=temp;
                start++;
            }
            if(arr[next]==2){
                temp=arr[end];
                arr[end]=arr[next];
                arr[next]=temp;
                end--;
            }            
            next++;
        }
        
        for(int i:arr)
            System.out.print(i+" ");
    }
}
