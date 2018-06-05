
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class hw10_2_shortestPath{
    static int size = 5;
    static int[][]map={
            {0,2,0,0,7},
            {2,0,1,0,3},
            {0,1,0,0,2},
            {0,0,0,0,2},
            {7,3,2,2,0}
        };
    static boolean [][] visited = new boolean[size][size];
    static Stack st = new Stack();
    static Map var = new HashMap();//path & length
    static ArrayList<Integer> arr1 = new ArrayList<Integer>();
    
    public static void main(String[]args){
        st.push(0);
        visited[0][0]=true;
        shortestPath(0);
        Collections.sort(arr1);
        for(Object key: var.keySet()){
            if(var.get(key)==arr1.get(0)){
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
            arr1.add(length);
        }
        else{
            for(int i=0;i<size;i++){
                if(map[x][i]!=0 && !visited[x][i]){
                    visited[i][x]=true;visited[x][i]=true;
                    st.push(i);
                    shortestPath(i);
                }
            }
        }
        st.pop();
    }
}

