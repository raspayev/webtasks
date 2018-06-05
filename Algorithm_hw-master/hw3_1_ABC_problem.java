
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class hw3_1_ABC_problem {//12 24 54
    static Set<String> num1 = new LinkedHashSet<>();
    static Set<String> num2 = new LinkedHashSet<>();
    static Set<String> num3 = new LinkedHashSet<>();
    public static void main (String []args){
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] lineToArr = line.split(" ");
        Perm(lineToArr[0],0,num1);
        Perm(lineToArr[1],0,num2);
        Perm(lineToArr[2],0,num3);
        for (String el: num1){
            for (String el1: num2){
                if(num3.contains(String.valueOf((Integer.parseInt(el))+(Integer.parseInt(el1))))){
                    System.out.println(el + " " + el1 + " " + ((Integer.parseInt(el))+(Integer.parseInt(el1))));
                }
            }
        }//Perm("123", 0);
        
    }
    
    public static void permute(String str,Set<String> set){
        if(str==null || str.length()==0){
            return;
        }
        perm("",str,set);
    }
    public static void perm(String prefix,String str1,Set<String> set){
        if(str1.length() == 0){
       //     System.out.println(prefix);
            set.add(prefix);
            return;
        }
        for(int i = 0;i<str1.length();i++){
            //System.out.println(str1.substring(0,i)+"  "+i);
            perm(prefix+str1.charAt(i),str1.substring(0,i)+str1.substring(i+1,str1.length()),set);//perm("1",""+)
        }
    }
    public static void Perm(String array,int index,Set<String> set){
        if(index==array.length()){
            set.add(array);
        }
        else{
            for(int i=index;i<array.length();i++){
                array = swap(array, index, i,set);
                Perm(array,index+1,set);
                array = swap(array, index, i,set);
                
            }
        }
    }
    public static String swap(String str,int index,int i,Set<String> set){
        char temp;
        char[] arr = str.toCharArray();
        temp = arr[index];
        arr[index] = arr[i];
        arr[i]=temp;
        return String.valueOf(arr);
    }
}
