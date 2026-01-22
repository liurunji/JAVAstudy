package io.practice1;

import cn.hutool.Hutool;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        /*
        使用hutool包完成制造假数据
         */

        //1.定义变量记录网址
        String familyNameUrl = "https://www.unjs.com/fanwenwang/ziliao/552939.html";
        String boyNameUrl = "https://www.buyiju.com/qiming/daquan/218298.html";
        String girlNameUrl = "http://www.haoming8.cn/baobao/7641.html";

        //2.网络爬虫然后获取所需数据
        String familyNameStr = HttpUtil.get(familyNameUrl);
        List<String> familyNameList = ReUtil.findAll("([\\u4e00-\\u9fa5]{1,2})(\\(.+?\\)){1}", familyNameStr, 1);
        System.out.println(familyNameList);

        //后续同上
    }
}
