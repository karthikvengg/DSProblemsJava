/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;
import java.util.Scanner;
/**
 *
 * @author Karthikeyan_Varadara
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int abc[]=new int[N];
        for(int i=0;i<N;i++){
            abc[i]=sc.nextInt();
        }        
        MergeSort ms = new MergeSort();
        ms.mSort(abc);
        for(int i=0;i<abc.length;i++){
            System.out.print(abc[i]+" ");
        }
        System.out.println();        
    }
    
    void mSort(int[] A){
        int n = A.length;
        if (n<2)
            return;
        int mid=n/2;       
        int l[] = new int[mid];
        int r[] = new int[n-mid];
        for(int i=0;i<mid;i++){
            l[i]=A[i];
        }
        for(int i=mid;i<n;i++){
            r[i-mid]=A[i];
        }        
        mSort(l);
        mSort(r);
        Merge(l,r,A);   
    }
    
    void Merge(int[] l,int[] r,int[] A){
        int nl=l.length;
        int nr=r.length;
        int i,k,j;
        i=j=k=0;
        while(i<nl && j<nr){
            if(l[i]<=r[j]){
                A[k]=l[i];
                i++;
            }
            else{
                A[k]=r[j];                
                j++;                
            }
            k++;
        }
        while(i<nl){
            A[k]=l[i];
            i++;
            k++;
        }
        while(j<nr){
            A[k]=r[j];
            j++;
            k++;
        }        
    }   
}
