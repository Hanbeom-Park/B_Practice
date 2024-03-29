import java.util.Arrays;
public class RadixSort {    
    public static void main(String[] args) {
        int[] array=  { 142, 243, 21, 13, 11,7, 86 };
        System.out.println("정렬 전 : " + Arrays.toString(array));
        radixSort(array);        
    }    
    public static void radixSort(int[] array) {
        final int MAX_LENGTH = RadixSort.getMaxLength(array), myArrLen = array.length;
        int myRadix = 1;
        int[] sortedArray = new int[myArrLen], counts;
        for (int p = 0; p < MAX_LENGTH; p++) {
            counts = new int[10];
            for (int numOfTemp : array) {
                counts[(numOfTemp / myRadix) % 10]++;
            }
            for (int i = 1; i < 10; i++)
                counts[i] += counts[i - 1];
            for (int i = myArrLen - 1; i >= 0; i--) {
                sortedArray[counts[(array[i] / myRadix) % 10]-- - 1] = array[i];
            }
            array = sortedArray;
            sortedArray = new int[myArrLen];
            myRadix *= 10;
        }
        System.out.println("정렬 후 : " + Arrays.toString(array));        
    }    
    public static int getMaxLength(int[] array) {
        int max = 0;
        for (int numOfTemp : array) {
            if (max < numOfTemp)
                max = numOfTemp;
        }
        return (int) Math.log10((double) max) + 1;
    }
}