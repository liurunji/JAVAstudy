public class ExistOrNot {
    public static void main(String[] args) {
        //定义一个方法判断数组中的某一个数是否存在，将结果返回给调用处
        int[] arr={1,2,3,4,5,6,7,8,9};
        int a = 50;
        System.out.println(exist(arr,a));
    }

    public static boolean exist(int[] arr,int a){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == a)
                return true;
        }
        return false;
    }

}
