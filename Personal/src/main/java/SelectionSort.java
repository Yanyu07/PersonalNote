import com.sun.org.apache.bcel.internal.generic.SWAP;


public class SelectionSort {
    public static int[] selectionSort(int[] arr){

        if (arr == null || arr.length < 2) return arr;

        for (int i = 0;i < arr.length ;i++){
            int minIndex = i;
            for (int j = i+1;j < arr.length ;j++){
                minIndex = arr[j] < arr[minIndex]? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
        return arr;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
