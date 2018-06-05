public class hw10_1_degreeForEachV {
    static int size = 5;
    static int[][]map={
            {1,1,0,0,0},
            {0,0,1,0,1},
            {1,0,1,0,1},
            {0,1,0,0,1},
            {1,0,0,0,1}
        };
    public static void main(String[]args){
        degreeForEachV();
    }
    
    static void degreeForEachV(){
        int[]arr = new int[size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(map[i][j]==1)
                    arr[i]++;
            }
        }
        for(int j=0;j<size;j++){
            for(int i=0;i<size;i++){
                if(map[i][j]==1)
                    arr[j]++;
            }
        }
        for(int i=0;i<size;i++)
            System.out.print(arr[i]+" ");
    }
}
