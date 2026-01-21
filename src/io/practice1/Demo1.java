package io.practice1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        /*
        制造假数据:
获取姓氏:https://hanyu.baidu.com/shici/detail?from=aladdin&pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&smp_names=termBrand2%2Cpoem1
获取男生名字:https://baijiahao.baidu.com/s?id=1744863812577130101&wfr=spider&for=pc
获取女生名字:http://www.haoming8.cn/baobao/7641.html
         */

        //1.定义变量记录网址
        String familyNameUrl = "https://www.unjs.com/fanwenwang/ziliao/552939.html";
        String boyNameUrl = "https://www.buyiju.com/qiming/daquan/218298.html";
        String girlNameUrl = "http://www.haoming8.cn/baobao/7641.html";

        //2.爬取网址中所有数据拼接成字符串
        String familyNameStr = webCrawler_GBK(familyNameUrl);
        String boyNameStr = webCrawler_UTF8(boyNameUrl);
        String girlNameStr = webCrawler_UTF8(girlNameUrl);
        //System.out.println(familyNameStr);
        //System.out.println(boyNameStr);
        //System.out.println(girlNameStr);

        //3.通过正则表达式把真正想要的数据获取出来
        ArrayList<String> familyNameList = getData(familyNameStr, "([\\u4e00-\\u9fa5]{1,2})(\\(.+?\\)){1}", 1);
        //System.out.println(familyNameList);
        ArrayList<String> boyNameTempList = getData(boyNameStr, "([\\u4e00-\\u9fa5]{2})(、)", 1);
        //System.out.println(boyNameTempList);
        ArrayList<String> girlNameTempList = getData(girlNameStr, "([\\u4e00-\\u9fa5]{2} ){4}[\\u4e00-\\u9fa5]{2}", 0);
        //System.out.println(girlNameTempList);

        //4.处理数据
        //这里姓氏的数据不需再处理，已经达到要求了
        //System.out.println(familyNameList);
        //处理男生名字：去重
        //去重可以用集合：①set集合自带的去重  ②list自行判断
        ArrayList<String> boyNameList = new ArrayList<>();
        for (String str : boyNameTempList) {
            if (!boyNameList.contains(str)) {
                //如果boyNameList没有，才加入，这样达到去重的目的
                boyNameList.add(str);
            }
        }
        //System.out.println(boyNameList);
        //处理女生名字：分开来，每个名字自己一组
        //[彤舞 芊静 艾丝 惠蕙 语月, 依莹 瑶馨 曼珍 逸云 微婉, 芳诗 逸抒 半烟 花依 绮灵, 恬影 婉婕 紫茹 宛竹 曼蓉, 梓玥 怡乐 华叶 语珊 亦曼, 暄妍 雅可
        ArrayList<String> girlNameList = new ArrayList<>();
        for (String str : girlNameTempList) {
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                girlNameList.add(arr[i]);
            }
        }
        //System.out.println(girlNameList);

        //5.生成数据
        //姓名（唯一）-性别-年龄
        ArrayList<String> list = generateData(familyNameList, boyNameList, girlNameList, 40, 35);
        System.out.println(list);

        //6.写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\io\\practice1\\names.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.close();
    }

    /*
    作用:获取男生和女生的信息:张三-男-23
形参:
参数一:装着姓氏的集合
参数二:装着男生名字的集合
参数三:装着女生名字的集合
参数四:男生的个数
参数五:女生的个数
     */
    private static ArrayList<String> generateData(ArrayList<String> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int boyCount, int girlCount) {
        //生成不重复的男生名字 使用hashSet
        HashSet<String> boyHashSet = new HashSet<>();
        while (true) {
            if (boyHashSet.size() == boyCount) {
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boyHashSet.add(familyNameList.get(0) + boyNameList.get(0));
        }
        //生成不重复的女生名字 使用hashSet
        HashSet<String> girlHashSet = new HashSet<>();
        while (true) {
            if (girlHashSet.size() == girlCount) {
                break;
            }
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girlHashSet.add(familyNameList.get(0) + girlNameList.get(0));
        }

        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        //生成对应格式男生的数据
        for (String boyName : boyHashSet) {
            //若要求年龄在18-27岁之间，[18,27]  27-18=9  9+1=10  nextInt(10)+18可以表示该范围
            int age = r.nextInt(10) + 18;
            list.add(boyName + "-男-" + age);
        }
        //生成对应格式女生的数据
        for (String girlName : girlHashSet) {
            //若要求年龄在18-25岁之间，[18,25]  25-18=7  7+1=8  nextInt(8)+18可以表示该范围
            int age = r.nextInt(8) + 18;
            list.add(girlName + "-女-" + age);
        }
        Collections.shuffle(list);
        return list;
    }

    /*
    根据正则表达式来获取想要的数据
    参数一：原始数据包含网址中所有的标签以及文字
    参数二:正则表达式
    参数三：分组取哪一组
     */
    private static ArrayList<String> getData(String str, String regex, int index) {
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group(index));
        }
        return list;
    }

    private static String webCrawler_GBK(String url) throws IOException {
        //1.定义stringBuilder存放读到的数据
        StringBuilder sb = new StringBuilder();
        //2.创建URL对象
        URL u = new URL(url);
        //3.连接网址，网址必须畅通可访问
        URLConnection conn = u.openConnection();
        //4.读取数据
        //getInputStream是字节输入流不能读汉字，要用转换流转换成字符流
        InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "GBK");
        int b;
        while ((b = isr.read()) != -1) {
            sb.append((char) b);
        }
        //5.关闭资源
        isr.close();
        //6.返回结果字符串
        return sb.toString();
    }

    private static String webCrawler_UTF8(String url) throws IOException {
        //1.定义stringBuilder存放读到的数据
        StringBuilder sb = new StringBuilder();
        //2.创建URL对象
        URL u = new URL(url);
        //3.连接网址，网址必须畅通可访问
        URLConnection conn = u.openConnection();
        //4.读取数据
        //getInputStream是字节输入流不能读汉字，要用转换流转换成字符流
        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        int b;
        while ((b = isr.read()) != -1) {
            sb.append((char) b);
        }
        //5.关闭资源
        isr.close();
        //6.返回结果字符串
        return sb.toString();
    }
}
