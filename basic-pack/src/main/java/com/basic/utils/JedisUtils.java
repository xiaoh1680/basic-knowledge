package com.basic.utils;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JedisUtils {

    public static void main(String[] args) {
//        List<String> list = getCSVData();
//        //创建一个连接
        Jedis jedis = new Jedis("localhost", 6379);
//        //ping一下Redis服务端是否在线，成功则返回 “PONG” 反之报错超时
//        long startWrite=System.currentTimeMillis();
//        for (String s : list) {
//            jedis.lpush("testCollections", s);
//        }
//        long endWrite=System.currentTimeMillis();
//        System.out.println("start times:"+startWrite);
//        System.out.println("end times:" + endWrite);
//        System.out.println("write times:" + (endWrite - startWrite));

        long startRead=System.currentTimeMillis();
//        List<String> stringList=jedis.lrange("testCollections", 100, 101);
        for (int i = 0; i < 1000; i++) {
            jedis.get("age");
        }
        long endRead=System.currentTimeMillis();
        System.out.println("start times:"+startRead);
        System.out.println("end times:" + endRead);
        System.out.println("read times:" + (endRead - startRead));
        jedis.close();//关闭连接

    }

    public static ArrayList<String> getCSVData() {
        File csv = new File("D:\\work\\demo\\user_flag.csv"); // CSV文件路径
        csv.setReadable(true);//设置可读
        csv.setWritable(true);//设置可写
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        ArrayList<String> allString = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                everyLine = line;
                allString.add(everyLine);
            }
            System.out.println("csv表格中所有行数：" + allString.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allString;
    }
}
