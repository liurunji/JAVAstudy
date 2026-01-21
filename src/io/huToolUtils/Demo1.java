package io.huToolUtils;

import cn.hutool.Hutool;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
/*
        File touch = FileUtil.touch("F:\\ideaProject\\JAVAstudy\\src\\io\\huToolUtils\\aa\\a.txt");
        System.out.println(touch);
*/
        ArrayList<String> list = new ArrayList<>();
        list.add("adekfbke");
        list.add("v考虑国电南瑞买过了安然 ");
        list.add("二合同号柔荑花");
        File f = new File("F:\\ideaProject\\JAVAstudy\\src\\io\\huToolUtils\\aa\\a.txt");
        //FileUtil.writeLines(list,f,"UTF-8",true);
        //FileUtil.appendLines(list,f,"UTF-8");
        List<String> list1 = FileUtil.readLines(f, "UTF-8");
        System.out.println(list1);

    }
}
