package algorithm.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 3, 5, 2};
        for (int i = 0; i < arr.length - 1; i++) {  //进行n-1轮
            for (int j = i + 1; j < arr.length; j++) { //从他的后一个元素开始比较
                if (arr[i] > arr[j]) {//后面有更小的元素就交换
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
