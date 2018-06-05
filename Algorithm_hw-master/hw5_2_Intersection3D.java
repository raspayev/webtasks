public class hw5_2_Intersection3D {
    static double s,t;
    static int[] startPointOfLine1 = new int[]{6,8,4};
    static int[] endPointOfLine1 = new int[]{12,15,4};
    static int[] startPointOfLine2 = new int[]{6,8,2};
    static int[] endPointOfLine2 = new int[]{12,15,60};//9 11.5 4
    static double[] intersectionPoint = new double[3];
    static double[] intersectionPoint1 = new double[3];
    static double[][] map = new double[3][3];
    public static void main (String[]args){
        interPoint();
        System.out.println("Intersection Point of lines:");
        System.out.println("Point with x="+intersectionPoint[0]+"; y="+intersectionPoint[1]+"; z="+intersectionPoint[2]);
        System.out.println("OR");
        System.out.println("Point with x="+intersectionPoint1[0]+"; y="+intersectionPoint1[1]+"; z="+intersectionPoint1[2]);
        System.out.println("They are aproximetely same.");
    }
    static void interPoint(){
        map[0][0] = endPointOfLine2[0] - startPointOfLine2[0];
        map[0][1] = startPointOfLine1[0] - endPointOfLine1[0];
        map[0][2] = startPointOfLine1[0] - startPointOfLine2[0];
        map[1][0] = endPointOfLine2[1] - startPointOfLine2[1];
        map[1][1] = startPointOfLine1[1] - endPointOfLine1[1];
        map[1][2] = startPointOfLine1[1] - startPointOfLine2[1];
        map[2][0] = endPointOfLine2[2] - startPointOfLine2[2];
        map[2][1] = startPointOfLine1[2] - endPointOfLine1[2];
        map[2][2] = startPointOfLine1[2] - startPointOfLine2[2];
        //pm();
        if((map[1][0]-map[0][0])==0){
            map[1][0]=0;map[1][1]-=map[0][1];map[1][2]-=map[0][2];
        }
        else{
            double div = map[1][0]/map[0][0];
            map[1][0]=0;
            double forLine21 = div * map[0][1];
            map[1][1]-=forLine21;
            double forLine22 = div * map[0][2];
            map[1][2]-=forLine22;
        }
        //pm();
        if((map[2][0]-map[0][0])==0){
            map[2][0]=0;map[2][1]-=map[0][1];map[2][2]-=map[0][2];
        }
        else{
            double div = map[2][0]/map[0][0];
            map[2][0]=0;
            double forLine31 = div * map[0][1];
            map[2][1]-=forLine31;
            double forLine32 = div * map[0][2];
            map[2][2]-=forLine32;
        }
        //pm();
        if((map[2][1]-map[0][1])==0){
            map[2][1]-=map[1][1];map[2][2]-=map[1][2];
        }
        else{
            double div = map[2][1]/map[1][1];
            double forLine33 = div * map[1][1];
            map[2][1]-=forLine33;
            double forLine34 = div * map[1][2];
            map[2][2]-=forLine34;
        }
        
        //pm();
        t = map[1][2] / map[1][1];
        s = (map[0][2] - t*map[0][1])/map[0][0];
        //System.out.println(s+" "+t);
        intersectionPoint[0] = startPointOfLine1[0]+t*(endPointOfLine1[0]-startPointOfLine1[0]);
        intersectionPoint[1] = startPointOfLine1[1]+t*(endPointOfLine1[1]-startPointOfLine1[1]);
        intersectionPoint[2] = startPointOfLine1[2]+t*(endPointOfLine1[2]-startPointOfLine1[2]);
        
        intersectionPoint1[0] = startPointOfLine2[0]+s*(endPointOfLine2[0]-startPointOfLine2[0]);
        intersectionPoint1[1] = startPointOfLine2[1]+s*(endPointOfLine2[1]-startPointOfLine2[1]);
        intersectionPoint1[2] = startPointOfLine2[2]+s*(endPointOfLine2[2]-startPointOfLine2[2]);
        
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
}
