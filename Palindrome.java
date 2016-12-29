/*
 Given a linked list. Check whether it is a palindrome (without using any extra space).
 */
package palindrome;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Karthikeyan_Varadara
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();        
        //sc.next();        
        List<Character> ls=new LinkedList<Character>();
        for(int i=0;i<N;i++){
            ls.add(Character.toLowerCase(sc.next().charAt(0)));
        }              
        int n = ls.size();
        int count=0;
        for(int i=0;i<n/2+1;i++){
            if(ls.get(i).equals(ls.get(n-i-1))){
                count++;
            }
        }
        count++;
        if(count==ls.size()){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a Palindrome");
        }
    }
    
}
