/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findanagram;

/**
 *
 * @author Karthikeyan_Varadara
 */
public class FindAnagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String src = "abc";
        String ls[]=new String[5];
        ls[0]="sdf";
        ls[1]="bca";
        ls[2]="erg";
        ls[3]="acb";
        ls[4]="abc";
        for(int i=0;i<ls.length;i++){
            int count = 0;
            for(int j=0;j<src.length();j++){
                if(ls[i].contains(""+src.charAt(j))) {
                    count++;
                }
            }
            if (count==src.length())
                System.out.println(i);
        }        
    }
    
}
