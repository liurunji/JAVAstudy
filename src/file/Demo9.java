package file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Demo9 {
    public static void main(String[] args) {
        /*
        需求:统计一个文件夹中每种文件的个数并打印。
        (考虑子文件夹)打印格式如下:
        txt:3个
        doc:4个
        jpg:6个
         */

        File f = new File("F:\\研究生\\算法分析\\期末\\算法");
        HashMap<String, Integer> c = getCount(f);
        c.forEach((s, i) -> System.out.println(s + ":" + i + "个"));

    }

    public static HashMap<String, Integer> getCount(File f) {
        HashMap<String, Integer> hm = new HashMap<>();
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) { //是文件
                    String fileName = file.getName();
                    int index = fileName.lastIndexOf(".");  //lastIndexof获取最后一个.所在的索引位置
                    String suffix = fileName.substring(index);  //截取最后一个.到最后 即文件的后缀名

                    if (hm.containsKey(suffix)) {
                        //已经存在这个键（后缀）
                        Integer count = hm.get(suffix);
                        count = count + 1;
                        hm.put(suffix, count);
                    } else {
                        //不存在这个后缀
                        hm.put(suffix, 1);
                    }
                } else {
                    //是文件夹
                    HashMap<String, Integer> sonMap = getCount(file);    //子文件夹里的文件统计到了sonMap中，下面要累加到hm里
                    //遍历sonMap
                    Set<Map.Entry<String, Integer>> entries = sonMap.entrySet();
                    for (Map.Entry<String, Integer> entry : entries) {
                        String key = entry.getKey();
                        if (hm.containsKey(key)){
                            //hm里存在这个后缀，取出对应值进行累加

                            int count = hm.get(key) + entry.getValue();
                            hm.put(key,count);
                        }else {
                            //不存在这个后缀，直接添加
                           // hm.put(key,1);//注意这里不能添加1，sonMap里的值可能不是1，应该添加sonMap里的值
                            hm.put(key, entry.getValue());
                        }
                    }

                }
            }
        }
        return hm;
    }
}
