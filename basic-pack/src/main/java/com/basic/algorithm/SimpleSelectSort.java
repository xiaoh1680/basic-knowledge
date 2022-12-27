package com.basic.algorithm;

import com.basic.inverse.Pojo.Child;
import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiaohui
 * @Description:
 * @Date: Created in 2018/1/24 16:31
 * @Modified By:
 */
public class SimpleSelectSort {
    private static ThreadLocal t = null;
    /**
     * 简单选择排序
     */
    public static void selectSort(){
        int a[]={1,54,6,3,78,34,12,45};
        int position=0;
        for(int i=0;i<a.length;i++){
            int j=i+1;
            position=i;
            int temp=a[i];
            for(;j<a.length;j++){
                if(a[j]<temp){
                    temp=a[j];
                    position=j;
                }
            }
            a[position]=a[i];
            a[i]=temp;
        }
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }

    /**
     * 冒泡
     */
    public static void  bubbleSort(){
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int temp=0;
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }

    public static void main(String[] args) {
        SimpleSelectSort.bubbleSort();

    }

}
