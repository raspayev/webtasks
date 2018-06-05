
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class hw2_2_Museum {
    static int maxCustomers = 0;
    static int timeNa4alo = 0;
    static int timeEnd = 0;
    static Map<Integer,Integer> time = new TreeMap<Integer,Integer>();
    public static void main(String []args) throws FileNotFoundException{
        keepDataToMap("C://Users//acer//Desktop//Museum.txt");//C://Users//acer//Desktop//map0.txt
        System.out.println(maxValue());
    }
    static void keepDataToMap(String museum) throws FileNotFoundException{
        File file = new File(museum);
        Scanner in = new Scanner(file);
        while(in.hasNext()){
            String line = in.nextLine();
            if(line.length() < 3){
                maxCustomers = Integer.parseInt(line);
            }
            else{
                String [] lineToArray = line.split(" ");//printArr(lineToArray);
                String [] na4alo = lineToArray[0].split(":");
                timeNa4alo = (Integer.parseInt(na4alo[0])) * 60 + (Integer.parseInt(na4alo[1]));
                String [] End = lineToArray[1].split(":");
                timeEnd = (Integer.parseInt(End[0])) * 60 + (Integer.parseInt(End[1]));
                for(int i = timeNa4alo;i<=timeEnd;i++){
                    if(!(time.containsKey(i))){
                        time.put(i, 1);
                    }
                    else{
                        int value = time.get(i);
                        value++;
                        time.put(i,value);
                    }
                }
            }
        }
    }
    static void printArr(String[] arr){
        for (int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);//+"   This  " + i);
        }
    }
    static int maxValue(){
        int maxVal = 0;
        Set<Map.Entry<Integer,Integer>> entrySet = time.entrySet();
        for(Map.Entry<Integer,Integer> entry:entrySet){
            if(maxVal<entry.getValue()){
                maxVal = entry.getValue();
            }
            
        }
        if(maxVal>maxCustomers){System.out.println("Error");}
        return maxVal;
    }
}
