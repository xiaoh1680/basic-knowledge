package com.basic.jvm.chapter4;


import java.util.ArrayList;
import java.util.List;
import java.nio.channels.Selector;

public class OOMObject {
    static class Test {
        public byte[] placeHholder=new byte[64*1024];
    }
    public static void fillHeap(int num) throws InterruptedException{
        List<Test> list = new ArrayList<>();
        for (int i=0;i<num;i++) {
            Thread.sleep(500);
            list.add(new Test());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception{
        fillHeap(1000);
    }

}
