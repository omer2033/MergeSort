import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        int[] array = {3, 1, 2, 57, 3, 7, 324, 876, 12321, 5232, 21, 432, 12};
        mergeSort(array);
        printArray(array);
    }
    private static void mergeSort(int[] array){

        int arrayLen = array.length;
        int midIndex = arrayLen /2 ;
        if(arrayLen < 2){
            return;
        }

        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrayLen - midIndex];

        for(int i = 0; i < midIndex; ++i){
            leftHalf[i] = array[i];
        }
        for(int i = midIndex; i < arrayLen; i++){
            rightHalf[i-midIndex] = array[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(array,leftHalf,rightHalf);
    }
    
    private static void merge(int[] array, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, k = 0, j =0;
        while(i < leftSize && j < rightSize){
            if(leftHalf[i] <= rightHalf[j]){
                array[k] = leftHalf[i];
                i++;
            }
            else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize){
            array[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize){
            array[k] = rightHalf[j];
            j++;
            k++;
        }
    }
    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

}