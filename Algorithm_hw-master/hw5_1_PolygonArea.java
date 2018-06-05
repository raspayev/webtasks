
import java.util.Scanner;

public class hw5_1_PolygonArea {
    static String[] c;
    static double a1,a2;
    public static void main (String []args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please Input numbers in clockwise order;with ','<ex. 5,6 4,3 2,1>");
        String line = "0,0 0,2 3,3 6,1 4,-2 1,-2";//in.nextLine()
        c = line.split(" ");
        area1();
        area2();
        System.out.println("General Formula With coordinates: " + a1);
        System.out.println("General Formula With triangles: " + a2);
    }
    static void area1(){
        int verx = 0;
        int x = Integer.parseInt(c[0].split(",")[0]);
        int y = Integer.parseInt(c[0].split(",")[1]);
        for(int i = 1;i<c.length;i++){
            //System.out.println(i);
            verx += x * Integer.parseInt(c[i].split(",")[1])- y * Integer.parseInt(c[i].split(",")[0]);
            x = Integer.parseInt(c[i].split(",")[0]);y = Integer.parseInt(c[i].split(",")[1]);
        }
        verx += x * Integer.parseInt(c[0].split(",")[1])- y * Integer.parseInt(c[0].split(",")[0]);
        a1 = verx/2;
        if(a1<0)a1*=-1;
    }
    static void area2(){
        String center = center();
        for(int i=0;i<c.length;i++){
            System.out.println(i);
            if(i==c.length-1){
                System.out.println("as");
                a2+=areaOfTriangle(c[i], c[0], center);
                break;
            }
            a2+=areaOfTriangle(c[i], c[i+1], center);
        }
    }
    private static String center(){
        double x=0,y=0;
        for(int i=0;i<c.length;i++){
            x+=Integer.parseInt(c[i].split(",")[0]);
            y+=Integer.parseInt(c[i].split(",")[1]);
        }
        //System.out.println("x: "+x);
        //System.out.println("y: "+y);
        x/=Double.parseDouble(String.valueOf(c.length));
        y/=(Double.parseDouble(String.valueOf(c.length)));
        return x+","+y;
    }
    private static double areaOfTriangle(String to4ka1,String to4ka2,String to4ka3){
        double areatai=0;
        double ax = Double.parseDouble(to4ka1.split(",")[0]);
        double ay = Double.parseDouble(to4ka1.split(",")[1]);
        double bx = Double.parseDouble(to4ka2.split(",")[0]);
        double by = Double.parseDouble(to4ka2.split(",")[1]);
        double cx = Double.parseDouble(to4ka3.split(",")[0]);
        double cy = Double.parseDouble(to4ka3.split(",")[1]);
        double vverx = ax*(by-cy)+bx*(cy-ay)+cx*(ay-by);
        areatai=vverx/2.0;
        if(areatai<0)areatai*=-1;
        return areatai;
    }
}
