package com.basic.inverse;

import com.basic.inverse.Pojo.Child;
import com.basic.inverse.Pojo.Girl;
import com.basic.inverse.Pojo.Person;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * @Author: xiaohui
 * @Description:
 * @Date: Created in 2017/12/21 17:33
 * @Modified By:
 */
public class GenericityDemo {

    public void getType(Object t) {
//        List<Object> list = new ArrayList();
        try {
//            Object a = t.getClass().newInstance();
//            BeanUtils.copyProperties(new Child("xiaohui","sdfd"),a);
//            list.add(a);

            Person girl=(Person)t.getClass().newInstance();
            System.out.println(girl.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        GenericityDemo genericityDemo = new GenericityDemo();
        genericityDemo.getType(new Girl());
    }

}
