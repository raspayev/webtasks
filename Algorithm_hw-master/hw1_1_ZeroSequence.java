
import java.util.Scanner;

public class hw1_1_ZeroSequence {
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your numb:");
        
        String numb = in.nextLine();
        System.out.println();
        
        char [] b = numb.toCharArray();
        int [] c = new int[numb.length()];
        int x = 0,count = 0;
        
        for(int i = 0;i<numb.length();i++){
            if(b[i]=='0')
                count++;
            else{
                c[x]=count;x++;
                count = 0;
            }
        }
        if(b[numb.length()-1]=='0'){c[x]=count;System.out.println(count);}
        count = 0;
        for(int i = 0;i<x;i++){
                System.out.println(c[i]);
           if(c[i]>count)
               count=c[i];
        }
        System.out.println(count);
    }
}
