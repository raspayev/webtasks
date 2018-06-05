
public class hw11_3_Floyd_Warshall_alg {
    static double[][] graph={
        {0,5,1,2},
        {5,0,3,0},
        {1,3,0,4},
        {2,0,4,0}};
    public static void main(String[]args){
        algorithm();
    }
    static void algorithm(){
        double[][]sequenceMap = new double[graph.length][graph.length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                sequenceMap[i][j]=graph[i][j];
                if(i==j)
                    sequenceMap[i][j]=0;
                else if(graph[i][j]==0)
                    sequenceMap[i][j]=Double.POSITIVE_INFINITY;
            }
        }
        for(int k = 0;k<graph.length;k++){
            for(int i = 0;i<graph.length;i++){
                for(int j = 0;j<graph.length;j++){
                    if(i==k || j==k || i==j){
                    }
                    else{
                        if(sequenceMap[i][j]>sequenceMap[i][k]+sequenceMap[k][j]){
                            sequenceMap[i][j]=sequenceMap[i][k]+sequenceMap[k][j];
                        }
                    }
                }
            }
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                System.out.format("%3d",(int)sequenceMap[i][j]);
            }
            System.out.println();
        }
        
    }
}
