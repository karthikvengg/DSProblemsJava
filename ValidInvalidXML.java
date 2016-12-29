    
    /*Sample inputs
    1. 
    <Books><Book><name>aaa</name><author>auth1</author><Book><Book><name>bbbb</name><author>auth2</author><Book></Books>
    2.
    <books><book><name><name></name></name></book></books>
    
    Given:
    Tag t = getNextTag()
    t.name 
    isClosingTag(t);
    
    Solution:
    public static void main(String args[]){
        XML abc;
        List<String> ls=new LinkedList<string>();
        String a="test";
        Tag t;
        while(a!=null){
            t = XML.getNextTag();
            a = t.name;
            if(ls==null){
                ls.add(a);
                continue;
            }    
            for(int i=0;i<ls.size;i++){
                if(!a.equals(ls.get(i))){
                    ls.add(a);
                }
                else{
                    if(isClosingTag(t)==true){
                        ls.remove(i); 
                        break;
                    }         
                    ls.add(a);
                }
            }
        }
        
        if(ls==null){
            System.out.println("Valid XML")
        }
        else{
            System.out.println("Invalid XML")
        }
    }

