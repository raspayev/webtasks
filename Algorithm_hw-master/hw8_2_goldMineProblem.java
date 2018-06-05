public class hw8_2_goldMineProblem {
    static int n = 4, m = 4;
    static  int[][]map = new int[][]{
        {6,6,1,5},
        {9,1,7,4},
        {3,2,8,6},
        {1,15,9,2}
    };          
    public static void main(String []args){
        goldMineProblem();
        pm();
    }
    public static void goldMineProblem(){
        for(int j = 1;j < m;j++){
            for(int i = 0;i < n;i++){
                if(i==0){
                    int r = map[i][j-1];
                    int rD = map[i+1][j-1];
                    map[i][j] = map[i][j] + Math.max(r, rD);
                }
                else if(i==n-1){
                    int r = map[i][j-1];
                    int rU = map[i-1][j-1];
                    map[i][j] = map[i][j] + Math.max(r, rU);
            
                }
                else{
                    int r = map[i][j-1];
                    int rU = map[i-1][j-1];
                    int rD = map[i+1][j-1];
                    map[i][j] = map[i][j] + Math.max(Math.max(r, rU), rD);
                }
            }
        }
    }
    static void pm(){
        for(int i = 0;i < map.length;i++){
            for(int j = 0;j < map[i].length;j++)
                System.out.format("%3d",map[i][j]);
            System.out.println();
        }
        System.out.println("-----");
    }
}
