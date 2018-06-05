
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class hw2_1_Sudoku {
    static int size;
    static int[][] map;
    public static void main (String [] args) throws FileNotFoundException{
        keepDataToMap("C://Users//acer//Desktop//Sudoku.txt");
        if(check(map))
            System.out.println("Correct");
        else 
            System.out.println("Wrong");
    }
    public static void keepDataToMap (String card) throws FileNotFoundException{
        File file = new File(card);
        Scanner in = new Scanner(file);
        int column = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            if (line.length()<3){
                size = Integer.parseInt(line);
                map = new int[size*size][size*size];
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
    public static void printMap(){
        for (int column = 0; column < map.length; column++) {
            for (int row = 0; row < map[column].length; row++) {
                System.out.print(map[column][row]+" ");
            }
            System.out.println();  
        }
        System.out.println();
    }
    public static boolean check(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            int[] row = new int[map.length];
            int[] sq = new int[map.length];
            int[] column = map[i].clone();

            for (int j = 0; j < map.length; j ++) {
                row[j] = map[j][i];
                sq[j] = map[(i / size) * size + j / size][i * size % map.length + j % size];
            }
            if (!(isTrue(column) && isTrue(row) && isTrue(sq)))
                return false;
        }
        return true;
    }
    public  static boolean isTrue(int[] check) {
        int i = 1;
        Arrays.sort(check);
        for (int number : check) {
            if (number != i){
                return false;
                
            }
            i++;
        }
        return true;
    }
}

