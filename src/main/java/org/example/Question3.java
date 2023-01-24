package org.example;

public class Question3 {
    public static void main(String[] args) {
        int[] array1 = {1, 4, 3, 6, -2, 5, 55, 3};
        int[] array2 = {4, 6, 5, 3};

        if (isSequencePresent(array1, array2)) {
            System.out.println("array2 sequence is presented in array1");
        } else {
            System.out.println("array2 sequence is not presented in array1");
        }
    }

    public static boolean isSequencePresent(int[] array1, int[] array2) {
        int j = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == array2[j]) {
                j++;
            }
            if (j == array2.length) {
                return true;
            }
        }
        return false;
    }

}

