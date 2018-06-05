
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class hw1_2_KatyaVasyaProblem {
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter x*y:");
        int mult = in.nextInt();
        System.out.print("Enter x+y:");
        int sum = in.nextInt();
        Map<Integer,Integer> mapForMult = new TreeMap<Integer, Integer>();
        //Map<Integer,Integer> mapForSum = new TreeMap<Integer, Integer>();
        for(int i = 1;i<mult;i++){
            if(mult%i==0){
                mapForMult.put(i, mult/i);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = mapForMult.entrySet();
        for (Map.Entry<Integer, Integer> entry: entrySet){
            if((entry.getValue() + entry.getKey())==sum){
                System.out.println(entry.getValue() + "\t" + entry.getKey());break;
            }
        }
    }
}
