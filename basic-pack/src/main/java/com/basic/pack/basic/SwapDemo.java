package com.basic.pack.basic;

import java.lang.reflect.Field;

/**
 * Created by xh826 on 2017/11/28.
 */
public class SwapDemo {
        public static void main(String[] args) throws Exception{
            Integer a = 1;
            Integer b = 2;
            System.out.println("a=" + a + ",b=" + b);
            swap(a, b);
            System.out.println("a=" + a + ",b=" + b);
        }

        private static void swap(Integer numa, Integer numb) {
            Integer tmp = numa;
            numa = numb;
            numb = tmp;
            System.out.println("numa=" + numa + ",numb=" + numb);
        }
    private static void swap1(Integer numa, Integer numb) {
        Integer tmp = numa;
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(numa, numb);//成功的将numa 引用的 1的对象 值改为 2
            field.set(numb, tmp); //由于 tmp 也是指向 numa 未改变前指向的堆 即对象1 ，经过前一步，已经将对象1的值改为了2，自然 numb 也是2，所以改动失效
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void swap2(Integer numa, Integer numb) {
        int tmp = numa.intValue();//tmp 定义为基本数据类型
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(numa, numb);//这个时候并不改变 tmp 的值
            field.set(numb, tmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void swap3(Integer numa, Integer numb) {
        int tmp = numa.intValue();
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(numa, numb);
            field.set(numb, new Integer(tmp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
