package com.basic.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20M
 -Xmx20M
 -XX:+HeapDumpOnOutOfMemoryError
 -XX:HeapDumpPath=D:\
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
