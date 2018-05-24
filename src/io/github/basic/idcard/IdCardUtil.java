package io.github.basic.idcard;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zsx at 18-5-4 下午3:18
 */
public class IdCardUtil {
    public static void main(String[] args) {
        /*
        Properties p = new Properties();
        InputStream in = IdCardUtil.class.getResourceAsStream("code_dict.properties");
        try {
            p.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(p.toString());
        */
        try {
            //不能用相对路径吗???
            //   /home/zsx/ideaWork/pre4offers/
            File f = new File("src/io/github/basic/idcard/code_dict.properties");

            FileInputStream fs = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fs);
            HashMap<String, String[]> regionDict = (HashMap<String, String[]>) ois.readObject();
//            HashMap<String, String> o = (HashMap<String, String>) ois.readObject();
//            System.out.println(o.getClass().getName());


            for (String e : regionDict.get("371482")){
                System.out.println(e);
            }


//            int count = 0;
//            for (String k:regionDict.keySet()) {
//                if (count == 10) break;
//                System.out.println(regionDict.get(k).getClass().getTypeName());
//                for (String i: regionDict.get(k).keySet()) {
//                    System.out.println(regionDict.get(k).get(i).toString());
//                }
//                count++;
//            }

//            regionDict.forEach((key, value) -> {
//                System.out.println(key + " - " );///+ String.valueOf(value));
//            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
