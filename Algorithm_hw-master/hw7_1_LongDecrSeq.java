public class hw7_1_LongDecrSeq {
    static int[]b;
    public static void main(String[]args){
        int[]a=new int[]{4,6,2,5,1,7,5,8,4};
        decrArray(a);
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println();
        
    }
    public static void decrArray(int[] a){
        b = new int[a.length];
        for(int i=0;i<b.length;i++){
            b[i]=1;
        }
        
        for(int i = 0;i<a.length;i++){
            for(int j = i-1;j >= 0;j--){
                if(a[i] < a[j]){
                    b[i]=Math.max(b[i], b[j]+1);
                }
            }
        }
    }
    
}
