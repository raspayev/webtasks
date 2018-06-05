
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class hw4_1_ReversePolishNot {
    static String plus="+";
    static String min="-";
    static String mult="*";
    static String div="/";
    static String equal="=";
    static String rBr="(";
    static String lBr=")";
    static String nothing = " ";
    static Map <String,Integer> arr = new HashMap<String,Integer>();
    public static void main(String[]args){
        arr.put(nothing,0);
        arr.put(equal,1);
        arr.put(rBr,2);
        arr.put(plus,3);
        arr.put(min,3);
        arr.put(mult,4);
        arr.put(div,4);
        arr.put(lBr,5);
        String str = "3 + 2 * 5";//3 6 24 - * 2 +
        toRevPolishNot(str);
    }
    public static String toRevPolishNot(String s){
        String output = "";
        Stack st = new Stack();
        st.push(nothing);
        String[] sToArr = s.split(" ");
        for(String c : sToArr){
            if(!arr.containsKey(c)){
                output=output + c + " ";
            }
            else if(rBr.equals(c)){
                st.push(c);
            }
            else if(lBr.equals(c)){
                while(!rBr.equals(st.peek())){
                    output=output + st.pop() + " ";
                }
                st.pop();
            }
            else{
                if(st.isEmpty())
                    st.push(c);
                else{
                    if(arr.get(c)>arr.get(st.peek())){st.push(c);}
                    else{
                        if(arr.get(c)==arr.get(st.peek())){
                            while(arr.get(c)==arr.get(st.peek())){
                                String d = String.valueOf(st.pop());
                                output=output + d + " ";
                            }
                        }
                        while(arr.get(c)<arr.get(st.peek())){
                            String d = String.valueOf(st.pop());
                            output=output + d + " ";
                        }
                        st.push(c);
                    }
                }
            }
            
        }
        while(!st.isEmpty()){
            String q = String.valueOf(st.pop());
            output=output + q + " ";
        }
        System.out.println(output);
        return output;
    }
    
}
