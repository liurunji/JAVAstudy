package file;

import java.io.File;

public class Demo6 {
    public static void main(String[] args) {
        File src = new File("D:\\");
        find(src);

    }

    public static void find(File src){
        File[] files = src.listFiles();
        if (files != null){  //有些无权限/隐藏文件夹无法进入会报空指针异常
            for (File file : files) {
                if (file.isFile()){
                    //如果是文件则再次进行判断是否是.avi
                    if (file.getName().endsWith(".jpg")){
                        System.out.println(file);
                    }
                }else {
                    //如果不是文件那就是文件夹，那就继续往里面递归
                    find(file);
                }
            }
        }
    }
}
