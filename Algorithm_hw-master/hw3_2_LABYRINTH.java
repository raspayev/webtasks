
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class hw3_2_LABYRINTH{
    static int      size;
    static int[][]  map;
    static boolean [][]  mapForC;
    static int xc,yc;
    static int [] Position;
    static Stack st = new Stack();
    public static void main (String[]args) throws FileNotFoundException{
        kdtp("C://Users//acer//Desktop//map0.txt");
        //pm();
        provideStartPoint();
        st.push(Position);
        //pm1();
        dfs(Position);
        
    }
    public static void kdtp (String card) throws FileNotFoundException{//"C://Users//acer//Desktop//map0.txt"
        File file = new File(card);//(card);
        Scanner in = new Scanner(file);
        int column = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            if (line.length()<3){
                map = new int[Integer.parseInt(line)][Integer.parseInt(line)];
                mapForC = new boolean[Integer.parseInt(line)][Integer.parseInt(line)];
                size = Integer.parseInt(line);
            }
            else{
                String [] lineToArray = line.split(" ");
                for (int row = 0; row < lineToArray.length; row++) {
                    map[column][row] = Integer.parseInt(lineToArray[row]);
                    if(map[column][row]==1)mapForC[column][row]=true;
                    else mapForC[column][row]=false;
                }
                System.out.println();
                column++;
            }
        }
    }
    static void provideStartPoint(){
        for (int column = 0; column < map.length; column++) {
            for (int row = 0; row < map[column].length; row++) {
                if(map[column][row] == 2){
                    Position = new int[]{column,row};xc=column;yc=row;
                }
            }
        }
    }
    public static void pm(){
        for (int column = 0; column < map.length; column++) {
            for (int row = 0; row < map[column].length; row++) {
                System.out.print(map[column][row]+" ");
            }
            System.out.println();  
        }
        System.out.println();
    }
    public static void pm1(){
        for (int column = 0; column < map.length; column++) {
            for (int row = 0; row < map[column].length; row++) {
                System.out.print(mapForC[column][row]+" ");
            }
            System.out.println();  
        }
        System.out.println();
    }
    public static void dfs(int x1[]){
        int x=x1[0];int y=x1[1];
        mapForC[x][y]=true;
        if(x==0 || y==0 || x==(size-1) || y == (size-1)){
            for(Object i:st){
                System.out.print("Move to : ");
                for(int c :(int[])i)
                    System.out.print(c+" ");
                System.out.println();
            }
            System.out.println();
        }
        else{
            if(!mapForC[x+1][y]){//niz
                st.push(new int[]{x+1,y});
                dfs(new int[]{x+1,y});
            }
            if(!mapForC[x][y-1]){//vlevo
                st.push(new int[]{x,y-1});
                dfs(new int[]{x,y-1});
            }
            if(!mapForC[x-1][y]){//verx
                st.push(new int[]{x-1,y});
                dfs(new int[]{x-1,y});
            }
            if(!mapForC[x][y+1]){//pravo
                st.push(new int[]{x,y+1});
                dfs(new int[]{x,y+1});
            }
        }
        st.pop();
    }
}