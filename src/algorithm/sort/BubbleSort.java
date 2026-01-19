package algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 3, 5, 2};

        for (int i = 0; i < arr.length - 1; i++) { //进行n-1轮
            for (int j = 0; j < arr.length - 1 - i; j++) {  //j实际是指针，比较相邻两元素，小的往前，大的往后
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
