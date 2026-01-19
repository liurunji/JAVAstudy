package algorithm.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {7, 5, 1, 4, 8, 6, 2};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void quickSort(int[] arr, int i, int j) {
        int start = i;//i是第一个元素指针
        int end = j;//j是最后一个元素指针

        //递归结束的条件 也就是出口
        if (start > end) {
            return;
        }

        int baseNumber = arr[i];//基准值为首元素
        while (start < end) {//只有当start<end(start!=end)时进入循环
            //必须先用end往前找，不可以先用start往后找
            //用end往前找比基准值还小的数
            while (true) {
                if (start >= end || arr[end] < baseNumber) {
                    //当找到了比基准值还小的数时,跳出此while循环，也就是end不用再往前找
                    break;
                }
                end--;//没找到比基准值还小的就继续向前找
            }

            //用start往后找比基准值还大的数
            while (true) {
                if (start >= end || arr[start] > baseNumber) {
                    //当找到了比基准值还大的数时,跳出此while循环，也就是start不用再往后找
                    break;
                }
                start++;//没找到比基准值还大的就继续向后找
            }

            //交换start和end所指元素位置
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        //跳出大循环意味着找到了基准元素要放到的位置，那个位置就是start和end所指向的位置
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;

        //继续递归调用自身，处理左半部分和右半部分子表
        quickSort(arr, i, start - 1);//左边部分
        quickSort(arr, start + 1, j);//右边部分
    }
}
