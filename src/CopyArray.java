public class CopyArray {
    public static void main(String[] args) {
        /*需求:定义一个方法copyOfRange(int[] arr,int from, int to)
        功能:将数组arr中从索引from(包含from)开始。到索引to结束(不包含to)的元素复制到新数组中将新数组返回。
        */
        int[] arr = {7, 82, 45, 68, 12, 55, 32, 47, 35, 10, 5};
        int[] copyArr = copyOfRange(arr, 2, 5);
        for (int i = 0; i < copyArr.length; i++) {
            System.out.print(copyArr[i] + " ");
        }
    }

    public static int[] copyOfRange(int[] arr, int from, int to) {
        int[] newArr = new int[to - from];
        /*
        for (int i = from; i < to; i++) {
            newArr[i - from] = arr[i];
        }
*/
        //方法2：定义另一个指针

        for (int i = from, j = 0; i < to; i++, j++) {
            newArr[j] = arr[i];
        }
        return newArr;
    }


}
