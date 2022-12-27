package com.basic.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaohui
 * @Description: 制造hash碰撞
 * @Date: Created in 2018/1/1 16:44
 * @Modified By:
 */
public class HashDemo {
    private String name;
    private int age;
    private static Map<HashDemo, String> map = new HashMap<>();

    public HashDemo(String name,int age) {
        this.name=name;
        this.age=age;
    }

    @Override
    public int hashCode() {
        return age%4;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HashDemo) {
            return this.age==((HashDemo) obj).age&&this.name.equals(((HashDemo) obj).name);
        }
        return false;
    }

    public static void main(String[] args) {
        HashDemo demo1 = new HashDemo("xiaohui",7);
        HashDemo demo2 = new HashDemo("xiaohui",11);
        HashDemo demo3 = new HashDemo("xiaohui",15);
        map.put(demo1, "xiaohui1");
        map.put(demo2, "xiaohui2");
        map.put(demo3, "xiaohui3");
        System.out.println(map.get(demo1));
        System.out.println(map.get(demo2));
        System.out.println(map.get(demo3));
    }

}
