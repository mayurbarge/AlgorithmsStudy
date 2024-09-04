package arrays;

import java.util.Arrays;

public class RemoveDuplicate {
    public static int remove(int[] array) {
        int nextNonDuplicate = 1;
        for(int i =0; i < array.length; i++) {
            if(array[nextNonDuplicate-1] != array[i]) {
                array[nextNonDuplicate] = array[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,3,3,6,9,9};
        System.out.println(remove(arr));
        Arrays.stream(arr).forEach(e -> System.out.print(e));

    }
}
