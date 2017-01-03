/*
Time Complexity: O(logn)
Algorithmic Paradigm: Divide and Conquer
Find the median of two sorted arrays
 */
package median;

/**
 *
 * @author Karthikeyan_Varadara
 */
public class Median {

    static int a[]={1, 12, 15, 26, 38};
    static int b[]={2, 13, 17, 30, 45};
    public static void main(String[] args) {
        Median m = new Median();        
        m.findMedian(0,a.length-1,0,b.length-1);        
    }
    
    void findMedian(int a_start,int a_end,int b_start,int b_end){
        int n = (a_start+a_end)/2;
        int m = (b_start+b_end)/2;
        int median;
        if (a_end-a_start==1 && b_end-b_start==1){
            median = (Math.max(a[a_start], b[b_start])+Math.min(a[a_end], b[b_end]))/2;
            System.out.print(median);
            return;
        }
        if(a[n]>b[m]){
            findMedian(a_start,n,m,b_end);
        }
        else if(a[n]<b[m]){
            findMedian(n,a_end,b_start,m);
        }
        else{
            System.out.print(a[n]);
            return;
        }
        return;
    }
}
