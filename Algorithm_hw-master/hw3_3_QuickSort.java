//QuickSort
public class hw3_3_QuickSort {
    public static void main (String[]args){
        int[] arr = {4,3,7,6,2,9};
        QuickSort(arr, 0, arr.length-1);
        for(int i:arr){System.out.println(i);}
    }
    static void QuickSort(int[]arr,int left,int right){
        int index = partition(arr,left,right);
        if(left<index-1)
            QuickSort(arr, left, index-1);
        if(index<right)
            QuickSort(arr, index , right);
    }
    static int partition(int[]arr,int left,int right){
        int pivot = arr[(left+right)/2];
        while(left <= right){
            while(arr[left]<pivot)left++;
            while(arr[right]>pivot)right--;
            if(left<=right){
                int tmp = arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;
                left++;
                right--;
            }
        }
        return left;
    }
}
