
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class hw9_2_2 {
    static int size = 5;
    static int[][]map={
            {0,2,0,0,7},
            {2,0,1,0,3},
            {0,1,0,0,2},
            {0,0,0,0,2},
            {7,3,2,2,0}
        };
    static Stack st = new Stack();
    static Map var = new HashMap();//path & length
    static ArrayList<Integer> lengths = new ArrayList<Integer>();
    
    public static void main(String[]args){
        st.push(0);
        shortestPath(0);
        Collections.sort(lengths);
        for(Object key: var.keySet()){
            if(var.get(key)==lengths.get(0)){
                System.out.println(var.get(key));
                System.out.println(key);
            }
        }
        System.out.println();

    }
    static void shortestPath(int x){
        if(x==(size-1)){
            int length=0;
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(Object i:st){
                arr.add((int)i+1);
            }
            for(int i=0;i<arr.size()-1;i++){
                length+=map[arr.get(i)-1][arr.get(i+1)-1];
            }
            var.put(arr,length);
            lengths.add(length);
        }
        else{
            for(int i=0;i<size;i++){
                if(map[x][i]!=0 && x<i){
                    st.push(i);
                    shortestPath(i);
                }
            }
        }
        st.pop();
    }
}
