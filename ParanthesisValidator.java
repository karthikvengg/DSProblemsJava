package test;

import java.util.Stack;

public class ParanthesisValidator {

    public static void main(String[] args) {

        String str = "(()(()))";
        Stack st = new Stack();
        int count = 0;
        for (Character c : str.toCharArray()) {
            //System.out.println(c);
            if (c.equals('('))
                st.push(c);
            else {
                if (!st.isEmpty()) {
                    st.pop();
                    count++;
                }


            }

        }
        if (st.isEmpty()) {
            System.out.println(count);
        } else
            System.out.println("-1");
    }
}