
import java.util.ArrayList;

public class hw7_2_LargestRect {
    static int[][]d;
    static ArrayList<String> obj = new ArrayList<String>();
    public static void main(String[]args){
        int[][]a = new int[][]{
            {1,2,3,-5},
            {1,2,3,-5},
            {5,-10,9,-1}
        };
        largestRect(a);
    }
    public static void largestRect(int[][] a){
        d = new int[a.length][a[0].length];
        for(int i = 0;i<d.length;i++){
            for(int j = 0;j<d[0].length;j++)
                d[i][j]=0;
            
        }
        for(int i = 0;i<d.length;i++){
            for(int j = 0;j<d[0].length;j++){
                if(i==0 && j==0)
                    d[0][0] = a[0][0];
                else if(j==0){
                    d[i][j] = d[i-1][j]+a[i][j];
                }
                else if(i==0){
                    d[i][j] = d[i][j-1]+a[i][j];
                }
                else{
                    d[i][j] = d[i-1][j]+a[i][j];
                    for(int x = 0;x<j;x++){
                        d[i][j]+=a[i][x];
                    }
                }
            }
        }
        for(int i = 0;i<d.length;i++){
            for(int j = 0;j<d[0].length;j++)
                System.out.format("%3d",d[i][j]);
            System.out.println("");
        }
        int sum=0;
        for(int i = 0;i<d.length;i++){
            for(int j = 0;j<d[0].length;j++){
                if(sum<=d[i][j]){
                    sum=d[i][j];
                    obj.add( i + " " + j );
                }
            }
        }
        
        System.out.println("  MAX-sum --> " + sum);
        System.out.println("  Where   --> " + obj.get(obj.size()-1));
    }
}
