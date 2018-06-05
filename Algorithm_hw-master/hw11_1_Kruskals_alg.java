

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class hw11_1_Kruskals_alg {
    static ArrayList<String> vertexes;
    static Map<String, Integer> map;
    
    public static void main(String []args){
        vertexes = new ArrayList<String>();
        vertexes.add("a");vertexes.add("b");vertexes.add("c");vertexes.add("d");vertexes.add("e");
        vertexes.add("f");
        //vertexes.add("g");vertexes.add("h");vertexes.add("i");
        
        map = new TreeMap<String, Integer>();
        /*map.put("ad",1);map.put("de",6);
        map.put("ef",2);map.put("ce",5);
        map.put("cf",4);map.put("dc",1);
        map.put("bd",3);map.put("ab",3);
        map.put("bc",1);*/
        map.put("ab",4);
        map.put("ah", 8);
        map.put("hi",7);
        map.put("bh",11);
        map.put("bc",8);
        map.put("ci",2);
        map.put("gi",6);
        map.put("gh",1);
        map.put("gf",2);
        map.put("cf",4);
        map.put("cd",7);
        map.put("de",9);
        map.put("df",14);
        map.put("ef",10);
        System.out.println(entriesSortedByValues(map));
        algorithm();
        
    }
    
    static void algorithm(){
        for (Map.Entry<String,Integer> pair: (entriesSortedByValues(map))) {
            int var = 0;//if the vertexes in deff sets
            String v1 = pair.getKey().substring(0,1);//startVertex
            String v2 = pair.getKey().substring(1,2);//endVertex
            
            for(String vertex:vertexes){
                if(vertex.contains(v1) && vertex.contains(v2)){
                    var=1;
                }
            }
            if(var==0){
                String total = "";//for new set of two vertices
                String del1="",del2="";//ConcurrentModificationException we cant remove when we are in the for loop
                for(String vertex:vertexes){
                    if(vertex.contains(v1)){
                        total += vertex;
                        del1=vertex;
                    }
                    else if(vertex.contains(v2)){
                        total+=vertex;
                        del2=vertex;
                    }
                }
                vertexes.remove(del1);vertexes.remove(del2);
                System.out.println(pair.getKey()+":"+pair.getValue());//edge which we use
                vertexes.add(total);
            }
            if(vertexes.size()==1){return;}
            
            //System.out.println(vertexes);
        }   
    }
    
    
    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e1.getValue().compareTo(e2.getValue());
                    return res != 0 ? res : 1;
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
