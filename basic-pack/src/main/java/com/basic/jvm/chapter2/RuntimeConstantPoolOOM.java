package com.basic.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * jdk1.6中可以抛出outofmemoryError:permGen space
 * jdk1.7无限循环
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
