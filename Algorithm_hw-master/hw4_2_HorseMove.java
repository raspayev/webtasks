import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class hw4_2_HorseMove {
    static int      size;
    static int mov = 2;
    static int[][]  map;
    static int steps;
    static int xc,yc;//initial pos
    static int [] Position;
    static int [] Position1;
    static int xq,yq;//destination pos
    static String[] pos;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[]args) throws FileNotFoundException{
        kdtp("C://Users//acer//Desktop//map3.txt");
        provideStartPoint();
        ok();
        pm();
        System.out.println("Steps:" + steps);
        
    }
    static void provideStartPoint(){
        for (int column = 0; column < map.length; column++) {
            for (int row = 0; row < map[column].length; row++) {
                if(map[column][row] == 2){
                    Position = new int[]{column,row};xc=column;yc=row;queue.offer(Position);
                    
                }
                if(map[column][row] == 1){
                    Position1 = new int[]{column,row};xq=column;yq=row;
                }
            }
        }
    }
    public static void kdtp (String card) throws FileNotFoundException{//"C://Users//acer//Desktop//map0.txt"
        File file = new File(card);//(card);
        Scanner in = new Scanner(file);
        int column = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            if (line.length()<3){
                map = new int[Integer.parseInt(line)][Integer.parseInt(line)];
                size = Integer.parseInt(line);
            }
            else{
                String [] lineToArray = line.split(" ");
                for (int row = 0; row < lineToArray.length; row++) {
                    map[column][row] = Integer.parseInt(lineToArray[row]);
                }
                System.out.println();
                column++;
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
    public static void ok(){
        while(queue.size()>0){
            int[] move = queue.remove();
            int x = move[0];int y = move[1];
            mov = map[x][y]+1;
            steps=map[x][y]-1;
            if((x-2)>0 && (y+1)<map.length && map[x-2][y+1]==1)
                return;
            moove(x-2,y+1);
            if((x-1)>0 && (y+2)<map.length && map[x-1][y+2]==1)
                return;
            moove(x-1,y+2);
            if((x+1)<map.length && (y+2)<map.length && map[x+1][y+2]==1)
                return;
            moove(x+1,y+2);
            if((x+2)<map.length && (y+1)<map.length && map[x+2][y+1]==1)
                return;
            moove(x+2,y+1);
            if((x+2)<map.length && (y-1)>0 && map[x+2][y-1]==1)
                return;
            moove(x+2,y-1);
            if((x+1)<map.length && (y-2)>0 && map[x+1][y-2]==1)
                return;
            moove(x+1,y-2);
            if((x-1)>0 && (y-2)>0 && map[x-1][y-2]==1)
                return;
            moove(x-1,y-2);
            if((x-2)>0 && (y-1)>0 && map[x-2][y-1]==1)
                return;
            moove(x-2,y-1);
        }
        
    }
    static void moove(int x,int y){
        if(0<=x && x<8 && 0<=y && y<8){
            if(map[x][y]==0){
                int [] vrem;
                map[x][y]=mov;
                vrem = new int[]{x,y};
                queue.offer(vrem);
            }
        }
    }
    
}