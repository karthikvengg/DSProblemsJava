/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubblesort;
import java.util.Scanner;
/**
 *
 * @author Karthikeyan_Varadara
 */
public class BubbleSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int abc[]=new int[N];
        for(int i=0;i<N;i++){
            abc[i]=sc.nextInt();
        }
        int M = N;
        for(int k=0;k<M--;k++){                    
            for(int i=0;i<N-1;i++){
                if (abc[i]>abc[i+1]){
                    int temp;
                    temp = abc[i];
                    abc[i]=abc[i+1];                
                    abc[i+1] = temp;
                }                                    
            }
        }
        for(int i=0;i<N;i++){
            System.out.print(abc[i]+" ");
        }
    }
    
}
