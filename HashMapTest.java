/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmaptest;
import java.util.*;
/**
 *
 * @author Karthikeyan_Varadara
 */
class Test{
    private String i;
    Test(String x){
        this.i=x;
    }    
    
    @Override
    public int hashCode(){
        return i.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        //System.out.println(obj.toString());
        return this.i.equals("karthik");        
    }
}
public class HashMapTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String,Double> hm=new HashMap<>();
        Map<String,Double> sortedMap=new HashMap<>();
        Map<Test,Double> hm2=new HashMap<>();
        Test t = new Test("karthik");
        hm2.put(t, new Double(34.34));
        hm.put("Zara", new Double(3434.34));
        hm.put("Mahnaz", new Double(123.22));
        hm.put("Ayan", new Double(1378.00));
        hm.put("Daisy", new Double(99.22));
        hm.put("Qadir", new Double(-19.08));
        System.out.println(hm.get("Zara"));
        System.out.println(hm2.get(new Test("karthik")));
        System.out.println();
        List<Double> ls=new LinkedList<>();
        for(Map.Entry m:hm.entrySet()){
            System.out.print(m.getKey()+" ");
            System.out.println(m.getValue());
            ls.add((Double)m.getValue());
        }
        Collections.sort(ls);
        System.out.println();
        int i = 0;
        for(Map.Entry m:hm.entrySet()){
            sortedMap.put((String)m.getKey(), ls.get(i));
            i++;
        }
        Iterator itr=hm.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry m = (Map.Entry)itr.next();
            System.out.print(m.getKey()+" ");
            System.out.println(m.getValue());
        }
        System.out.println();
        System.out.println("Sorted Map:");
        Iterator itr2=sortedMap.entrySet().iterator();
        while(itr2.hasNext()){
            Map.Entry m = (Map.Entry)itr2.next();
            System.out.print(m.getKey()+" ");
            System.out.println(m.getValue());
        }        
    }    
}
